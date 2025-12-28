package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("monesh"));
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if(encoder.matches("monesh", "$2a$10$3yukPPEIHM0HFIn9MPyr2.93syOlOl.iWhy/a3BFMxGUgPG6RWu7W")){
			System.out.println("password matched");
		}else{
			System.out.println("no match");
		}
	}
}