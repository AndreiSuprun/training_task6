package com.suprun.bookstorage.service;

import com.suprun.bookstorage.creator.BookCreator;
import com.suprun.bookstorage.dao.BookListDao;
import com.suprun.bookstorage.dao.impl.BookListDaoImpl;
import com.suprun.bookstorage.entity.Book;
import com.suprun.bookstorage.exception.BookDaoException;
import com.suprun.bookstorage.exception.BookServiceException;
import com.suprun.bookstorage.validator.BookValidator;

import java.util.*;

public class BookStorageService {

    private BookListDao bookListDao = new BookListDaoImpl();
    private BookCreator creator = new BookCreator();
    private BookValidator validator = new BookValidator();

    public Map<String, Object> addBook(Map<String, String> request) throws BookServiceException {
        Book book = creator.receiveBook(request);
        boolean isAdded;
        try {
            isAdded = bookListDao.addBook(book);
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("addbook", isAdded);
        return response;
    }

    public Map<String, Object> removeBook(Map<String, String> request) throws BookServiceException {
        Book book = creator.receiveBook(request);
        boolean isRemoved;
        try{
            isRemoved = bookListDao.removeBook(book);
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("removebook", isRemoved);
        return response;
    }

    public Map<String, Object> findById(Map<String, String> params) {
        int id = validator.validateInt(params.get("id"));
        Optional<List<Book>> books = bookListDao.findById(id);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("findbyid", books);
        return response;
    }

    public Map<String, Object> findByName(Map<String, String> params) {
        String name = validator.validateString(params.get("name"));
        Optional<List<Book>> books = bookListDao.findByName(name);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("findbyname", books);
        return response;
    }

    public Map<String, Object> findByAuthors(Map<String, String> params) {
        String author = validator.validateString(params.get("authors"));
        Optional<List<Book>> books = bookListDao.findByAuthors(author);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("findbyauthors", books);
        return response;
    }

    public Map<String, Object> findByPublisher(Map<String, String> params) {
        String publisher = validator.validateString(params.get("publisher"));
        Optional<List<Book>> books = bookListDao.findByPublisher(publisher);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("findbypublisher", books);
        return response;
    }

    public Map<String, Object> findByPublishYear(Map<String, String> params) {
        int publishYear = validator.validateInt(params.get("publishyear"));
        Optional<List<Book>> books = bookListDao.findByPublishYear(publishYear);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("findbypublishyear", books);
        return response;
    }

    public Map<String, Object> findByPageQuantity(Map<String, String> params) {
        int pageQuantity = validator.validateInt(params.get("pagequantity"));
        Optional<List<Book>> books = bookListDao.findByPageQuantity(pageQuantity);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("findbypagequantity", books);
        return response;
    }

    public Map<String, Object> sortById(Map<String, String> request) {
        boolean sortOrder = validator.validateBoolean(request.get("sortorder"));
        List<Book> books = bookListDao.sortById();
        if (!sortOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("sortbyid", books);
        return response;
    }

    public Map<String, Object> sortByName(Map<String, String> request) {
        boolean sortOrder = validator.validateBoolean(request.get("sortorder"));
        List<Book> books = bookListDao.sortByName();
        if (!sortOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("sortbyname", books);
        return response;
    }

    public Map<String, Object> sortByAuthors(Map<String, String> request) {
        boolean sortOrder = validator.validateBoolean(request.get("sortorder"));
        List<Book> books = bookListDao.sortByAuthors();
        if (!sortOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("sortbyauthors", books);
        return response;
    }

    public Map<String, Object> sortByPublisher(Map<String, String> request) {
        boolean sortOrder = validator.validateBoolean(request.get("sortorder"));
        List<Book> books = bookListDao.sortByPublisher();
        if (!sortOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("sortbypublisher", books);
        return response;
    }

    public Map<String, Object> sortByPublishYear(Map<String, String> request) {
        boolean sortOrder = validator.validateBoolean(request.get("sortorder"));
        List<Book> books = bookListDao.sortByPublishYear();
        if (!sortOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("sortbypublishyear", books);
        return response;
    }

    public Map<String, Object> sortByPageQuantity(Map<String, String> request) {
        boolean sortOrder = validator.validateBoolean(request.get("sortorder"));
        List<Book> books = bookListDao.sortByPageQuantity();
        if (!sortOrder) {
            Collections.reverse(books);
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("sortbypagequantity", books);
        return response;
    }
}