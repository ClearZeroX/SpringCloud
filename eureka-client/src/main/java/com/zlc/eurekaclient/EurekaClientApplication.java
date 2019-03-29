package com.zlc.eurekaclient;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(EurekaClientApplication.class.getName());


	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "zlc") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hi2")
	public String callHome(){
		System.out.println(111);
		return restTemplate.getForObject("http://localhost:8986/eurekaClient2/miya",String.class);
	}

	@RequestMapping("/info")
	public String info(){
		LOG.log(Level.INFO, "calling trace service-hi ");
		return "i'm service-hi";
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
