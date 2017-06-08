package com.may.boot.controller;

import com.may.boot.entity.MongoUser;
import com.may.boot.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by May on 3/30/17.
 */

@RestController
@RequestMapping("/mongoTests")
public class MongoTestController {
    @Autowired
    private MongoUserRepository mongoUserRepository;

    @RequestMapping("/firstNames")
    public MongoUser findByFirstName(String firstName) {
        MongoUser mongoUser = mongoUserRepository.findByFirstName("may");
        if (null == mongoUser) {
            mongoUser = new MongoUser();
            mongoUser.setFirstName("may");
            mongoUser.setLastName("xiao");
            mongoUserRepository.save(mongoUser);
            return null;
        }


        return mongoUser;


    }
}
