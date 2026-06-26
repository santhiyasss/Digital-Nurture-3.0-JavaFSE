package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
        System.out.println("=== Library Management Spring Boot App Started ===");
        System.out.println("API available at: http://localhost:8080/api/books");
        System.out.println("H2 Console at:   http://localhost:8080/h2-console");
    }
}