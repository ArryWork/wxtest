package com.arry.demo.controller;

import com.arry.demo.util.CheckUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WxController {
    @RequestMapping("")
    public String test(String signature, String timestamp, String nonce, String echostr){
        if (CheckUtil.checkSignature(signature,timestamp,nonce)) {
            return echostr;
        }
        return null;
    }
}
