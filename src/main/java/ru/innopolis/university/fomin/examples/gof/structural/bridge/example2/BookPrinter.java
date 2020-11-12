package ru.innopolis.university.fomin.examples.gof.structural.bridge.example2;

import java.util.ArrayList;
import java.util.List;

public class BookPrinter extends Printer {
    protected Book book;

    public BookPrinter(Book book) {
        this.book = book;
    }

    @Override
    protected List<Detail> getDetails() {
        List<Detail> details = new ArrayList<>();
        details.add(new Detail("Author", book.getAuthor()));
        details.add(new Detail("Year", book.getYear()));
        details.add(new Detail("Count page", book.getContPage()));
        return details;
    }

    @Override
    protected String getHeader() {
        return book.getTitle();
    }
}
