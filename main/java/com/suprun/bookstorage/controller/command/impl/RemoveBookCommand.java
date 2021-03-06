package com.suprun.bookstorage.controller.command.impl;

import com.suprun.bookstorage.controller.command.Command;
import com.suprun.bookstorage.model.exception.BookServiceException;
import com.suprun.bookstorage.model.service.BookStorageService;

import java.util.HashMap;
import java.util.Map;

public class RemoveBookCommand implements Command {

    BookStorageService bookStorageService = new BookStorageService();

    public Map<String, Object> execute(Map<String, String> request){
        Map<String, Object> response = new HashMap<>();
        try{
            response = bookStorageService.removeBook(request);
        } catch (BookServiceException e) {
            response.put("exceptions", e.getMessage());
        }
        return response;
    }
}
