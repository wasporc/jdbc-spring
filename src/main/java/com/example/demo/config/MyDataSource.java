package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MyDataSource {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String name;
    @Value("${db.password}")
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
