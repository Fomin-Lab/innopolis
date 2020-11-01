package ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.visafactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CardType;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CreditCard;

public class VisaPlatinumCreditCard extends CreditCard {
    VisaPlatinumCreditCard() {
        this.type = CardType.PLATINUM;
    }
}
