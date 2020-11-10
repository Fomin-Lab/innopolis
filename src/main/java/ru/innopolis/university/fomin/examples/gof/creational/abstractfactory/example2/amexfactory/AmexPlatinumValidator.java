package ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.amexfactory;

import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.CreditCard;
import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.Validator;

public class AmexPlatinumValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return creditCard instanceof AmexPlatinumCreditCard;
    }
}
