package com.suprun.bookstorage.model.validator;

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
        if (input == null){
            return 0;
        }
        int value;
        try {
            value = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            value = 0;
        }
        return value;
    }
}