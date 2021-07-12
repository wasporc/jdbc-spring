package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//Identity Map
@Component
public class UserOfWork {
    private Map<Long, User> userMap = new HashMap<>();

    @Autowired
    private UserDataMapper userDataMapper;

//    @PostConstruct
//    private void init(){
//        List<User> all = userDataMapper.getAll();
//        all.forEach(this::addUser);
//    }

    public void addUser(User user){
        userMap.put(user.getId(), user);
    }

    public User getUser(Long id){
        User user = userMap.get(id);
        if (user==null){
            user = userDataMapper.getById(id);
            if(user==null) return null;
            else{
                userMap.put(id, user);
                return user;
            }
        }
        return user;
    }
}
