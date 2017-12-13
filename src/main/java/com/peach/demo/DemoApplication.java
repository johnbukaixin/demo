package com.peach.demo;

import com.peach.demo.mqtt.IMqttManager;
import com.peach.demo.mqtt.MqttManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This example uses Spring Boot’s default RedisConnectionFactory,
 * an instance of JedisConnectionFactory which is based on the Jedis Redis library.
 * The connection factory is injected into both the message listener container and the Redis template.
 */
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class DemoApplication {
    private static int x = 100;

    public static final Logger logger = LoggerFactory.getLogger("DemoApplication");

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        IMqttManager mqttManager = ctx.getBean(IMqttManager.class);
//        mqttManager.send("臧三");

        DemoApplication hs1=new DemoApplication();
               hs1.x++;
        DemoApplication  hs2=new DemoApplication();
                 hs2.x++;
                hs1=new DemoApplication();
                 hs1.x++;
        DemoApplication.x--;
               System.out.println("x="+x);
    }
}

