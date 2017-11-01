package com.turvo.locationtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.turvo.locationtracking.*")
@EnableAutoConfiguration
public class Appconfig {

	public static void main(String[] args) {
		SpringApplication.run(Appconfig.class, args);
	}
}
