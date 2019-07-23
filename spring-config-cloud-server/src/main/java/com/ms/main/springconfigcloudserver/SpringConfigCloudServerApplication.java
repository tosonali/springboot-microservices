package com.ms.main.springconfigcloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringConfigCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigCloudServerApplication.class, args);
	}

}
