// src/main/java/com/example/demo/DemoApplication.java
package com.example.demo;

import com.example.demo.service.store.StoreQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(StoreQueryService storeService) {
		return args -> {
			String name  = "요아정";
			Float  score = 4.0f;

			System.out.println("=== Query 결과 ===");
			storeService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);
		};
	}
}
