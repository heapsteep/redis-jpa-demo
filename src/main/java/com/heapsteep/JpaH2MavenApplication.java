package com.heapsteep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpaH2MavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaH2MavenApplication.class, args);
	}
}
