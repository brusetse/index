package com.bruse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

    private static Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    public static void main(String[] args) {
        logger.info("This is INFO.");
        logger.warn("This is WARN.");
        logger.error("This is ERROR.");
        logger.debug("This is DEBUG.");
    }
}
