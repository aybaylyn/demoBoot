package com.may.boot.controller;

import com.may.boot.entity.User;
import com.may.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by May on 3/28/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/userNames")
    public List getByUserName(String userName) {
        User u = userRepository.findOne(1L);
        return userRepository.findByUserName(userName);

    }
}
