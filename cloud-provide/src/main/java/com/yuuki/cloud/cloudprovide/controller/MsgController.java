package com.yuuki.cloud.cloudprovide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {


    @GetMapping("/msg")
    public String getMsg() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("end");
        return "this is provide msg";
    }

    @PostMapping("/param")
    public String getMsgAndParam(String param){
        return "this is provide msg,param is " + param;
    }



}
