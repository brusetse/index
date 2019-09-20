package com.bruse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

    private static Logger logger = LogManager.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        logger.info("This is INFO.");
        logger.warn("This is WARN.");
        logger.error("This is ERROR.");
        logger.debug("This is DEBUG.");
    }
}
