package com.limstar.musinsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MusinsaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusinsaApplication.class, args);
	}
}
