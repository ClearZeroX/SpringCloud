改为使用develop分支开发

第二篇: 服务消费者（rest+ribbon）(Finchley版本) service-ribbon

restTemplate.getForObject(“http://SERVICE-HI/eurekaClient/hi?name=”+name,String.class)方法时，
已经做了负载均衡，访问了不同的端口的服务实例。