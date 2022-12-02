package com.nhnacademy.config;

import com.nhnacademy.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class, excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {

    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/HumanRelation");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1q2w3e4r");
        basicDataSource.setInitialSize(2);
        basicDataSource.setMaxTotal(10);

        basicDataSource.setMaxWaitMillis(1000);

        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setTestOnReturn(true);
        basicDataSource.setTestWhileIdle(true);

        return basicDataSource;
    }
}