package com.yuuki.cloud.cloudcustom.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateApiController {


    @Autowired
    RestTemplate restTemplatel;


    @GetMapping("/msg")
    public String getMsg(){
        return restTemplatel.getForEntity("http://provide/msg",String.class).getBody();
    }

    @PostMapping("/param")
    public String getMsgAndParam(String param){
        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
        params.add("param",param);
        return restTemplatel.postForEntity("http://provide/param",params,String.class).getBody();
    }


}
