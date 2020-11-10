package ru.innopolis.university.fomin.examples.gof.creational.builder.example2;

import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.builders.CarBuilder;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.builders.CarManualBuilder;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.cars.Car;
import ru.innopolis.university.fomin.examples.gof.creational.builder.example2.cars.Manual;

public class DemoBuilder {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getType());

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

        director.constructSUV(manualBuilder);
        carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
