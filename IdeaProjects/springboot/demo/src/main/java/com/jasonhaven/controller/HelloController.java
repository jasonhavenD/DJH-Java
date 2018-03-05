package com.jasonhaven.controller;

import com.jasonhaven.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jasonhaven.Dai on2018/3/4.
 **/

@RestController
public class HelloController {
    @Autowired
    private HelloWorld helloWorld;

    @GetMapping("/index")
    public String index() {
        return "hello/index";
    }


    @GetMapping("/say")
    public String hello() {
        return helloWorld.sayHello();
    }
}
