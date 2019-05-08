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

第四篇: 断路器(Hystrix) (Finchley版本)
    1、在ribbon中使用
    2、依赖: spring-cloud-starter-netflix-hystrix的起步依赖
    3、@EnableHystrix开启Hystrix
    4、@HystrixCommand注解。该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法, 出现问题时将返回熔断方法中返回的内容.

    1、在feign中使用断路器
    2、feign中自带断路器, 默认关闭, 配置文件中打开
        feign.hystrix.enabled=true
    3、在@FeignClient注解的接口的注解中加上fallback的指定类就行了
    4、3中指定类需要实现@FeignClient注解的接口, 并注入IOC容器中.

第五篇: 路由网关(zuul) (Finchley版本)
    1、路由作用:
        1、依赖: spring-cloud-starter-netflix-zuul的起步依赖
        2、@EnableZuulProxy，开启zuul的功能
        3、配置文件: #以/api-a/开头的请求转发给service-ribbon 以/api-b/开头的请求转发给service-feign
            zuul:
              routes:
                api-a:
                  path: /api-a/**
                  serviceId: service-ribbon
                api-b:
                  path: /api-b/**
                  serviceId: service-feign

    2、服务过滤:
        1、创建过滤器, 继承ZuulFilter

第六篇: 分布式配置中心(Spring Cloud Config) (Finchley版本)
    在SpringCloudConfig项目上 git: https://github.com/ZhaLC/SpringCloudConfig.git develop分支

第九篇: 服务链路追踪(Spring Cloud Sleuth) (Finchley版)
    1、eureka-client eureka-client2
    2、依赖:
        spring-cloud-starter-zipkin的起步依赖
    3、zipkin监控页面:
        运行 java -jar zipkin-server-2.10.1-exec.jar
        localhost:9411
    4、配置文件:
        指定zipkin server的地址
        spring.zipkin.base-url=http://localhost:9411

第十篇: 高可用的服务注册中心(Finchley版本)
    1、eureka-server eureka-client
    2、依赖: 无新增依赖
    3、服务端新增配置:
        application-peer1.yml
        application-peer2.yml
        然后客户端配置向peer1注册服务时, peer2启动时也会发现服务
    4、TODO 貌似是两个两个服务端相互注册, 暂时没太懂先这样理解




