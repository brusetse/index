package com.bruse.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

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
}
