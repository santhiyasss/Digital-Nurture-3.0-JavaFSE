package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Loading Spring Application Context ===");

        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Spring Context Loaded Successfully ===");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("\n--- Testing Dependency Injection ---");
        System.out.println("BookRepository injected: " +
            (bookService.getBookRepository() != null ? "YES" : "NO"));

        System.out.println("\n--- Testing BookService Operations ---");
        bookService.addBook("Spring in Action");
        bookService.addBook("Clean Code");
        bookService.getBook("Spring in Action");
        bookService.removeBook("Clean Code");

        System.out.println("\n=== Dependency Injection Test Completed Successfully ===");

        ((ClassPathXmlApplicationContext) context).close();
    }
}