package com.xiaozheng.audit.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages ="com.xiaozheng.audit.dao", sqlSessionTemplateRef = "ihrmSqlSessionTemplate")
public class SqlSessionConfig {

    @Bean("ihrmSqlSessionFactory")
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("ihrmDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);


        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactory.setConfiguration(configuration);


        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/Mapper/audit/**/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Bean(name="ihrmSqlSessionTemplate")
    public SqlSessionTemplate ihrmSqlSessionTemplate(@Qualifier("ihrmSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "ihrmTransactionManager")
    public DataSourceTransactionManager ds2TransactionManager(@Qualifier("ihrmDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
