package com.library.repository;

public class BookRepository {

    public void saveBook(String title) {
        System.out.println("BookRepository: Saving book - " + title);
    }

    public String findBook(String title) {
        System.out.println("BookRepository: Finding book - " + title);
        return "Book [" + title + "] found in repository";
    }
}