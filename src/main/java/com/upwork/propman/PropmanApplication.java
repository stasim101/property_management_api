package com.upwork.propman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PropmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropmanApplication.class, args);
	}

}
