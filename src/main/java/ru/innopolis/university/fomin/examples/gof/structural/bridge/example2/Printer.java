package ru.innopolis.university.fomin.examples.gof.structural.bridge.example2;

import java.util.List;

public abstract class Printer {
    String print(Formatter formatter) {
        return formatter.format(getHeader(), getDetails());
    }

    protected abstract List<Detail> getDetails();
    protected abstract String getHeader();
}
