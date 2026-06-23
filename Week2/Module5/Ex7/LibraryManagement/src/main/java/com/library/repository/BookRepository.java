package com.library.repository;

public class BookRepository {

    public void saveBook(String title) {
        System.out.println("BookRepository: Saving - " + title);
    }

    public String findBook(String title) {
        System.out.println("BookRepository: Finding - " + title);
        return "Book [" + title + "] found";
    }
}