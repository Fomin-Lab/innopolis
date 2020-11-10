package ru.innopolis.university.fomin.examples.gof.creational.builder.example2.builders;

import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.cars.Type;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.Engine;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.GPSNavigator;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.Transmission;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.components.TripComputer;

public interface Builder {
    void setType(Type type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
