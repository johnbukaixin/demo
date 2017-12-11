package com.peach.demo.redis;

import org.springframework.stereotype.Service;

/**
 * Created by panta on 2017/12/11.
 */
@Service
public class RedisServiceImpl extends RedisService<RedisModel> {

    private static final String BASE_KEY = "HASH_KEY";
    @Override
    public String getKey() {
        return BASE_KEY;
    }
}
