package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter DI");
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void addBook(String title) {
        bookRepository.saveBook(title);
        System.out.println("BookService: Book added successfully - " + title);
    }

    public void getBook(String title) {
        String result = bookRepository.getBook(title);
        System.out.println("BookService: " + result);
    }

    public void removeBook(String title) {
        bookRepository.deleteBook(title);
        System.out.println("BookService: Book removed successfully - " + title);
    }
}