package com.zlc.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @author : ZLC
 * @create : 2019-03-26 15:19
 * @desc : feign自带断路器实现返回类
 **/
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi{

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
