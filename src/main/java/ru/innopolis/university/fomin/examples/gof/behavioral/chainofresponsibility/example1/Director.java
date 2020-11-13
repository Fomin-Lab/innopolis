package ru.innopolis.university.fomin.examples.gof.behavioral.chainofresponsibility.example1;

public class Director extends Handler {
    @Override
    void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.CONFERENCE) {
            System.out.println("Directors can approve conferences");
        } else {
            successor.handleRequest(request);
        }
    }
}
