package com.iblotus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiezhiyan on 3/8/18.
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private Subject subject;

    private Logger logger = LoggerFactory.getLogger(VoteService.class);

    @GetMapping(value = "test")
    public String test(){
        if(subject != null){
            logger.info("nihao");
        }
        return "Hello, World";
    }
}
