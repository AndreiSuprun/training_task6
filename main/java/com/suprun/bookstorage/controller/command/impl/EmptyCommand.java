package com.suprun.bookstorage.controller.command.impl;

import com.suprun.bookstorage.controller.command.Command;

import java.util.HashMap;
import java.util.Map;

public class EmptyCommand implements Command {

    public Map<String, Object> execute(Map<String, String> request) {
        return new HashMap<String, Object>();
    }
}
