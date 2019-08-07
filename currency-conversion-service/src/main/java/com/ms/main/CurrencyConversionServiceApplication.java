package com.ms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.ms.main")
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
	
	/* Setup of Sleuth for assigning unique ID to each request. */
	
	  @Bean 
	  public Sampler defaultSampler() 
	  { 
		  return Sampler.ALWAYS_SAMPLE; 
	  }
	 

}
