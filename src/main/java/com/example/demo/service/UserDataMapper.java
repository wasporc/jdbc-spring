package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Data Mapper
@Service
public class UserDataMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Function<Map<String, Object>, User> functionEntity =
            stringObjectMap -> User.builder()
                    .id((Long) stringObjectMap.get("id"))
                    .name((String) stringObjectMap.get("first_name"))
                    .email((String) stringObjectMap.get("login"))
                    .build();

    public List<User> getAll(){
        List<Map<String, Object>> maps =
                jdbcTemplate.queryForList("select * from public.users");
        if(maps!=null&&maps.size()>0){
            return maps.stream().map(functionEntity).collect(Collectors.toList());
        }else{
            return null;
        }
    }

    public User getById(Long id){
        Map<String, Object> stringObjectMap =
                jdbcTemplate.queryForMap(String.format("select * from public.users where id = %d", id));
        if (stringObjectMap!=null){
            return functionEntity.apply(stringObjectMap);
        }
        return null;
    }
}
