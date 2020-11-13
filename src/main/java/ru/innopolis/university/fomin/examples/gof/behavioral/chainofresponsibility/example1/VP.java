package ru.innopolis.university.fomin.examples.gof.behavioral.chainofresponsibility.example1;

public class VP extends Handler {
    @Override
    void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.PURCHASE) {
            if (request.getAmount() < 1500) {
                System.out.println("VPs can approve purchases below 1500");
            } else {
                successor.handleRequest(request);
            }
        }
    }
}
