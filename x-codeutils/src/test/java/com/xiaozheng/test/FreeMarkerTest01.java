package com.xiaozheng.test;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.test
 * @ClassName: FreeMarkerTest01
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/29 21:17
 */
public class FreeMarkerTest01 {

    private Connection connection;

    /**
     * 测试文件模板
     * @throws IOException
     * @throws TemplateException
     */
    @Test
    public void test01() throws IOException, TemplateException {
        // 创建配置类
        Configuration configuration = new Configuration();
        // 指定模板加载器，将模板加入缓存中
        FileTemplateLoader fileTemplateLoader = new FileTemplateLoader(new File("src/main/resources/templates"));
        configuration.setTemplateLoader(fileTemplateLoader);
        // 获取模板
        Template template = configuration.getTemplate("templa01.ftl");
        // 构造数据模型
        Map<String, Object> dataModel = new HashMap();
        dataModel.put("username", "xiaozheng");
        // 文件输出
        // template.process(dataModel, new FileWriter(new File("a.txt")));
        template.process(dataModel, new PrintWriter(System.out));
    }

    /**
     * 测试字符串模板
     */
    @Test
    public void test() throws Exception {
        //1.创建配置对象
        Configuration cfg = new Configuration();
        //2.指定加载器
        cfg.setTemplateLoader(new StringTemplateLoader());
        //3.创建字符串模板
        // i.字符串
        String templateString = "欢迎您：${username}";
        // ii.通过字符串创建模板
        Template template = new Template("name1",new StringReader(templateString),cfg);
        //4.构造数据
        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("username","张三");
        //5.处理模板
        template.process(dataModel,new PrintWriter(System.out));
    }

    @Before
    //创建数据库Connection
    public void getConnection() throws Exception {
        String url = "jdbc:mysql://192.168.56.2:3306/ihrm?characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(url, "root", "12345678");
    }

    /**
     * ===========================================DataBaseMetaData 数据库元数据操作===========================================
     * @throws Exception
     */

    //获取数据库基本信息
    @Test
    public void test02() throws Exception {
        //2.获取元数据
        DatabaseMetaData metaData = connection.getMetaData();

        //3.获取数据库基本信息
        System.out.println(metaData.getUserName());

        System.out.println(metaData.supportsTransactions());//是否支持事务

        System.out.println(metaData.getDatabaseProductName());
    }


    //获取数据库列表
    @Test
    public void test03() throws Exception {
        //1.获取元数据
        DatabaseMetaData metaData = connection.getMetaData();
        //2.获取所有数据库列表
        ResultSet rs = metaData.getCatalogs();
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        connection.close();
    }

    //获取指定数据库中的表信息
    @Test
    public void test04() throws Exception {
        //1.获取元数据
        DatabaseMetaData metaData = connection.getMetaData();

        //2.获取数据库中表信息
        /**
         * String catalog, String schemaPattern,String tableNamePattern, String types[]
         *
         *  catalog:当前操作的数据库
         *      mysql:
         *          :ihrm
         *          catalog (ihrm)
         *      oralce:
         *          xxx:1521:orcl
         *          catalog (orcl)
         *   schema：
         *      mysql：
         *          ：null
         *      oracle：
         *          ：用户名（大写）
         *
         *    tableNamePattern：要操作的表
         *      null：查询所有表
         *      不为空：查询目标表
         *
         *    types：类型
         *      TABLE：表
         *      VIEW：视图
         *
         */
        ResultSet rs = metaData.getTables(null, null, null, new String[]{"TABLE"});


        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
    }


    //获取指定表中的字段信息
    @Test
    public void test05() throws Exception {
        DatabaseMetaData metaData = connection.getMetaData();

        //获取表中的字段信息
        /**
         *  catalog
         *  schema
         *  tableName
         *  columnName
         */
        ResultSet rs = metaData.getColumns(null, null, "bs_user", null);

        while (rs.next()) {
            System.out.println(rs.getString("COLUMN_NAME"));
            System.out.println(rs.getString("COLUMN_NAME"));
        }
    }

    /**
     * ===========================================ParameterMetaData 参数元数据操作===========================================
     * @throws Exception
     */

    //sql = SELECT * FROM bs_user WHERE id="1063705482939731968"
    @Test
    public void test06() throws Exception {
        String sql = "select * from bs_user where id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "1063705482939731968");

        //获取参数元数据
        ParameterMetaData metaData = pstmt.getParameterMetaData();

        // 参数个数
        int count = metaData.getParameterCount();

        System.out.println(count);
    }

    /**
     * ===========================================ResultSetMetaData 结果集元数据操作===========================================
     * @throws Exception
     */

    @Test
    public void test07() throws Exception {
        //sql
        String sql = "select * from bs_user where id=?";
        //PreparedStatement
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "1063705482939731968");
        //查询
        ResultSet rs = pstmt.executeQuery();

        //获取结果集元数据
        ResultSetMetaData metaData = rs.getMetaData();

        //获取查询字段个数
        int count = metaData.getColumnCount();

        for(int i =1;i<=count ;i++) {
            //获取列名
            String columnName = metaData.getColumnName(i);
            //获取字段类型 sql类型
            String columnType = metaData.getColumnTypeName(i);
            //获取java类型
            String columnClassName = metaData.getColumnClassName(i);
            System.out.println(columnName+"--"+columnType+"---"+columnClassName);
        }
    }

}
