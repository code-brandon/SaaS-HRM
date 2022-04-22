package com.xiaozheng.audit.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateDataSoureConfig {

    @Bean(name = "ihrmJdbcTemplate")
    public JdbcTemplate ihrmJdbcTemplate(@Qualifier("ihrmDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
