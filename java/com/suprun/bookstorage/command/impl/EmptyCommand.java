package com.suprun.bookstorage.command.impl;

import com.suprun.bookstorage.command.Command;

import java.util.HashMap;
import java.util.Map;

public class EmptyCommand implements Command {

    public Map<String, Object> execute(Map<String, String> params) {
        return new HashMap<String, Object>();
    }
}
