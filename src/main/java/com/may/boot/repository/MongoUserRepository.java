package com.may.boot.repository;

import com.may.boot.entity.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by May on 3/30/17.
 */
public interface MongoUserRepository extends MongoRepository<MongoUser,String>{


    MongoUser findByFirstName(String firstName);
}
