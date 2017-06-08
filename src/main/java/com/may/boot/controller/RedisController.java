package com.may.boot.controller;

import com.may.boot.entity.User;
import com.may.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by May on 3/29/17.
 */
@RestController
@RequestMapping("/redistest")
public class RedisController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {

        return userService.findById(id);
    }
}
