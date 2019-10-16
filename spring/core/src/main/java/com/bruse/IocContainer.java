package com.bruse;

import com.bruse.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocContainer {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
