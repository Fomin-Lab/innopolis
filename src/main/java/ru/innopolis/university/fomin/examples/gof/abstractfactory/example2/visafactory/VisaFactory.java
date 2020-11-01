package ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.visafactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CardType;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CreditCard;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CreditCardFactory;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.Validator;

public class VisaFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType type) {
        switch (type) {
            case GOLD:
                return new VisaGoldCreditCard();
            case PLATINUM:
                return new VisaPlatinumCreditCard();
        }
        return null;
    }

    @Override
    public Validator getValidator(CardType type) {
        switch (type) {
            case GOLD:
                return new VisaGoldValidator();
            case PLATINUM:
                return new VisaPlatinumValidator();
        }
        return null;
    }
}
