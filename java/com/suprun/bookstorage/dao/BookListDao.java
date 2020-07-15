package com.suprun.bookstorage.dao;

import com.suprun.bookstorage.entity.Book;
import com.suprun.bookstorage.exception.BookDaoException;

import java.util.List;
import java.util.Optional;

public interface BookListDao {

    boolean addBook(Book book) throws BookDaoException;

    boolean removeBook(Book book) throws BookDaoException;

    Optional<List<Book>> findById(int value);

    Optional<List<Book>> findByName(String value);

    Optional<List<Book>> findByAuthors(String value);

    Optional<List<Book>> findByPublisher(String value);

    Optional<List<Book>> findByPublishYear(int value);

    Optional<List<Book>> findByPageQuantity(int value);

    List<Book> sortById();

    List<Book> sortByName();

    List<Book> sortByAuthors();

    List<Book> sortByPublisher();

    List<Book> sortByPublishYear();

    List<Book> sortByPageQuantity();
}

