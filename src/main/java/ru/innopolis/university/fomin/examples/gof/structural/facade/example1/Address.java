package ru.innopolis.university.fomin.examples.gof.structural.facade.example1;

public class Address {
    protected String id;
    protected String streetName;
    protected String city;

    public Address(String id, String streetName, String city) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
