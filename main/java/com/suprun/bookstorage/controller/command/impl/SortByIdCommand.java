package com.suprun.bookstorage.controller.command.impl;

import com.suprun.bookstorage.controller.command.Command;
import com.suprun.bookstorage.model.service.BookStorageService;

import java.util.Map;

public class SortByIdCommand implements Command {

    BookStorageService bookStorageService = new BookStorageService();

    public Map<String, Object> execute(Map<String, String> request){
        return bookStorageService.sortById(request);
    }
}
