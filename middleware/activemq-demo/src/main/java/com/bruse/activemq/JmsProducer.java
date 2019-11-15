package com.bruse.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Topic;

/**
 * 消息生产者
 * @author xbc
 * @date 2018/12/20 17:35
 */
@Service
public class JmsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息
     * @param destination 队列
     * @param message 消息
     */
    public void sendMessage(Destination destination, final String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 发送消息
     * @param topic 订阅
     * @param message 消息
     */
    public void sendTopic(Topic topic, final String message) {
        jmsTemplate.convertAndSend(topic, message);
    }
}
