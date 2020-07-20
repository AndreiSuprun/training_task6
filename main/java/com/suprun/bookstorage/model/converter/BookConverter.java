package com.suprun.bookstorage.model.converter;

import com.suprun.bookstorage.model.entity.Book;
import com.suprun.bookstorage.model.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookConverter {

    public Book receiveBook(Map<String, String> request) {
        BookValidator validator = new BookValidator();
        String name = validator.validateString(request.get("name"));
        List<String> authors = receiveBookAuthors(request.get("authors"));
        String publisher = validator.validateString(request.get("publisher"));
        int publishYear = validator.validateInt(request.get("publishyear"));
        int pageQuantity = validator.validateInt(request.get("pagequantity"));
        Book book = new Book(name, authors, publisher, publishYear, pageQuantity);
        return book;
    }

    private List<String> receiveBookAuthors(String input) {
        BookValidator validator = new BookValidator();
        String[] authorsArray = input.split(", ");
        List<String> authors = new ArrayList<>();
        for(String author: authorsArray){
            authors.add(validator.validateString(author));
        }
        return authors;
    }
}
