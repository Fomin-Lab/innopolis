package ru.innopolis.university.fomin.examples.gof.abstractfactory.example2;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.amexfactory.AmexFactory;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.visafactory.VisaFactory;

public abstract class CreditCardFactory {
    public static CreditCardFactory getCreditCardFactory(int creditScore) {
        if (creditScore > 650) {
            return new AmexFactory();
        } else {
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType type);

    public abstract Validator getValidator(CardType type);
}
