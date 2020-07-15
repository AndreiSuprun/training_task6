package com.suprun.bookstorage.controller;

import com.suprun.bookstorage.command.Command;
import com.suprun.bookstorage.command.impl.*;

public enum RequestType {
    ADD_BOOK(new AddBookCommand()), REMOVE_BOOK(new RemoveBookCommand()), FIND_BY_ID(new FindByIdCommand()),
    FIND_BY_NAME(new FindByNameCommand()), FIND_BY_AUTHORS(new FindByAuthorsCommand()),
    FIND_BY_PUBLISHER(new FindByPublisherCommand()), FIND_BY_PUBLISH_YEAR(new FindByPublishYearCommand()),
    FIND_BY_PAGE_QUANTITY(new FindByPageQuantityCommand()),SORT_BY_ID(new SortByIdCommand()),
    SORT_BY_NAME(new SortByNameCommand()), SORT_BY_AUTHORS(new SortByAuthorsCommand()),
    SORT_BY_PUBLISHER(new SortByPublisherCommand()), SORT_BY_PUBLISH_YEAR(new SortByPublishYearCommand()),
    SORT_BY_PAGE_QUANTITY(new SortByPageQuantityCommand());
    private Command request;
    RequestType(Command request) {}
    public Command getCommand(){
        return  request;
    }
}
