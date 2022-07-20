package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
   @GetMapping("/test")
    public String test(){
     /*  User user = jdbcTemplate
               .queryForObject("SELECT *" +
                       "\tFROM tblschema.\"user\"", User.class);*/

       List<User> user = jdbcTemplate.query("SELECT *" +
               "\tFROM tblschema.\"user\"", new BeanPropertyRowMapper<User>(User.class));
        return "UserController" +user.stream().map(User::getName).findFirst().get();
    }
}
