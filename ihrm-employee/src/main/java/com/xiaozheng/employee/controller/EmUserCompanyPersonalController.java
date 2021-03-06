package com.xiaozheng.employee.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.utils.DownloadUtils;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.employee.service.EmUserCompanyPersonalService;
import com.xiaozheng.model.em.EmUserCompanyPersonalEntity;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.*;


/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Api(tags = "员工详细信息")
@RestController
@RequestMapping("em/personal")
@Slf4j
public class EmUserCompanyPersonalController {
    @Autowired
    private EmUserCompanyPersonalService emUserCompanyPersonalService;

    /**
     * 分页条件查询所有数据
     * @param params  请求集合
     * @return 所有数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页码",dataType = "String", paramType = "query",example="1"),
            @ApiImplicitParam(name="limit",value="每页显示记录数",dataType = "String", paramType = "query",example="10")
    })
    @ApiOperation("分页条件查询所有数据")
    @PostMapping("/queryPage")
    public R<Map<String, PageUtils<EmUserCompanyPersonalEntity>>> queryPage(@RequestBody @ApiParam(name="员工详细信息表",value=" 实体对象",required=true) EmUserCompanyPersonalEntity emUserCompanyPersonal, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<EmUserCompanyPersonalEntity> page = emUserCompanyPersonalService.queryPage(emUserCompanyPersonal,params);
        return R.ok("查询成功").data("page",page);
    }


    /**
     * 通过主键查询单条数据
     * @param userId 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value="主键",dataType = "String", paramType = "path",example="1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info/{userId}")
    public R<EmUserCompanyPersonalEntity> info(@PathVariable("userId") String userId){
            EmUserCompanyPersonalEntity emUserCompanyPersonal = emUserCompanyPersonalService.getById(userId);

        return Objects.nonNull(emUserCompanyPersonal) ? R.ok("查询成功").data(emUserCompanyPersonal) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 保存数据
     * @param emUserCompanyPersonal 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="员工详细信息表",value=" 实体对象",required=true) EmUserCompanyPersonalEntity emUserCompanyPersonal){

        return emUserCompanyPersonalService.save(emUserCompanyPersonal) ? R.ok("保存成功").data(true) : R.error(ResultCode.FAIL.code(),"保存失败").data(false);
    }

    /**
     * 保存或更新数据
     * @param emUserCompanyPersonal 实体对象
     * @return 保存或更新数据结果
     */
    @ApiOperation("保存或更新数据")
    @PutMapping("/saveOrUpdate")
    public R<Boolean> saveOrUpdate(@RequestBody @ApiParam(name="员工详细信息表",value=" 实体对象",required=true) EmUserCompanyPersonalEntity emUserCompanyPersonal){
        return emUserCompanyPersonalService.updateOrSave(emUserCompanyPersonal) ? R.ok("保存成功").data(true) : R.error(ResultCode.FAIL.code(),"保存失败").data(false);
    }

    /**
     * 修改数据
     * @param emUserCompanyPersonal 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="员工详细信息表",value=" 实体对象",required=true) EmUserCompanyPersonalEntity emUserCompanyPersonal){

        return emUserCompanyPersonalService.updateById(emUserCompanyPersonal) ? R.ok("修改成功").data(true) : R.error(ResultCode.FAIL.code(),"修改失败").data(false);
    }

    /**
     * 删除数据
     * @param userIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] userIds){

        return emUserCompanyPersonalService.removeByIds(Arrays.asList(userIds)) ? R.ok("删除成功").data(true) : R.error(ResultCode.FAIL.code(),"删除失败").data(false);
    }

    /**
     * 员工PDF导出
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/pdf/{id}")
    public void createPdfV2(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) throws Exception {
        String filename =   id + ".pdf";
        DownloadUtils.addHeader(request, response, null, filename);
        /*response.setContentType("application/pdf");
        response.setHeader("content-disposition", "attachment;filename=\"" + new String(filename.getBytes(), "ISO-8859-1") + "\"");
        response.setHeader("filename", filename);*/
        //引入jasper文件。由JRXML模板编译生成的二进制文件，用于代码填充数据
        Resource resource = new ClassPathResource("jasper/profile.jasper");
        //加载jasper文件创建inputStream
        FileInputStream isRef = new FileInputStream(resource.getFile());
        ServletOutputStream sosRef = response.getOutputStream();
        try {
            Map<String, Object> userCompanyPersonalMap = emUserCompanyPersonalService.getMap(new QueryWrapper<EmUserCompanyPersonalEntity>().eq("user_id", id));
            log.info("userCompanyPersonalMap = " + userCompanyPersonalMap);
            //创建JasperPrint对象
            JasperPrint jasperPrint = JasperFillManager.fillReport(isRef, userCompanyPersonalMap,new JREmptyDataSource());
            //写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, sosRef);
        } finally {
            sosRef.flush();
            sosRef.close();
        }
    }

    /**
     * 根据手机好集合查询用户信息
     * @param mobiles
     * @return
     */
    @ApiOperation("根据手机ID集合查询用户信息")
    @PostMapping("/infosBymobile")
    public R<List<EmUserCompanyPersonalEntity>> getByMobile(@RequestBody Set<String> mobiles)  {
        List<EmUserCompanyPersonalEntity> userCompanyPersonals = emUserCompanyPersonalService.list(Wrappers.<EmUserCompanyPersonalEntity>lambdaQuery().in(EmUserCompanyPersonalEntity::getMobile, mobiles));
        return CollectionUtils.isNotEmpty(userCompanyPersonals) ? R.ok("查询成功").data(userCompanyPersonals) : R.fail("查询失败").data(userCompanyPersonals);
    }


}
