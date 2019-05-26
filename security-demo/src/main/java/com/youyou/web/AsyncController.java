package com.youyou.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * create by luoxiaoqing
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/order")
    public Callable<String> test1(){

        logger.info("主线程开始");

        Callable<String> result = new Callable<String>() {
            public String call() throws Exception {
                logger.info("副线程结束");
                Thread.sleep(5000);
                logger.info("副线程结束");
                return "success---------------------";
            }
        };

        logger.info("主线程结束");
        return result;
    }
}
