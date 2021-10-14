package com.yy.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 14:53 2021/10/13
 *Description : 
 *Version     : 
 ***/
@Component
@EnableBinding({Sink.class})
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    private void input(Message<String> message){
        System.out.println("消费者1号，------------"+ message.getPayload()+"\t serverPort:"+serverPort);
    }
}
