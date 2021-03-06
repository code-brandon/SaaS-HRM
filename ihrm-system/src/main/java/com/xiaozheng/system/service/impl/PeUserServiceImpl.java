package com.xiaozheng.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.xiaozheng.common.config.QiniuUploadUtil;
import com.xiaozheng.common.entity.PeUserDto;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.*;
import com.xiaozheng.model.co.CoDepartmentEntity;
import com.xiaozheng.model.pe.PeUserEntity;
import com.xiaozheng.model.vo.pe.PeUsetVo;
import com.xiaozheng.system.dao.PeUserDao;
import com.xiaozheng.system.feign.IhrmCompanyApi;
import com.xiaozheng.system.service.PePermissionService;
import com.xiaozheng.system.service.PeUserService;
import com.xiaozheng.system.utils.BaiduAiUtil;
import io.minio.ObjectWriteResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("peUserService")
@Slf4j
public class PeUserServiceImpl extends ServiceImpl<PeUserDao, PeUserEntity> implements PeUserService {

    @Autowired
    private BaiduAiUtil baiduAiUtil;

    @Autowired
    private IhrmCompanyApi ihrmCompanyApi;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PePermissionService pePermissionService;

    @Override
    public PageUtils<PeUserEntity> queryPage(PeUserEntity peUser, Map<String, Object> params) {
        IPage<PeUserEntity> page = this.page(
                new Query<PeUserEntity>().getPage(params),
                Wrappers.query(peUser)
        );
        return new PageUtils(page);
    }

    /**
     * 通过主键查询单条数据和所关联角色
     *
     * @param id
     * @return
     */
    @Override
    public PeUserEntity infoAndRoleById(String id) {
        return baseMapper.infoAndRoleById(id);
    }

    /**
     * 通过手机号查询用户详情
     *
     * @param mobile
     * @return
     */
    @Override
    public PeUserDto profileByMobile(String mobile) {
        PeUserDto peUserDto = new PeUserDto();
        PeUserEntity peUserEntity = baseMapper.selectOne(new QueryWrapper<PeUserEntity>().eq("mobile", mobile));
        BeanUtils.copyProperties(peUserEntity, peUserDto);

        // 获取权限
        Map<String, Object> permMap = pePermissionService.queryByUserIdOrEnVisible(peUserEntity.getId(), peUserEntity.getLevel());
        peUserDto.setRoles(permMap);

        return peUserDto;
    }

    /**
     * 根据Mobile 查询用户
     *
     * @param mobile
     * @return
     */
    @Override
    public PeUserEntity queryByMobile(String mobile) {
        return baseMapper.selectOne(new QueryWrapper<PeUserEntity>().eq("mobile", mobile));
    }

    /**
     * 用户登录
     *
     * @param usetVo
     * @return
     */
    @Override
    public String login(PeUsetVo usetVo) {
        String id = null;

        try {
            //1.构造登录令牌UsernamePasswordToken
            String md5hashPass = new Md5Hash(EncryptUtils.md5Base64(usetVo.getPassword()), usetVo.getMobile(), 6).toString();
            UsernamePasswordToken passwordToken = new UsernamePasswordToken(usetVo.getMobile(), md5hashPass);
            //2.获取subject
            Subject subject = SecurityUtils.getSubject();
            //3.调用login方法，进入realm完成认证//4.获取sessionId
            subject.login(passwordToken);
            //5.构造返回结果
            id = (String) subject.getSession().getId();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        /*// PeUserEntity peUserEntity = this.queryByMobile(usetVo.getMobile());
        if (Objects.isNull(peUserEntity) || !peUserEntity.getPassword().equals(usetVo.getPassword())) {
            // 登录失败
            return null;
        }
        // 登录成功
        Map<String, Object> map = Maps.newHashMap();
        map.put("companyId", peUserEntity.getCompanyId());
        map.put("companyName", peUserEntity.getCompanyName());
        return jwtUtils.createJwt(peUserEntity.getId(), peUserEntity.getUsername(), map);*/

        return id;
    }

    /**
     * 获取个人信息
     *
     * @param userId
     * @return
     */
    @Override
    public PeUserDto profile(String userId) {
        PeUserDto peUserDto = new PeUserDto();
        PeUserEntity peUserEntity = baseMapper.selectById(userId);
        BeanUtils.copyProperties(peUserEntity, peUserDto);

        // 获取权限
        Map<String, Object> permMap = pePermissionService.queryByUserIdOrEnVisible(peUserEntity.getId(), peUserEntity.getLevel());
        peUserDto.setRoles(permMap);

        return peUserDto;
    }

    /**
     * 保存用户数据
     *
     * @param peUser 实体对象
     * @return 新增结果
     */
    @Override
    public boolean saveAndEncrypt(PeUserEntity peUser) {
        String md5hashPass = ShiroContextUtils.customEncryption(peUser.getPassword(), peUser.getMobile());
        peUser.setPassword(md5hashPass);
        peUser.setLevel("user");
        return baseMapper.insert(peUser) > 0;
    }

    /**
     * Excel导入员工
     *
     * @param file
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean parseExcelToSaveEmployees(MultipartFile file) throws IOException, CommonException {
        List<PeUserEntity> peUsers = Lists.newArrayList();

        PeUserDto profile = ShiroContextUtils.getProfile();
        // 远程调用获取用户部门
        R<List<CoDepartmentEntity>> listR = ihrmCompanyApi.querByCompanyIdAndDepartmentCode(profile.getCompanyId(), null);
        if (listR.getCode() != ResultCode.SUCCESS.code() || CollectionUtils.isEmpty(listR.getData())) {
            throw new CommonException(ResultCode.FAIL);
        }

        Map<String, List<CoDepartmentEntity>> departmentCollect = listR.getData().stream().collect(Collectors.groupingBy(CoDepartmentEntity::getCode));

        // 获取文件流
        InputStream inputStream = file.getInputStream();
        // 根据Excel创建工作簿
        Workbook workbook = new XSSFWorkbook(inputStream);
        // 获取Sheet
        Sheet sheet = workbook.getSheetAt(0);
        // 获取sheet中的每一行和每一个单元格
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            //根据索引获取每一个行
            Row row = sheet.getRow(rowNum);
            Object[] objects = new Object[row.getLastCellNum()];
            for (int cellNum = 1; cellNum < row.getLastCellNum(); cellNum++) {
                // 获取到的每一个单元格
                Cell cell = row.getCell(cellNum);
                Object value = getValue(cell);
                objects[cellNum] = value;
            }
            PeUserEntity peUserEntity = new PeUserEntity();
            peUserEntity.setUsername(objects[1].toString());
            peUserEntity.setMobile(objects[2].toString());
            peUserEntity.setWorkNumber(objects[3].toString().replace(".0", ""));
            peUserEntity.setFormOfManagement(objects[4].toString());
            peUserEntity.setTimeOfEntry(new Date(objects[5].toString()));
            // 用户默认为user
            peUserEntity.setLevel("user");
            if (Objects.nonNull(departmentCollect.get(objects[6].toString())) && Objects.nonNull(departmentCollect.get(objects[6].toString()).get(0))) {
                peUserEntity.setDepartmentId(departmentCollect.get(objects[6].toString()).get(0).getId());
                peUserEntity.setDepartmentName(departmentCollect.get(objects[6].toString()).get(0).getName());
            }
            peUserEntity.setPassword(ShiroContextUtils.customEncryption("123456", peUserEntity.getMobile()));

            peUsers.add(peUserEntity);
        }
        return this.saveBatch(peUsers);
    }

    /**
     * 用户头像上传
     *
     * @param file
     * @param id
     * @return
     */
    @Override
    public String uploadUserAvatar(MultipartFile file, String id) {
        try {
            ObjectWriteResponse objectWriteResponse = MinioUtils.putObject(null, file, file.getOriginalFilename(), file.getContentType());
            String imageAddr = MinioUtils.getBasisUrl() + objectWriteResponse.object();
            PeUserEntity peUserEntity = new PeUserEntity();
            peUserEntity.setId(id);
            peUserEntity.setStaffPhoto(imageAddr);
            baseMapper.updateById(peUserEntity);
            //判断是否已经注册面部信息

            Boolean aBoolean = baiduAiUtil.faceExist(id);
            String imgBase64 = Base64.encode(file.getBytes());
            if (aBoolean) {
                //更新
                baiduAiUtil.faceUpdate(id,imgBase64);
            }else{
                //注册
                baiduAiUtil.faceRegister(id,imgBase64);
            }
            //4.返回
            return imageAddr;
        } catch (Exception e) {
            log.error("用户头像上传出错：{}", e.getMessage());
        }
        return null;
    }

    /**
     * 获取数据
     */
    private static Object getValue(Cell cell) {
        Object value = null;
        switch (cell.getCellType()) {
            case STRING:
                //字符串类型
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                //boolean类型
                value = cell.getBooleanCellValue();
                break;
            case NUMERIC:
                //数字类型（包含日期和普通数字）
                if (DateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue();
                } else {
                    value = cell.getNumericCellValue();
                }
                break;
            case FORMULA:
                //公式类型
                value = cell.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }

    /**
     * 上传到七牛云存储
     * TODO 注册到百度云AI人脸库
     *      1.调用百度云接口，判断当前用户是否已经注册
     *      2.已注册，更新
     *      3.未注册，注册
     */
    public String uploadImage(String id, MultipartFile file) throws IOException {
        //1.根据id查询用户
        PeUserEntity peUserEntity = baseMapper.selectById(id);
        //2.将图片上传到七牛云存储，获取请求路径
        String imgUrl = new QiniuUploadUtil().upload(peUserEntity.getId(), file.getBytes());//上传图片名，图片的byte数组
        //3.更新用户头像地址
        peUserEntity.setStaffPhoto(imgUrl);
        baseMapper.insert(peUserEntity);

        //判断是否已经注册面部信息
        Boolean aBoolean = baiduAiUtil.faceExist(id);
        String imgBase64 = Base64.encode(file.getBytes());
        if (aBoolean) {
            //更新
            baiduAiUtil.faceUpdate(id,imgBase64);
        }else{
            //注册
            baiduAiUtil.faceRegister(id,imgBase64);
        }
        //4.返回
        return imgUrl;
    }

    /**
     * base64编码完成图片存储
     * @param id        ：用户id
     * @param file      ：用户上传的头像文件
     * @return          ：请求路径
     */
    public String uploadImage( MultipartFile file,String id) throws IOException {
        //1.根据id查询用户
        PeUserEntity peUserEntity = baseMapper.selectById(id);
        //2.使用DataURL的形式存储图片（对图片byte数组进行base64编码）
        String encode = "data:image/png;base64," + Base64.encode(file.getBytes());
        System.out.println(encode);
        //3.更新用户头像地址
        peUserEntity.setStaffPhoto(encode);
        baseMapper.insert(peUserEntity);
        //4.返回
        return encode;
    }

}