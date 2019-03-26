改为使用develop分支开发

第二篇: 服务消费者（rest+ribbon）(Finchley版本) service-ribbon
    restTemplate.getForObject(“http://SERVICE-HI/eurekaClient/hi?name=”+name,String.class)方法时，
已经做了负载均衡，访问了不同的端口的服务实例。

第三篇: 服务消费者 Feign (Finchley版本)
    1、依赖: Feign的起步依赖spring-cloud-starter-feign
            Eureka的起步依赖spring-cloud-starter-netflix-eureka-client
            Web的起步依赖spring-boot-starter-web
    2、@EnableFeignClients注解开启Feign的功能
    3、定义接口通过@FeignClient(value="服务名") 来调用哪个服务
