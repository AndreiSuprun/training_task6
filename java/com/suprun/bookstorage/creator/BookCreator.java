package com.suprun.bookstorage.creator;

import com.suprun.bookstorage.entity.Book;
import com.suprun.bookstorage.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookCreator {

    private final static BookValidator VALIDATOR = new BookValidator();

    public Book receiveBook(Map<String, String> params) {
        String name = VALIDATOR.validateString(params.get("name"));
        List<String> authors = receiveBookAuthors(params.get("authors"));
        String publisher = VALIDATOR.validateString(params.get("publisher"));
        int publishYear = VALIDATOR.validateInt(params.get("publishyear"));
        int pageQuantity = VALIDATOR.validateInt(params.get("pagequantity"));
        Book book = new Book(name, authors, publisher, publishYear, pageQuantity);
        return book;
    }

    private List<String> receiveBookAuthors(String input) {
        String[] authorsArray = input.split(", ");
        List<String> authors = new ArrayList<>();
        for(String author: authorsArray){
            authors.add(VALIDATOR.validateString(author));
        }
        return authors;
    }
}
