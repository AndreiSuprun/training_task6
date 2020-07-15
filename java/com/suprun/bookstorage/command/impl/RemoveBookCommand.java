package com.suprun.bookstorage.command.impl;

import com.suprun.bookstorage.command.Command;
import com.suprun.bookstorage.exception.BookServiceException;
import com.suprun.bookstorage.service.BookStorageService;

import java.util.HashMap;
import java.util.Map;

public class RemoveBookCommand implements Command {

    BookStorageService bookStorageService = new BookStorageService();

    public Map<String, Object> execute(Map<String, String> params){
        Map<String, Object> response = new HashMap<>();
        try{
            response = bookStorageService.removeBook(params);
        } catch (BookServiceException e) {
            response.put("removebook", e.getMessage());
        }
        return response;
    }
}
