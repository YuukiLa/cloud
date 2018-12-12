package com.yuuki.cloud.cloudcustom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PROVIDE")
public interface MsgClient {

    @GetMapping("/msg")
    String getMsg();

    @PostMapping("/param")
    String getMsgAndParam(@RequestParam(value = "param") String param);

}
