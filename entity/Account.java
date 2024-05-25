package edu.mum.cs.cs525.labs.exercises.project.accountparty.entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private final String accountNumber;
    private BigDecimal balance;
    private final Customer accountOwner;
    private final List<AccountEntry> entryList;
    private final AccountType accountType;
    private AccountState accountState;
    private BigDecimal previousBalance;

    protected Account(String accountNumber, Customer accountOwner, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.valueOf(0);
        this.accountOwner = accountOwner;
        this.entryList = new ArrayList<>();
        this.accountType = accountType;
        this.accountState = AccountState.ACTIVE;
        this.previousBalance = BigDecimal.valueOf(0);
    }

    public BigDecimal getPreviousBalance() {
        return this.previousBalance;
    }
    public void setPreviousBalance (BigDecimal previousBalance) {
        this.previousBalance = previousBalance;
    }

    public List<AccountEntry> getEntryList() {
        return new ArrayList<>(this.entryList);
    }



    public void deposit(BigDecimal amount) {
        deposit(amount, "Deposit");
    }



    private void deposit(BigDecimal amount, String description) {
        //validateForDeposit(amount);
        balance = balance.add(amount);
        entryList.add(new AccountEntry(description, null, this, amount, balance, TransactionType.CREDIT));
    }



    private void validateForDeposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
    }



    public void withdraw(BigDecimal amount) {
        validateForWithdrawal(amount);
        balance = balance.subtract(amount);
        entryList.add(new AccountEntry("Withdrawal", this, null, amount, balance, TransactionType.DEBIT));
    }



    private void validateForWithdrawal(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            //throw new IllegalArgumentException("Insufficient funds");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }
    }



    public void addInterest(){
        BigDecimal interest = calculateInterest(this);

        if (interest.compareTo(BigDecimal.ZERO) <= 0) {
            return;
        }

        deposit(interest, "Interest");
    }


    public void transferFunds(Account toAccount, BigDecimal amount) {
        validateForTransfer(toAccount, amount);
        withdraw(amount);
        toAccount.deposit(amount);
    }


    private void validateForTransfer(Account toAccount, BigDecimal amount) {

        if (toAccount == null) {
            throw new IllegalArgumentException("Destination account is required");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero");
        }

        if (this.equals(toAccount)) {
            throw new IllegalArgumentException("Source and destination accounts must be different");
        }

        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }



    protected BigDecimal calculateInterest(Account account){
        return accountType.getInterestCalculationStrategy().calculateInterest(account);
    }


    public String generateAccountReport(LocalDate from, LocalDate to){

        StringBuilder report = new StringBuilder();
        report.append("Account Number: ").append(accountNumber).append("\n");
        report.append("Account Owner: ").append(accountOwner.getName()).append("\n");
        report.append("Account Type: ").append(getAccountOwner().getType()).append("\n");
        report.append("Balance: ").append(balance).append("\n");
        report.append("Entries: ").append("\n");

        for (AccountEntry entry : entryList) {
            if (entry.getTransactionDate().isAfter(from.atStartOfDay())
                    && entry.getTransactionDate().isBefore(to.atStartOfDay())) {
                report.append(entry.generateEntryReport()).append("\n");
            }
        }

        report.append("\n");
        report.append("Balance: ").append(balance).append("\n");
        return report.toString();
    }



    public  void  closeAccount(){
        BigDecimal accountBalance = getBalance();

        if (accountBalance.compareTo(BigDecimal.ZERO) > 0) {
            withdraw(accountBalance);
        }
        
        accountState = AccountState.CLOSED;
    }

    
    public BigDecimal getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Customer getAccountOwner() {
        return accountOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}
