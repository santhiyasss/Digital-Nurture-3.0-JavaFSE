package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.saveBook(title);
        System.out.println("BookService: Book added successfully - " + title);
    }

    public void getBook(String title) {
        String result = bookRepository.getBook(title);
        System.out.println("BookService: " + result);
    }
}