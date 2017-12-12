package com.peach.demo.mqtt;

/**
 * Created by panta on 2017/12/12.
 */
public interface IMqttManager {
    boolean start();

    boolean stop();

    boolean send(String message);

    boolean send(String topicName, String message);

    boolean connect();

    boolean isConnect();

    boolean subscribe();

    boolean unSubscribe();

    boolean publish();
}
