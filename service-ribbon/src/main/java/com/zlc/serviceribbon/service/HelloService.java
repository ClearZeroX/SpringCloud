package com.zlc.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : ZLC
 * @create : 2019-03-26 11:13
 * @desc :
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /*在ribbon中使用熔断器*/
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        System.out.println("service-ribbon");
        return restTemplate.getForObject("http://EUREKA-CLIENT/eurekaClient/hi?name="+ name,String.class);
    }

    public String hiError(String name){
        return "hi,"+name+",sorry,error!";
    }
}
