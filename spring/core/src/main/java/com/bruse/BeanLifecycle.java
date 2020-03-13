package com.bruse;

import com.bruse.bean.Book;
import com.bruse.bean.SubBook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycle {

    public static void main(String[] args) {
        // Bean生命周期加载过程
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println("---------------running-----------------");
        ((ClassPathXmlApplicationContext) context).close();

        System.out.println();
        System.out.println("---------------完整的加载过程-----------------");
        // 完整的加载过程，当然了解的越多越好
        ApplicationContext subcontext = new ClassPathXmlApplicationContext("subbean-lifecycle.xml");
        SubBook subbook = subcontext.getBean("subbook", SubBook.class);
        System.out.println("---------------subbook running-----------------");
        ((ClassPathXmlApplicationContext) subcontext).close();
    }
}
