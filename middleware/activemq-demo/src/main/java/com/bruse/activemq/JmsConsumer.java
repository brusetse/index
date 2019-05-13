package com.bruse.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 * @author xbc
 * @date 2018/12/20 17:36
 */
@Component
public class JmsConsumer {

    /**
     * 接收消息
     * @param message 消息
     */
    @JmsListener(destination = "springboot.queue.test")
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
