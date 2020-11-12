package ru.innopolis.university.fomin.examples.gof.structural.facade.example1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class FacadeEverydayDemo {
    public static void main(String[] args) throws Exception {
        // Facade
        URL url = new URL("http", "innopolis.ru", 80, "/");

        // Decorator
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
    }
}
