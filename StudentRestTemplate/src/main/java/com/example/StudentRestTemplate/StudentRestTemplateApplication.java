package com.example.StudentRestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRestTemplateApplication.class, args);
	}

}
