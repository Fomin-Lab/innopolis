package ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.amexfactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CardType;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CreditCard;

public class AmexPlatinumCreditCard extends CreditCard {
    AmexPlatinumCreditCard() {
        this.type = CardType.PLATINUM;
    }
}
