package com.arry.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/wx")
public class WxController {
    @RequestMapping("/")
    public String test(){
        return "Hello";
    }
}
