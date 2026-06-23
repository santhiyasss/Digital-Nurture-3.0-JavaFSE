package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for IoC container injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("IoC: BookRepository injected into BookService");
    }

    public void addBook(String title) {
        bookRepository.saveBook(title);
        System.out.println("BookService: Book added - " + title);
    }

    public void findBook(String title) {
        String result = bookRepository.findBook(title);
        System.out.println("BookService: " + result);
    }
}