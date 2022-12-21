package com.codestates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Section3Week2JpaApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "basic");
//		System.setProperty("spring.profiles.active", "table");
//		System.setProperty("spring.profiles.active", "column");
//		System.setProperty("spring.profiles.active", "id-direct");
//		System.setProperty("spring.profiles.active", "id-identity");
//		System.setProperty("spring.profiles.active", "id-sequence");
//		System.setProperty("spring.profiles.active", "one-to-many-uni");
//		System.setProperty("spring.profiles.active", "many-to-many-bi");
//		System.setProperty("spring.profiles.active", "many-to-one-uni");
//		System.setProperty("spring.profiles.active", "many-to-one-bi");

		SpringApplication.run(Section3Week2JpaApplication.class, args);
	}
}
