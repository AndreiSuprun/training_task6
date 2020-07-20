package com.suprun.bookstorage.controller;

import com.suprun.bookstorage.controller.command.Command;
import com.suprun.bookstorage.controller.command.CommandReceiver;


import java.util.Map;

public class BookController {

     public Map<String, Object> processRequest(String requestType, Map<String, String> request){
         CommandReceiver commandReceiver = new CommandReceiver();
         Command command = commandReceiver.receiveCommand(requestType);
         Map<String, Object> response = command.execute(request);
         return response;
    }
}
