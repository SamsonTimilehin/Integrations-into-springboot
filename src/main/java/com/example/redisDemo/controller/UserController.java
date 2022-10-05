package com.example.redisDemo.controller;

import com.example.redisDemo.dto.AddUserDto;
import com.example.redisDemo.dto.AuthUserDto;
import com.example.redisDemo.dto.GenericResponse;
import com.example.redisDemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/demo")
@AllArgsConstructor
public class UserController {


    private UserService userService;

    @PostMapping("/add")
    public GenericResponse addUser(@RequestBody AddUserDto addUserDto){
       return userService.addUser(addUserDto);
    }
    @PostMapping
    public GenericResponse authenticateUser(@RequestBody AuthUserDto authUserDto){
        return userService.authUser(authUserDto);
    }
}
