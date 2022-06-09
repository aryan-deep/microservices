package com.iratechnology.applicationgateway.applicationgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationgatewayApplication.class, args);
	}

}
