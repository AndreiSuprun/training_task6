package com.suprun.bookstorage.model.dao;

import com.suprun.bookstorage.model.entity.Book;
import com.suprun.bookstorage.model.exception.BookDaoException;

import java.util.List;
import java.util.Optional;

public interface BookListDao {

    List<Book> addBook(Book book) throws BookDaoException;

    List<Book> removeBook(Book book) throws BookDaoException;

    List<Book> findById(int value);

    List<Book> findByName(String value);

    List<Book> findByAuthors(String value);

    List<Book> findByPublisher(String value);

    List<Book> findByPublishYear(int value);

    List<Book> findByPageQuantity(int value);

    List<Book> sortById();

    List<Book> sortByName();

    List<Book> sortByAuthors();

    List<Book> sortByPublisher();

    List<Book> sortByPublishYear();

    List<Book> sortByPageQuantity();
}

