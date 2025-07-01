package com.example.PlaceInfoApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
@SpringBootApplication
public class PlaceInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceInfoApplication.class, args);
	}

}
