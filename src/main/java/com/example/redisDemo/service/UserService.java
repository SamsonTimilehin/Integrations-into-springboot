package com.example.redisDemo.service;

import com.example.redisDemo.dto.AddUserDto;
import com.example.redisDemo.dto.AuthUserDto;
import com.example.redisDemo.dto.GenericResponse;
import com.example.redisDemo.model.RedisUser;
import com.example.redisDemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  UserRepository userRepository;

  private RedisUtility redisUtility;

  //Register

    public GenericResponse addUser(AddUserDto addUserDto){
        RedisUser user = new RedisUser();
        user.setEmailId(addUserDto.getEmailId());
        user.setPassword(addUserDto.getPassword());
        return new GenericResponse("User successfully registered", userRepository.save(user));
    }
  //Login
    public GenericResponse authUser(AuthUserDto authUserDto){
        //Getting value
        AuthUserDto authUserDto1 = redisUtility.getValue(authUserDto.getEmailId());
        if(authUserDto1 == null){
            if(userRepository.findByEmailIdAndPassword(authUserDto.getEmailId(), authUserDto.getPassword()).isPresent()){
                //Set Value to Redis
                redisUtility.setValue(authUserDto.getEmailId(),authUserDto);
                return new GenericResponse("Getting data from database",authUserDto);
            }
            return new GenericResponse("No value found", authUserDto);
        }
        return new GenericResponse("Getting data from redis server", authUserDto1);
    }
}
