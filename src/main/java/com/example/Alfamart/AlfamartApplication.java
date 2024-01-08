package com.example.Alfamart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlfamartApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfamartApplication.class, args);
		System.out.println("Aplication Running in Port : 8001 " );
	}

}
