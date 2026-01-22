package com.example.journalApp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public <T> T get(String key, Class <T> entityclass){
        try{
            Object obj = redisTemplate.opsForValue().get(key);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(obj.toString(),entityclass);
        } catch(Exception e){
            log.error("Exception: ", e);
            return null;
        }
    }
    public void set(String key, Object o, Long ttl ) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonValue = objectMapper.writeValueAsString(o);
            redisTemplate.opsForValue().set(key, jsonValue, ttl, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Error occurred at {} :",key,e);
        }
    }
}
