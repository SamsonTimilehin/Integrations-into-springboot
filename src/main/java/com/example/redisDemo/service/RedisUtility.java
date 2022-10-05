package com.example.redisDemo.service;

import com.example.redisDemo.dto.AuthUserDto;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RedisUtility {

    @Qualifier("redisTemplate")
    private RedisTemplate<String,String> redisTemplate;


    private Gson gson;

    public void setValue(final String key, AuthUserDto authUserDto){
        redisTemplate.opsForValue().set(key, gson.toJson(authUserDto));
        redisTemplate.expire(key,10, TimeUnit.MINUTES);
    }
    public AuthUserDto getValue(final String key){
        return gson.fromJson(redisTemplate.opsForValue().get(key),AuthUserDto.class);
    }
    public void deleteKeyformredis(String key){
        redisTemplate.delete(key);
    }
}
