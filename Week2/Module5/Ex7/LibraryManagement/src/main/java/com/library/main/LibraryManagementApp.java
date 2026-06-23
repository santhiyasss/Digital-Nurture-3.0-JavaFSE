package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Loading Spring Context ===");

        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Spring Context Loaded ===\n");

        // Test Constructor Injection
        System.out.println("--- Testing Constructor Injection ---");
        BookService constructorService =
            (BookService) context.getBean("bookServiceConstructor");
        constructorService.addBook("Spring in Action");
        constructorService.findBook("Spring in Action");

        System.out.println();

        // Test Setter Injection
        System.out.println("--- Testing Setter Injection ---");
        BookService setterService =
            (BookService) context.getBean("bookServiceSetter");
        setterService.addBook("Clean Code");
        setterService.findBook("Clean Code");

        System.out.println("\n=== Constructor and Setter Injection Test Completed ===");

        ((ClassPathXmlApplicationContext) context).close();
    }
}