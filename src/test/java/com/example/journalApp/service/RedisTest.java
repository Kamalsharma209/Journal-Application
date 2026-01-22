package com.example.journalApp.service;

import com.example.journalApp.repository.ConfigJournalAppRepository;
import com.example.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class RedisTest {

    @MockitoBean
    private MongoTemplate mongoTemplate;

    @MockitoBean
    private ConfigJournalAppRepository configJournalAppRepository;


    @MockitoBean
    private UserRepository userRepository;

    @MockitoBean
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private RedisTemplate redisTemplate;

    @Disabled
    @Test
    void testSendEmail(){
        redisTemplate.opsForValue().set("email","kamal@gmail.com");
        Object email = redisTemplate.opsForValue().get("email");
        System.out.println(email);

    }
}
