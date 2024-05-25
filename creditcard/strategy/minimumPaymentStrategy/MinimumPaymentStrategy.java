package edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.minimumPaymentStrategy;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;

import java.math.BigDecimal;

public interface MinimumPaymentStrategy {
    BigDecimal minimumPayment(Account account);
    BigDecimal getRate();
}
