package ru.innopolis.university.fomin.examples.gof.creational.builder.example2.builders;

import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.cars.Manual;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.cars.Type;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.Engine;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.GPSNavigator;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.Transmission;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.TripComputer;

public class CarManualBuilder implements Builder {
    protected Type type;
    protected int seats;
    protected Engine engine;
    protected Transmission transmission;
    protected TripComputer tripComputer;
    protected GPSNavigator gpsNavigator;


    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult() {
        return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
