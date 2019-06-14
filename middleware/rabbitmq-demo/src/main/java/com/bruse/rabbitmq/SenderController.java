package com.bruse.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sender")
public class SenderController {

    @Autowired
    private Sender sender;

    @RequestMapping("/hello")
    public void hello() throws Exception {
        sender.send();
    }
}
