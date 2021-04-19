package com.hwt.turntable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TurntableApplication {
    private static final Logger logger = LoggerFactory.getLogger(TurntableApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TurntableApplication.class);
        logger.info("run.getClass() = " + run.getClass());
    }
}
