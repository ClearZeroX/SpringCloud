package com.zlc.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : ZLC
 * @create : 2019-03-26 14:20
 * @desc : 使用feign
 **/
@FeignClient(value = "eureka-client", fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/eurekaClient/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name")String name);

}
