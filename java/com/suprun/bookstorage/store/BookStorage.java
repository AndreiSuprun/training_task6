package com.suprun.bookstorage.store;

import com.suprun.bookstorage.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookStorage {

    private List<Book> books;

    private static BookStorage instance;

    private BookStorage(){
       // books = todo
    }

    public static BookStorage getInstance(){
        if (instance == null){
            instance = new BookStorage();
        }
        return instance;
    }

    public synchronized boolean addBook(Book book) {
        if (books.contains(book)) {
            return false;
        }
        book.setId(books.size()+1);
        return books.add(book);
    }

    public synchronized boolean removeBook(Book book) {
        if (books.contains(book)) {
            return books.remove(book);
        }
        return false;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}