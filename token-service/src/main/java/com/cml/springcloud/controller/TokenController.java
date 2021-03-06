package com.cml.springcloud.controller;

import com.cml.springcloud.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class TokenController {

    @Value("${spring.application.name:test}")
    private String port;
    @Value("${server.port:555}")
    private String sererName;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private TokenService tokenService;


    @ResponseBody
    @RequestMapping("/info")
    public Object info() {
        return client.getServices();
    }

    @ResponseBody
    @RequestMapping("/getToken")
    public String getToken() {
        return tokenService.pop();
    }

}
