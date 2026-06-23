package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String bookServiceName;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor Injection: BookRepository injected via constructor");
    }

    // Setter Injection
    public void setBookServiceName(String bookServiceName) {
        this.bookServiceName = bookServiceName;
        System.out.println("Setter Injection: bookServiceName set to - " + bookServiceName);
    }

    public String getBookServiceName() {
        return bookServiceName;
    }

    public void addBook(String title) {
        bookRepository.saveBook(title);
        System.out.println("BookService [" + bookServiceName + "]: Book added - " + title);
    }

    public void findBook(String title) {
        String result = bookRepository.findBook(title);
        System.out.println("BookService [" + bookServiceName + "]: " + result);
    }
}