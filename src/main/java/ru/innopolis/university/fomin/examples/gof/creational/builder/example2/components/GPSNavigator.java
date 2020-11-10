package ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components;

public class GPSNavigator {
    protected String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London to Scotland Yard, 8-10 Broadway, London";
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
