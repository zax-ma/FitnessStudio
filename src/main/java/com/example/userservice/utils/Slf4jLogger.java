package com.example.userservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLogger {

    private static Logger logger = LoggerFactory.getLogger(Slf4jLogger.class);


    public static void main(String[] args) {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
    }

}
