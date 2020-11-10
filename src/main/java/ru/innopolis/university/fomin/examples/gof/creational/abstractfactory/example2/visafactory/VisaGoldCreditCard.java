package ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.visafactory;

import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.CardType;
import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example2.CreditCard;

public class VisaGoldCreditCard extends CreditCard {
    VisaGoldCreditCard() {
        this.type = CardType.GOLD;
    }
}
