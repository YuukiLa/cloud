package com.yuuki.cloud.cloudcustom.api;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yuuki.cloud.cloudcustom.client.MsgClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "getMsgFallBack")
public class FeignController {


    @Autowired
    MsgClient msgClient;


    @GetMapping("/msg")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String getMsg(){
        return msgClient.getMsg();
    }


    public String getMsgFallBack(){
        return "触发服务降级...";
    }

    @PostMapping("/param")
    public String getMsgAndParam(String param){
        return msgClient.getMsgAndParam(param);
    }


}
