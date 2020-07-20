package com.suprun.bookstorage.model.dao.impl;

import com.suprun.bookstorage.model.dao.BookListDao;
import com.suprun.bookstorage.model.entity.Book;
import com.suprun.bookstorage.model.exception.BookDaoException;
import com.suprun.bookstorage.model.store.BookStorage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookListDaoImpl implements BookListDao {

    @Override
    public List<Book> addBook(Book book) throws BookDaoException {
        BookStorage bookStorage = BookStorage.getInstance();
        boolean isAdded = bookStorage.addBook(book);
        if (!isAdded) {
            throw new BookDaoException("Book is already in storage");
        }
        return bookStorage.getBooks();
    }

    @Override
    public List<Book> removeBook(Book book) throws BookDaoException {
        BookStorage bookStorage = BookStorage.getInstance();
        boolean isRemoved = bookStorage.removeBook(book);
        if (!isRemoved){
            throw new BookDaoException("Removed book is not found in storage");
        }
        return bookStorage.getBooks();
    }

    @Override
    public List<Book> findById(int id) {
        List<Book> booksById = new ArrayList<>();
        for (Book book : BookStorage.getInstance().getBooks()){
            if (book.getId() == id){
                booksById.add(book);
            }
        }
        return booksById;
    }

    @Override
    public List<Book> findByName(String name) {
        List<Book> booksByName = new ArrayList<>();
        for (Book book : BookStorage.getInstance().getBooks()){
            if (book.getName().toUpperCase().contains(name.toUpperCase())){
                booksByName.add(book);
            }
        }
        return booksByName;
    }

    @Override
    public List<Book> findByAuthors(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : BookStorage.getInstance().getBooks()){
            for (String bookAuthor : book.getAuthors()){
                if (bookAuthor.toUpperCase().contains(author.toUpperCase())){
                booksByAuthor.add(book);
                }
            }
        }
        return booksByAuthor;
    }

    public List<Book> findByPublisher(String publisher){
        List<Book> booksByPublisher = new ArrayList<>();
        for (Book book : BookStorage.getInstance().getBooks()){
            if (book.getPublisher().toUpperCase().equals(publisher.toUpperCase())){
                booksByPublisher.add(book);
            }
        }
        return booksByPublisher;
    }

    public List<Book> findByPublishYear(int publishYear){
        List<Book> booksByPublishYear = new ArrayList<>();
        for (Book book : BookStorage.getInstance().getBooks()){
            if (book.getPublishYear() == publishYear){
                booksByPublishYear.add(book);
            }
        }
        return booksByPublishYear;
    }

    public List<Book> findByPageQuantity(int pageQuantity){
        List<Book> booksByPageQuantity = new ArrayList<>();
        for (Book book : BookStorage.getInstance().getBooks()){
            if (book.getPageQuantity() == pageQuantity){
                booksByPageQuantity.add(book);
            }
        }
        return booksByPageQuantity;
    }

    @Override
    public List<Book> sortById() {
        List<Book> books = BookStorage.getInstance().getBooks();
        books.sort(Comparator.comparingInt(Book::getId));
        return books;
    }

    @Override
    public List<Book> sortByName() {
        List<Book> books = BookStorage.getInstance().getBooks();
        books.sort(Comparator.comparing(Book::getName));
        return books;
    }

    @Override
    public List<Book> sortByAuthors() {
        List<Book> books = BookStorage.getInstance().getBooks();
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                int compare = 0;
                int index = 0;
                List<String> list1 = book1.getAuthors();
                list1.sort(String::compareTo);
                List<String> list2 = book2.getAuthors();
                list2.sort(String::compareTo);
                while (index  < list1.size() && index<list2.size()){
                    if ((compare = (list1.get(index)).compareTo((list2.get(index)))) !=0) {
                        return compare;
                    }
                    index++;
                }
                return compare;
            }
        });
        return books;
    }

    @Override
    public List<Book> sortByPublisher() {
        List<Book> books = BookStorage.getInstance().getBooks();
        books.sort(Comparator.comparing(Book::getPublisher));
        return books;
    }

    @Override
    public List<Book> sortByPublishYear() {
        List<Book> books = BookStorage.getInstance().getBooks();
        books.sort(Comparator.comparingInt(Book::getPublishYear));
        return books;
    }

    @Override
    public List<Book> sortByPageQuantity() {
        List<Book> books = BookStorage.getInstance().getBooks();
        books.sort(Comparator.comparingInt(Book::getPageQuantity));
        return books;
    }
}