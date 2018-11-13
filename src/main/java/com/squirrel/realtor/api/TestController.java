package com.squirrel.realtor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
class TestBean {
    public String beanName = "Test Bean Name";
}

@RestController
public class TestController {

    @Autowired
    public TestBean testBean;

    @RequestMapping("api/test")
    public String testMethod() {
        return "This is a Test message, bean Name = " + testBean.beanName;
    }
}