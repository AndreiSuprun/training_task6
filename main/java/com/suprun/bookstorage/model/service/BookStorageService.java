package com.suprun.bookstorage.model.service;

import com.suprun.bookstorage.model.converter.BookConverter;
import com.suprun.bookstorage.model.dao.BookListDao;
import com.suprun.bookstorage.model.dao.impl.BookListDaoImpl;
import com.suprun.bookstorage.model.entity.Book;
import com.suprun.bookstorage.model.exception.BookDaoException;
import com.suprun.bookstorage.model.exception.BookServiceException;
import com.suprun.bookstorage.model.validator.BookValidator;

import java.util.*;

public class BookStorageService {

    private BookListDao bookListDao = new BookListDaoImpl();
    private BookConverter converter = new BookConverter();
    private BookValidator validator = new BookValidator();

    public Map<String, Object> addBook(Map<String, String> request) throws BookServiceException {
        Book book = converter.receiveBook(request);
        List<Book> books;
        try {
            books = bookListDao.addBook(book);
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> removeBook(Map<String, String> request) throws BookServiceException {
        Book book = converter.receiveBook(request);
        List<Book> books;
        try{
            books = bookListDao.removeBook(book);
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> findById(Map<String, String> params) {
        int id = validator.validateInt(params.get("id"));
        List<Book> books = bookListDao.findById(id);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> findByName(Map<String, String> params) {
        String name = validator.validateString(params.get("name"));
        List<Book> books = bookListDao.findByName(name);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> findByAuthors(Map<String, String> params) {
        String author = validator.validateString(params.get("authors"));
        List<Book> books = bookListDao.findByAuthors(author);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> findByPublisher(Map<String, String> params) {
        String publisher = validator.validateString(params.get("publisher"));
        List<Book> books = bookListDao.findByPublisher(publisher);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> findByPublishYear(Map<String, String> params) {
        int publishYear = validator.validateInt(params.get("publishyear"));
        List<Book> books = bookListDao.findByPublishYear(publishYear);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> findByPageQuantity(Map<String, String> params) {
        int pageQuantity = validator.validateInt(params.get("pagequantity"));
        List<Book> books = bookListDao.findByPageQuantity(pageQuantity);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> sortById(Map<String, String> request) {
        boolean descendingOrder = validator.validateBoolean(request.get("descending"));
        List<Book> books = bookListDao.sortById();
        if (descendingOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> sortByName(Map<String, String> request) {
        boolean descendingOrder = validator.validateBoolean(request.get("descending"));
        List<Book> books = bookListDao.sortByName();
        if (descendingOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> sortByAuthors(Map<String, String> request) {
        boolean descendingOrder = validator.validateBoolean(request.get("descending"));
        List<Book> books = bookListDao.sortByAuthors();
        if (descendingOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> sortByPublisher(Map<String, String> request) {
        boolean descendingOrder = validator.validateBoolean(request.get("descending"));
        List<Book> books = bookListDao.sortByPublisher();
        if (descendingOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> sortByPublishYear(Map<String, String> request) {
        boolean descendingOrder = validator.validateBoolean(request.get("descending"));
        List<Book> books = bookListDao.sortByPublishYear();
        if (descendingOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }

    public Map<String, Object> sortByPageQuantity(Map<String, String> request) {
        boolean descendingOrder = validator.validateBoolean(request.get("descending"));
        List<Book> books = bookListDao.sortByPageQuantity();
        if (descendingOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("books", books);
        return response;
    }
}