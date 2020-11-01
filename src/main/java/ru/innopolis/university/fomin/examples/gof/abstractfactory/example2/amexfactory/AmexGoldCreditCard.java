package ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.amexfactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CardType;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example2.CreditCard;

public class AmexGoldCreditCard extends CreditCard {
    AmexGoldCreditCard() {
        this.type = CardType.GOLD;
    }
}
