package com.bruse.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Topic;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private JmsProducer jmsProducer;

    @RequestMapping("/send")
    public void send() {
        Destination destination = new ActiveMQQueue("springboot.queue.test");
        for (int i = 0; i < 10; i++) {
            jmsProducer.sendMessage(destination, "hello,world!" + i);
        }
    }

    @RequestMapping("/sendTopic")
    public void sendTopic() {
        Topic topic = new ActiveMQTopic("springboot.topic.test");
        for (int i = 0; i < 10; i++) {
            jmsProducer.sendTopic(topic, "hello,world!" + i);
        }
    }
}
