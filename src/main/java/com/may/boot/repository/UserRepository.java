package com.may.boot.repository;

import com.may.boot.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by May on 3/28/17.
 */
public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findByUserName(String userName);
}
