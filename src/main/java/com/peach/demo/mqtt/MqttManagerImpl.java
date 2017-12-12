package com.peach.demo.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by panta on 2017/12/12.
 */
@Service("mqttManagerImpl")
public class MqttManagerImpl implements IMqttManager{

    @Autowired
    private MqttConfig config;

    private MqttClient client;

    private MqttMessage mqttMessage;

    private MemoryPersistence persistence = new MemoryPersistence();

    private boolean flag = false;


    @Override
    public boolean start() {
        return false;
    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public void send(String message) {
        mqttMessage = new MqttMessage(message.getBytes());
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (connect()){
                    mqttMessage.setQos(config.getQos());
                    try {
                        client.publish("zhangsan",mqttMessage);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return ;
    }

    @Override
    public boolean send(String topicName, String message) {
        if (connect()){

        }
        return false;
    }

    @Override
    public boolean connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setPassword(config.getPassword().toCharArray());
        options.setUserName(config.getUser());
        options.setCleanSession(true);
        try {
            client = new MqttClient(config.getBrokerUrl(),config.getClientId(),persistence);
            client.connect(options);
            flag = true;
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isConnect(boolean flag) {
        return flag;
    }

    @Override
    public boolean subscribe() {
        return false;
    }

    @Override
    public boolean unSubscribe() {
        return false;
    }

    @Override
    public boolean publish() {
        return false;
    }
}
