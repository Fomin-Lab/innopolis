package ru.innopolis.university.fomin.examples.gof.behavioral.chainofresponsibility.example1;

public class Request {
    protected RequestType requestType;
    protected double amount;

    public Request(RequestType requestType, double amount) {
        this.requestType = requestType;
        this.amount = amount;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public double getAmount() {
        return amount;
    }
}
