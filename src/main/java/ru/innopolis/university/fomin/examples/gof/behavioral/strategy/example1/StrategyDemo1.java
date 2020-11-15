package ru.innopolis.university.fomin.examples.gof.behavioral.strategy.example1;

public class StrategyDemo1 {
    public static void main(String[] args) {
        CreditCard amexCard = new CreditCard(new AmexStrategy());

        amexCard.setNumber("379185883464283");
        amexCard.setDate("03/2020");
        amexCard.setCvv("123");

        System.out.println("Is Amex valid: " + amexCard.isValid());

        CreditCard amexCard2 = new CreditCard(new AmexStrategy());

        amexCard2.setNumber("379185883464282");
        amexCard2.setDate("04/2021");
        amexCard2.setCvv("423");

        System.out.println("Is Amex valid: " + amexCard2.isValid());

        CreditCard visaCard = new CreditCard(new VisaStrategy());

        visaCard.setNumber("4539589763663402");
        visaCard.setDate("05/2021");
        visaCard.setCvv("263");

        System.out.println("Is Visa valid: " + visaCard.isValid());
    }
}
