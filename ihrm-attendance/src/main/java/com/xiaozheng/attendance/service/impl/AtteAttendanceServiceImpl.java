package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.xiaozheng.attendance.dao.AtteAttendanceDao;
import com.xiaozheng.attendance.feign.EmployeeApi;
import com.xiaozheng.attendance.service.AtteAttendanceConfigService;
import com.xiaozheng.attendance.service.AtteAttendanceService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.DateUtils;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.common.utils.excel.ExcelImportUtil;
import com.xiaozheng.model.atte.AtteAttendanceConfigEntity;
import com.xiaozheng.model.atte.AtteAttendanceEntity;
import com.xiaozheng.model.bo.AtteAttendanceBo;
import com.xiaozheng.model.em.EmUserCompanyPersonalEntity;
import com.xiaozheng.model.vo.atte.AtteUploadVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 考勤表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteAttendanceService")
public class AtteAttendanceServiceImpl extends ServiceImpl<AtteAttendanceDao, AtteAttendanceEntity> implements AtteAttendanceService {

    @Autowired
    private EmployeeApi employeeApi;

    @Autowired
    private AtteAttendanceConfigService atteAttendanceConfigService;

    @Value("${atte.holidays}")
    private String holidays;

    @Value("${atte.wordingDays}")
    private String wordingDays;

    @Override
    public PageUtils<AtteAttendanceEntity> queryPage(AtteAttendanceEntity atteAttendance,Map<String, Object> params) {
        IPage<AtteAttendanceEntity> page = this.page(
                new Query<AtteAttendanceEntity>().getPage(params),
                Wrappers.query(atteAttendance)
        );
        return new PageUtils(page);
    }

    /**
     * 考勤数据Excel导入
     *
     * @param file
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean importExcel(MultipartFile file) throws Exception {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        //1.将导入的excel文件解析为vo的list集合
        List<AtteUploadVo> atteUploadVos = new ExcelImportUtil<AtteUploadVo>(AtteUploadVo.class).readExcel(file.getInputStream(), 1, 0);
        // 获取导入数据中给手机号
        Set<String> mobiles = atteUploadVos.stream().map(AtteUploadVo::getMobile).collect(Collectors.toSet());
        //2根据上传的手机号码查询用户
        // 远程调用获取用户信息
        R<List<EmUserCompanyPersonalEntity>> listR = employeeApi.getByMobile(mobiles);
        if (listR.getCode() != ResultCode.SUCCESS.code() || CollectionUtils.isEmpty(listR.getData())) {
            throw new CommonException(ResultCode.FAIL);
        }
        // 通过手机号对查询到的用户进行分组
        Map<String, EmUserCompanyPersonalEntity> employeeDetailMap = listR.getData().stream().collect(Collectors.groupingBy(EmUserCompanyPersonalEntity::getMobile, Collectors.collectingAndThen(Collectors.toList(), v -> v.get(0))));
        // 通过企业ID查询考勤配置表，并根据部门ID进行分组
        Map<String, AtteAttendanceConfigEntity> configEntityMap = atteAttendanceConfigService.list(Wrappers.<AtteAttendanceConfigEntity>lambdaQuery()
                .eq(AtteAttendanceConfigEntity::getCompanyId, companyId)).stream().collect(Collectors.groupingBy(AtteAttendanceConfigEntity::getDepartmentId, Collectors.collectingAndThen(Collectors.toList(), v -> v.get(0))));

        // 考勤记录集合
        List<AtteAttendanceEntity> attendances = Lists.newArrayList();
        // 考勤日期集合
        List<String> days = Lists.newArrayList();
        // 考勤用户ID集合
        List<String> userIds = Lists.newArrayList();

        //2.1循环list集合
        for (AtteUploadVo item : atteUploadVos) {
            //2.2构造考勤对象
            AtteAttendanceEntity atteAttendanceEntity = new AtteAttendanceEntity();
            BeanUtils.copyProperties(item, atteAttendanceEntity);
            // 设置日期
            atteAttendanceEntity.setDay(item.getAtteDate());

            days.add(item.getAtteDate());
            EmUserCompanyPersonalEntity emUserCompanyPersonalEntity = employeeDetailMap.get(item.getMobile());
            BeanUtils.copyProperties(emUserCompanyPersonalEntity, atteAttendanceEntity);
            userIds.add(atteAttendanceEntity.getUserId());
            //2.3判断是否休假
            /**
             * 1.将国家的假日记录到数据库
             * 2.文件
             */
            if(holidays.contains(item.getAtteDate())) {
                //休息
                atteAttendanceEntity.setAdtStatu(23);
            }else if(DateUtils.isWeekend(item.getAtteDate()) && !wordingDays.contains(item.getAtteDate())){
                atteAttendanceEntity.setAdtStatu(23);
            }else{
                // 2.4 判断迟到,早退的状态
                // i 查询当前员工部门的上班时间,查询当前员工部门的下班时间
                AtteAttendanceConfigEntity atteAttendanceConfig = configEntityMap.get(atteAttendanceEntity.getDepartmentId());
                //ii 比较,上班时间是否晚于规定上班时间 (迟到)
                //第一个参数 : 规定时间 , 第二参数 : 打卡时间
                if(!DateUtils.comparingDate(atteAttendanceConfig.getAfternoonStartTime(),item.getInTime())) {
                    //迟到
                   atteAttendanceEntity.setAdtStatu(3);
                }else if(DateUtils.comparingDate(atteAttendanceConfig.getAfternoonEndTime(),item.getOutTime())) {
                    //早退
                   atteAttendanceEntity.setAdtStatu(4);
                } else{
                    //正常
                   atteAttendanceEntity.setAdtStatu(1);
                }
            }
            attendances.add(atteAttendanceEntity);
        }
        this.remove(Wrappers.<AtteAttendanceEntity>lambdaUpdate()
                .eq(AtteAttendanceEntity::getCompanyId, companyId)
                .in(AtteAttendanceEntity::getMobile, mobiles)
                .in(CollectionUtils.isNotEmpty(days), AtteAttendanceEntity::getDay, days)
                .in(CollectionUtils.isNotEmpty(days), AtteAttendanceEntity::getUserId, userIds));
        //2.5 删除已经有考勤记录后,保存数据库
        return this.saveBatch(attendances);
    }

    /**
     * 分页条件查询用户考勤
     * @param atteAttendance
     * @param params
     * @return
     */
    @Override
    public PageUtils<AtteAttendanceBo> queryAtte(AtteAttendanceEntity atteAttendance, Map<String, Object> params) {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        IPage<AtteAttendanceBo> page = baseMapper.queryAtte(
                new Query<AtteAttendanceBo>().getPage(params),
                atteAttendance,
                companyId
        );
        return new PageUtils(page);
    }

    /**
     * 修改考勤数据
     *
     * @param atteAttendance
     * @return
     */
    @Override
    public boolean updateOrSave(AtteAttendanceEntity atteAttendance) throws CommonException {
        if (StringUtils.isNotBlank(atteAttendance.getId())) {
            // id 不为空表面有数据，直接更新
            return baseMapper.updateById(atteAttendance) > 0;
        } else {
            // 根据用户ID查询用户信息
            R<EmUserCompanyPersonalEntity> entityR = employeeApi.info(atteAttendance.getUserId());
            if (entityR.getCode() != ResultCode.SUCCESS.code() || Objects.isNull(entityR.getData())) {
                throw new CommonException(ResultCode.FAIL);
            }
            BeanUtils.copyProperties(entityR.getData(),atteAttendance);
            // 保存考勤记录
            return baseMapper.insert(atteAttendance) > 0;
        }
    }
}