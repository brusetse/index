package com.bruse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Book implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean
{

    private String bookName;

    public Book() {
        System.out.println("Book()");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        System.out.println("Book.setBookName");
        this.bookName = bookName;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware.setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware.setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware.setApplicationContext");
    }

    /**
     * 以下几个方法为初始化和销毁回调的多种实现
     * (还有xml中定义 init-method 和 destroy-method)
     * 初始化顺序： @PostConstruct -> afterPropertiesSet -> init-method
     * 销毁顺序： @PreDestroy -> destory -> destory-method
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destory");
    }

    /**
     * 自定义初始化方法
     */
    public void myPostConstruct() {
        System.out.println("init-method myPostConstruct");
    }

    /**
     * PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行。
     */
    @PostConstruct
    public void springPostConstruct() {
        System.out.println("@PostConstruct");
    }

    /**
     * 自定义销毁方法
     */
    public void myPreDestroy() {
        System.out.println("destroy-method myPreDestory");
        System.out.println("---------------destroy-----------------");
    }

    @PreDestroy
    public void springPreDestroy() {
        System.out.println("@PreDestroy");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("------inside finalize-----");
    }
}
