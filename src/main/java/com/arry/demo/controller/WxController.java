package com.arry.demo.controller;

import com.arry.demo.util.CheckUtil;
import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
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
    public String getXml(String xml, HttpServletRequest request) throws IOException {
        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");
        System.out.println(signature);
        System.out.println(nonce);
        System.out.println(timestamp);
        ServletInputStream inputStream = request.getInputStream();
        System.out.println(inputStream);
        System.out.println(xml);
        return "success";
    }

}
