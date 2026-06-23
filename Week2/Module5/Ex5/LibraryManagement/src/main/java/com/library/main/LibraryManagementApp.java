package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Initializing Spring IoC Container ===");

        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== IoC Container Started Successfully ===");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("\n--- Testing IoC Container ---");
        bookService.addBook("Spring Framework in Practice");
        bookService.addBook("Learning Spring Boot");
        bookService.findBook("Spring Framework in Practice");

        System.out.println("\n=== Spring IoC Container Test Completed ===");

        ((ClassPathXmlApplicationContext) context).close();
    }
}