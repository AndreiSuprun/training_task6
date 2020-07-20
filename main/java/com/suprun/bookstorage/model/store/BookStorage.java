package com.suprun.bookstorage.model.store;

import com.suprun.bookstorage.model.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookStorage {

    private List<Book> books;

    private static BookStorage instance;

    private BookStorage(){
        books = new ArrayList<>();
        books.add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                "O'Reilly Media", 2005, 688));
        books.add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                "Addison-Wesley Professional", 2006, 424));
        books.add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                "Addison-Wesley Professional", 2017, 412));
        books.add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                "McGraw-Hill Education", 2018, 1248));
        books.add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
        books.add(new Book(6,"Java Generics and Collections",
                new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                2006, 273));
        books.add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                1994, 416));
        books.add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
        books.add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
        books.add(new Book(10,"Soft Skills: The software developer's life manual",
                new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
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