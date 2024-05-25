package edu.mum.cs.cs525.labs.exercises.project.creditcard.factory;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.factory.AccountTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.entity.CreditCardAccountType;

public interface CreditCardAccountTypeFactory extends AccountTypeFactory {

    CreditCardAccountType provide();
}
