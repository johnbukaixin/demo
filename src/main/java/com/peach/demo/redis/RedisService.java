package com.peach.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by panta on 2017/12/11.
 */
public abstract class RedisService<T> {

    @Autowired
    protected RedisTemplate<String,Object> template;

    @Resource
    protected HashOperations<String,String,T> hashOperations;
    /**
     * redis中的key
     * @return
     */
    public abstract String getKey();

    /**
     * 删除
     * @param key
     */
    public void delete(String key){
        template.delete(key);
    }

    /**
     * 新增
     * @param key
     * @param o
     * @param expire
     */
    public void put(String key,T o,long expire){
        hashOperations.put(getKey(),key,o);
        if (expire != -1) {
            //设置过期时间
            template.expire(getKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 获得redis库下面的所有key
     * @return
     */
    public Set<String> getAllKey(){
        Set<String> keys = hashOperations.keys(getKey());
        return keys;
    }

    public boolean isKey(String key){
        boolean isKey = hashOperations.hasKey(getKey(),key);
        return isKey;
    }

}
