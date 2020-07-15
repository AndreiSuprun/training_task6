package com.suprun.bookstorage.command;

import java.util.Map;

public interface Command {

    Map<String, Object> execute(Map<String, String> params);
}
