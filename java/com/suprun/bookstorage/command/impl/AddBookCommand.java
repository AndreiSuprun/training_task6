package com.suprun.bookstorage.command.impl;

import com.suprun.bookstorage.command.Command;
import com.suprun.bookstorage.exception.BookServiceException;
import com.suprun.bookstorage.service.BookStorageService;

import java.util.HashMap;
import java.util.Map;

public class AddBookCommand implements Command {

    BookStorageService bookStorageService = new BookStorageService();

    public Map<String, Object> execute(Map<String, String> params){
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            response = bookStorageService.addBook(params);
        } catch (BookServiceException e) {
            response.put("addbook", e.getMessage());
        }
        return response;
    }
}
