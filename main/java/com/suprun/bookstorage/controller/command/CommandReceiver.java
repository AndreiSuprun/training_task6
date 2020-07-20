package com.suprun.bookstorage.controller.command;

import com.suprun.bookstorage.controller.command.impl.EmptyCommand;

public class CommandReceiver {

    public Command receiveCommand(String requestType){
        Command command;
        try {
            RequestType request = RequestType.valueOf(requestType.toUpperCase());
            command = request.getCommand();
        } catch (IllegalArgumentException e) {
            command = new EmptyCommand();
        }
        return command;
    }
}
