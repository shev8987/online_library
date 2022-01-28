package com.shev8987.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    private final Environment environment;

    public DataBaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource driverSource = new DriverManagerDataSource();

        driverSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        driverSource.setUrl(environment.getProperty("spring.datasource.url"));
        driverSource.setUsername(environment.getProperty("spring.datasource.username"));
        driverSource.setPassword(environment.getProperty("spring.datasource.password"));

        return driverSource;
    }
}
