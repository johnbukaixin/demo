package com.peach.demo.redis;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by panta on 2017/12/11.
 */
@Data
public class RedisModel implements Serializable{

    private static final long serialVersionUID = -881541737846282461L;
    private String username;

    private int age;

    private int length;
}
