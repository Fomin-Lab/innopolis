package ru.innopolis.university.fomin.examples.gof.creational.builder.example2.cars;

import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.Engine;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.GPSNavigator;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.Transmission;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.TripComputer;

public class Car {
    protected Type type;
    protected int seats;
    protected Engine engine;
    protected Transmission transmission;
    protected TripComputer tripComputer;
    protected GPSNavigator gpsNavigator;
    protected double fuel = 0;

    public Car(Type type, int seats, Engine engine, Transmission transmission, TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.tripComputer.setCar(this);
        this.gpsNavigator = gpsNavigator;
    }

    public Type getType() {
        return type;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}
