package com.restserviceapi.restaipdemo;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.restserviceapi.restaipdemo")
@EntityScan(basePackages = "com.restserviceapi.restaipdemo.model")
public class RestAPIDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAPIDemoApplication.class, args);
	}

}
