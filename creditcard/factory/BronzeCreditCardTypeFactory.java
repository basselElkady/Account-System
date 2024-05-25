package edu.mum.cs.cs525.labs.exercises.project.creditcard.factory;

import edu.mum.cs.cs525.labs.exercises.project.creditcard.entity.BronzeCreditCard;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.entity.CreditCardAccountType;

public class BronzeCreditCardTypeFactory implements CreditCardAccountTypeFactory {

    @Override
    public CreditCardAccountType provide() {
        return new BronzeCreditCard();
    }
}
