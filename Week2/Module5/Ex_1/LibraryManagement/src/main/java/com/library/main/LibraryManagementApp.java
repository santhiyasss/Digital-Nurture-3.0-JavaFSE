package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook("Spring in Action");
        bookService.addBook("Clean Code");
        bookService.getBook("Spring in Action");

        System.out.println("Spring Application Context loaded successfully!");

        ((ClassPathXmlApplicationContext) context).close();
    }
}