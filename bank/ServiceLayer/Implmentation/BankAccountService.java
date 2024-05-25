package edu.mum.cs.cs525.labs.exercises.project.bank.ServiceLayer.Implmentation;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.factory.AccountTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.notification.EmailSender;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.repository.AccountRepository;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.rule.RulesEngine;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.service.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.bank.factory.BankAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.bank.factory.CheckingTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.bank.factory.SavingTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.bank.rule.CompanyAccountEmailRule;
import edu.mum.cs.cs525.labs.exercises.project.bank.rule.PersonalAccountEmailRule;

import java.time.LocalDate;
import java.util.List;

import java.math.BigDecimal;
import java.util.List;

public class BankAccountService extends AccountService {


    public BankAccountService(AccountRepository accountRepository) {
        super(accountRepository);
        RulesEngine rulesEngine = new RulesEngine();

        // Adding rules
        rulesEngine.addRule(new CompanyAccountEmailRule());
        rulesEngine.addRule(new PersonalAccountEmailRule());
        addTransactionObserver(EmailSender.getInstance(rulesEngine));
    }

    public Account createAccount(Customer customer, String accountType) {

        AccountTypeFactory accountTypeFactory;
        if(accountType.equalsIgnoreCase("Ch")) {
            accountTypeFactory = new CheckingTypeFactory();
        }else{
            accountTypeFactory = new SavingTypeFactory();
        }

        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        Account account= bankAccountFactory.createNewAccountForCustomer(customer,accountTypeFactory);

        this.getAccountRepository().save(account);
        return account;

    }

    public String getAccountNumber(Account account) {
        return account.getAccountNumber();
    }

    public List<Account> getAllAccounts() {
        return this.getAccountRepository().getAllAccounts();
    }

    public BigDecimal getBalance(Account account) {
        return account.getBalance();
    }

    public Account getAccount(String accountNumber) {
        return this.getAccountRepository().findByAccountNumber(accountNumber);
    }


    @Override
    public String generateReport() {
        List<Account> accounts = getAccountRepository().getAllAccounts();
        StringBuilder report = new StringBuilder("Banking Accounts Report:\n");
        for (Account account : accounts) {
            report.append(account.generateAccountReport(LocalDate.MIN, LocalDate.MAX)).append("\n");
        }
        return report.toString();
    }
}
