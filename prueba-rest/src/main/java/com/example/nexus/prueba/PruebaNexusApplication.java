package com.example.nexus.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.nexus.prueba")
public class PruebaNexusApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaNexusApplication.class, args);
	}

}
