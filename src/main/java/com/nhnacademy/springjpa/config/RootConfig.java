package com.nhnacademy.springjpa.config;

import com.nhnacademy.springjpa.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/spring-jpa;DATABASE_TO_UPPER=false;MODE=LEGACY;"
                + "INIT=RUNSCRIPT FROM 'classpath:/script/schema.sql'");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(10);
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(10);

        dataSource.setMaxWaitMillis(1000);

        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);

        return dataSource;
    }

}
