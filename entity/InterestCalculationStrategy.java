package edu.mum.cs.cs525.labs.exercises.project.accountparty.entity;

import java.math.BigDecimal;

public interface InterestCalculationStrategy {
    BigDecimal calculateInterest(Account account);
    BigDecimal getRate();
}
