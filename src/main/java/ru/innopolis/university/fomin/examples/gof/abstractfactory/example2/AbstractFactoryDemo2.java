package ru.innopolis.university.fomin.examples.gof.abstractfactory.example2;

public class AbstractFactoryDemo2 {
    public static void main(String[] args) {
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);
        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);
        System.out.println(card.getClass());
        Validator validator = abstractFactory.getValidator(card.getType());
        System.out.println(validator.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(600);
        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);
        System.out.println(card2.getClass());
        Validator validator2 = abstractFactory.getValidator(card2.getType());
        System.out.println(validator2.getClass());

        System.out.println(validator.isValid(card));
        System.out.println(validator.isValid(card2));
        System.out.println(validator2.isValid(card));
        System.out.println(validator2.isValid(card2));
    }
}
