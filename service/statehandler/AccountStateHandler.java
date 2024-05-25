package edu.mum.cs.cs525.labs.exercises.project.accountparty.service.statehandler;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface AccountStateHandler {
    void deposit(BigDecimal amount);

    void withdraw(BigDecimal amount);

    void addInterest();

    void transferFunds(Account toAccount, BigDecimal amount);

    void  closeAccount();

}
