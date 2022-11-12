package com.role.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RoleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleAppApplication.class, args);
	}

}
