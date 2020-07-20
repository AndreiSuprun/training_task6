package com.suprun.bookstorage.controller.command;

import java.util.Map;

public interface Command {

    Map<String, Object> execute(Map<String, String> request);
}
