package com.xiaozheng.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.config
 * @ClassName: DruidConfig
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2020/12/29 11:22
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    //配置Druid的监控
    //1.配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //这里要是配置了springsecurity,要配置.and().csrf().ignoringAntMatchers("/druid/*")或者关闭csrf,要不然登录不了
        Map<String, String> map = new HashMap<>();
        // TODO 设置密码后 老登不进去 不知道哪里问题
        // map.put("loginUsername", "admin");
        // map.put("loginPassword", "123456");
        //默认允许所有访问
        map.put("allow", "");
        //拒绝访问
        map.put("deny", "127.0.0.1");
        bean.setInitParameters(map);
        return bean;
    }

    //2.配置一个web控制的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        //com.alibaba.druid.support.http.WebStatFilter
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //创建对应的过滤器
        bean.setFilter(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        //告诉过滤器那些东西不过滤
        map.put("exclusions", "*.js,*.css,/druid/*");
        //过滤器初始化
        bean.setInitParameters(map);
        //拦截路径    /*：全部
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}