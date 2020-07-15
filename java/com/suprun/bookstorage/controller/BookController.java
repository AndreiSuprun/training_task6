package com.suprun.bookstorage.controller;

import com.suprun.bookstorage.command.Command;
import com.suprun.bookstorage.command.impl.EmptyCommand;

import java.util.Map;

public class BookController {

     public Map<String, Object> doRequest(String requestType, Map<String, String> params){
         Command command = null;
         command = RequestType.valueOf(requestType.toUpperCase()).getCommand();
         if (command == null) {
             command = new EmptyCommand();
         }
         Map<String, Object> map = command.execute(params);
         return map;
    }
}
