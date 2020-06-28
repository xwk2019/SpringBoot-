package com.gzst.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/hello")
public class Welcome {
    @Autowired
    @RequestMapping("/welcome")
    public String welcome() {

        return "welcome to SpringBoot";
    }

}


