package ru.innopolis.university.fomin.examples.gof.behavioral.interpreter.example1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterEverydayDemo {
    public static void main(String[] args) {
        String input = "lions, and tigers, and bears! Oh, my!";

        Pattern p = Pattern.compile("(lion|cat|dog|wolf|bear|human|tiger|liger)");
        Matcher m = p.matcher(input);

        while (m.find()) {
            System.out.println("Found a " + m.group() + ".");
        }
    }
}
