package com.suprun.bookstorage.command.impl;

import com.suprun.bookstorage.command.Command;
import com.suprun.bookstorage.service.BookStorageService;

import java.util.Map;

public class SortByNameCommand implements Command {

    BookStorageService bookStorageService = new BookStorageService();

    public Map<String, Object> execute(Map<String, String> params){
        return bookStorageService.sortByName(params);
    }
}
