package com.may.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.may.boot.entity.User;
import com.may.boot.repository.UserRepository;
import com.may.boot.service.UserService;
import com.may.boot.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by May on 3/29/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User findById(Long id) {
        //先走redis获取
        User user = JSON.parseObject(redisUtil.getValue("userId=" + id), User.class);
        if (null == user) {
            user = userRepository.findOne(id);
            redisUtil.setValue("userId=" + id, JSON.toJSONString(user), 3, TimeUnit.MINUTES);
        }
        return user;

    }
}

