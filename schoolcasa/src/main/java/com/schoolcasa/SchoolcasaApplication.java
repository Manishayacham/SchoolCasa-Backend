package com.schoolcasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.schoolcasa.model")
public class SchoolcasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolcasaApplication.class, args);
	}

}
