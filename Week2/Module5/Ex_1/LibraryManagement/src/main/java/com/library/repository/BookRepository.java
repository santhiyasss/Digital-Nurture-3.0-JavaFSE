package com.library.repository;

public class BookRepository {

    public String getBook(String title) {
        return "Book: " + title + " fetched from repository";
    }

    public void saveBook(String title) {
        System.out.println("Book saved: " + title);
    }
}