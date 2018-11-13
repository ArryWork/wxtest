package com.arry.demo.controller;

import com.arry.demo.util.CheckUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WxController {
    @GetMapping("")
    public String test(String signature, String timestamp, String nonce, String echostr){
        if (CheckUtil.checkSignature(signature,timestamp,nonce)) {
            return echostr;
        }
        return null;
    }

    @PostMapping
    public String getXml(String xml){
        System.out.println(xml);
        return "success";
    }

}
