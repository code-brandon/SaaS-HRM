package com.xiaozheng.jasperdemo.controller;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.jasperdemo.controller
 * @ClassName: JasperController
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/26 16:43
 */
@RestController
public class JasperController {

    @GetMapping("/testJasper")
    public void createPdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //引入jasper文件。由JRXML模板编译生成的二进制文件，用于代码填充数据
        Resource resource = new ClassPathResource("jasper/test01.jasper");
        //加载jasper文件创建inputStream
        FileInputStream isRef = new FileInputStream(resource.getFile());
        ServletOutputStream sosRef = response.getOutputStream();
        try {
            //创建JasperPrint对象
            JasperPrint jasperPrint = JasperFillManager.fillReport(isRef, new HashMap<>(), new JREmptyDataSource());
            //写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, sosRef);
        } finally {
            sosRef.flush();
            sosRef.close();
        }
    }

    /**
     * 参数Map填充数据
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/v1/testJasper")
    public void createPdfV1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        //引入jasper文件。由JRXML模板编译生成的二进制文件，用于代码填充数据
        Resource resource = new ClassPathResource("jasper/testParam.jasper");
        //加载jasper文件创建inputStream
        FileInputStream isRef = new FileInputStream(resource.getFile());
        ServletOutputStream sosRef = response.getOutputStream();
        try {
            /**
             * parameters集合中传递的key需要和设计模板中使用的name一致
             */
            HashMap parameters = new HashMap();
            parameters.put("title", "用户详情");
            parameters.put("username", "李四");
            parameters.put("company", "传智播客");
            parameters.put("mobile", "120");
            parameters.put("dept", "讲师");
            //创建JasperPrint对象
            JasperPrint jasperPrint = JasperFillManager.fillReport(isRef, parameters, new JREmptyDataSource());
            //写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, sosRef);
        } finally {
            sosRef.flush();
            sosRef.close();
        }
    }

    //创建数据库Connection
    private Connection getConnection() throws Exception {
        String url = "jdbc:mysql://192.168.56.2:3306/ihrm?characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, "root", "12345678");
        return conn;
    }

    /**
     * 数据源填充数据
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/v2/testJasper")
    public void createPdfV2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        //引入jasper文件。由JRXML模板编译生成的二进制文件，用于代码填充数据
        Resource resource = new ClassPathResource("jasper/BsUserConn.jasper");
        //加载jasper文件创建inputStream
        FileInputStream isRef = new FileInputStream(resource.getFile());
        ServletOutputStream sosRef = response.getOutputStream();
        try {
            //创建JasperPrint对象
            JasperPrint jasperPrint = JasperFillManager.fillReport(isRef, new HashMap(),getConnection());
            //写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, sosRef);
        } finally {
            sosRef.flush();
            sosRef.close();
        }
    }
}
