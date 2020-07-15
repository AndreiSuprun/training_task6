package com.suprun.bookstorage.validator;

public class BookValidator {

    public boolean validateBoolean(String input) {
        if (input == null || input.trim().isEmpty()){
            return false;
        }
        return Boolean.parseBoolean(input.trim());
    }

    public String validateString(String input) {
        if (input == null || input.trim().isEmpty()){
            return "";
        }
        return input;
    }

    public int validateInt(String input) {
        if (input == null || Integer.parseInt(input.trim()) <= 0){
            return 0;
        }
        return Integer.parseInt(input);
    }
}