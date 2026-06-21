package com.library.repository;

public class BookRepository {

    public String getBook(String title) {
        System.out.println("BookRepository: Fetching book - " + title);
        return "Book: " + title + " fetched from repository";
    }

    public void saveBook(String title) {
        System.out.println("BookRepository: Saving book - " + title);
    }

    public void deleteBook(String title) {
        System.out.println("BookRepository: Deleting book - " + title);
    }
}