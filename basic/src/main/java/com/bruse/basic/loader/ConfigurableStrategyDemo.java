package com.bruse.basic.loader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurableStrategyDemo {

    public static IService createService() {
        try {
            Properties prop = new Properties();
            String fileName = "D:\\Code\\my\\index\\basic\\src\\main\\java\\com\\bruse\\basic\\loader\\config.properties";
            prop.load(new FileInputStream(fileName));
            String className = prop.getProperty("service");
            Class<?> cls = Class.forName(className);
            return (IService) cls.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        IService service = createService();
        service.action();
    }
}
