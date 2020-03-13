package com.bruse.bean;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

public class SubBook extends Book implements
        BeanClassLoaderAware,
        EnvironmentAware,
        EmbeddedValueResolverAware,
        ResourceLoaderAware,
        ApplicationEventPublisherAware,
        MessageSourceAware
{

    private String bookSystem;

    public String getBookSystem() {
        return bookSystem;
    }

    public void setBookSystem(String bookSystem) {
        System.out.println("SubBook.setBookSystem");
        this.bookSystem = bookSystem;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware.setBeanClassLoader() 方法被调用了");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("EnvironmentAware.setEnvironment() 方法被调用了");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("EmbeddedValueResolverAware.setEmbeddedValueResolver() 方法被调用了");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("ResourceLoaderAware.setResourceLoader() 方法被调用了");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("ApplicationEventPublisherAware.setApplicationEventPublisher() 方法被调用了");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("MessageSourceAware.setMessageSource() 方法被调用了");
    }
}
