package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("db")
public class TestDBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public String dbTest(){
        List<Map<String, Object>> maps =
                jdbcTemplate.queryForList("select id, first_name from public.users");
        if(maps!=null&&maps.size()>0){
            Map<String, Object> stringObjectMap = maps.get(0);
            return (String) stringObjectMap.get("first_name");
        }
        return "nothing";
    }
}
