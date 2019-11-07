package com.ms.main.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


import brave.sampler.Sampler;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	/* Setup of Sleuth for assigning unique ID to each request. */
	
	  @Bean 
	  public Sampler defaultSampler() 
	  { 
		  return Sampler.ALWAYS_SAMPLE; 
	  }
	 
}
