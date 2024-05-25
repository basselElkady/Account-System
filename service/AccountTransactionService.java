package edu.mum.cs.cs525.labs.exercises.project.accountparty.service;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.notification.Observer;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.notification.TransactionObservable;

import java.math.BigDecimal;

public interface AccountTransactionService {
    void deposit(String accountNumber, BigDecimal amount);
    void withdraw(String accountNumber, BigDecimal amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, BigDecimal amount, String description);
    String generateReport();
    TransactionObservable getTransactionObservable();

    void addTransactionObserver(Observer observer);
}
