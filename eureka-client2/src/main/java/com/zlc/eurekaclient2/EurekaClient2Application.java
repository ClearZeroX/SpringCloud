package com.zlc.eurekaclient2;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient2Application.class, args);
	}

	private static final Logger LOG = Logger.getLogger(EurekaClient2Application.class.getName());


	@RequestMapping("/hi2")
	public String home(){
		LOG.log(Level.INFO, "hi is being called");
		return "hi i'm miya!";
	}

	@RequestMapping("/miya")
	public String info(){
		LOG.log(Level.INFO, "info is being called");
		return restTemplate.getForObject("http://localhost:8987/eurekaClient/info",String.class);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}


	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}


}
