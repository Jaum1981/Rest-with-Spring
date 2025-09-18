package com.github.jaum1981.controllers;

import com.github.jaum1981.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @RequestMapping("/test")
    public String testLog() {
        logger.debug("testLog debug");
        logger.info("testLog info");
        logger.warn("testLog warn");
        logger.error("testLog error");
        return "testLog generated";
    }

}
