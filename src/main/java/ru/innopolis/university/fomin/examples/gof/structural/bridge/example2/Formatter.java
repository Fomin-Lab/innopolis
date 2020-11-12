package ru.innopolis.university.fomin.examples.gof.structural.bridge.example2;

import java.util.List;

public interface Formatter {
    String format(String header, List<Detail> details);
}
