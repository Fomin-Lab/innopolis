package ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.visafactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CreditCard;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.Validator;

public class VisaPlatinumValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return creditCard instanceof VisaPlatinumCreditCard;
    }
}
