package com.yuuki.cloud.cloudprovide.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

    @Value("${env}")
    String env;

    @GetMapping("/msg")
    public String getMsg() {

        return "this is provide msg";
    }

    @PostMapping("/param")
    public String getMsgAndParam(String param){
        return "this is provide msg,param is " + param;
    }


    @GetMapping("/env")
    public String getEnv(){
        return env;
    }

}
