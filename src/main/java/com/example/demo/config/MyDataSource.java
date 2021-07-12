package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MyDataSource {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String name;
    @Value("${spring.datasource.password}")
    private String pass;

    @Bean
    public JdbcTemplate dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        dataSource.setUrl(url);
        dataSource.setUsername(name);
        dataSource.setPassword(pass);

        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }
}
