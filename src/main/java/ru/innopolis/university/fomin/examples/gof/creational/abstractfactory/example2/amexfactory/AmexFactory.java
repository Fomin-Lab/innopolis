package ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.amexfactory;

import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.CardType;
import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.CreditCard;
import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.CreditCardFactory;
import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.Validator;

public class AmexFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType type) {
        switch (type) {
            case GOLD:
                return new AmexGoldCreditCard();
            case PLATINUM:
                return new AmexPlatinumCreditCard();
        }
        return null;
    }

    @Override
    public Validator getValidator(CardType type) {
        switch (type) {
            case GOLD:
                return new AmexGoldValidator();
            case PLATINUM:
                return new AmexPlatinumValidator();
        }
        return null;
    }
}
