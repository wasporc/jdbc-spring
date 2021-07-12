package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("db")
public class TestDBController {

    @Autowired
    private UserOfWork userOfWork;

    @GetMapping("{id}")
    public String dbTest(@PathVariable(value = "id")Long id){
        User user = userOfWork.getUser(id);
        if (user!=null) return user.toString();
        else
        return "nothing";
    }
}
