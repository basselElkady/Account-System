package edu.mum.cs.cs525.labs.exercises.project.creditcard.entity;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.RandomGenerator;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditCardAccount extends Account {


    private final String ccNumber;
    private final String cvv;
    private final LocalDate expiryDate;


    public CreditCardAccount(Customer accountOwner, CreditCardAccountType accountType) {
        super(RandomGenerator.generateAccountNumber(), accountOwner, accountType);
        this.ccNumber = RandomGenerator.generateCCNumber();
        this.cvv = RandomGenerator.generateCVV();
        this.expiryDate = accountType.generateExpiryDate();
    }


    public void charge(BigDecimal amount) {
        withdraw(amount);
    }



    public String getCcNumber() {
        return ccNumber;
    }



    public String getCvv() {
        return cvv;
    }



    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
