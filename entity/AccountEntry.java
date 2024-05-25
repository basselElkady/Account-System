package edu.mum.cs.cs525.labs.exercises.project.accountparty.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountEntry {

    private final String description;

    private final Account fromAccount;

    private final Account toAccount;

    private final BigDecimal amount;

    private final LocalDateTime transactionDate = LocalDateTime.now();

    private final BigDecimal balanceAfter;

    private final TransactionType transactionType;



    protected AccountEntry(String description, Account fromAccount, Account toAccount, BigDecimal amount, BigDecimal balanceAfter, TransactionType transactionType) {
        this.description = description;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.transactionType = transactionType;
    }


    public String getDescription() {
        return description;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }



    public String generateEntryReport() {
        return String.format("%s %s %s %s", transactionDate, transactionType, amount, description);
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }
}
