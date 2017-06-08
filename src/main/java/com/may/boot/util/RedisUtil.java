package com.may.boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by May on 3/29/17.
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate template; //springboot中已经注入了该template


    public void setValue(String key, String value, long time, TimeUnit unit) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        if (!this.template.hasKey(key)) {
            ops.set(key, value, time, unit);
        }
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

    public void removeValue(String key) {
        this.template.delete(key);
    }


}
