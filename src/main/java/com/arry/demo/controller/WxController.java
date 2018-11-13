package com.arry.demo.controller;

import com.arry.demo.util.CheckUtil;
import com.arry.demo.util.XmlUtil;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/index.html")
public class WxController {
    @GetMapping("")
    public String test(String signature, String timestamp, String nonce, String echostr){
        if (CheckUtil.checkSignature(signature,timestamp,nonce)) {
            return echostr;
        }
        return null;
    }

    @PostMapping
    public String getXml(String xml, HttpServletRequest request) throws Exception {
        Map map = XmlUtil.parseXml(request);
        System.out.println(map);
        return "test";
    }

}
