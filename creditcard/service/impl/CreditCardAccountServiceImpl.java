package edu.mum.cs.cs525.labs.exercises.project.creditcard.service.impl;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountEntry;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.TransactionType;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.factory.AccountTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.notification.EmailSender;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.repository.AccountRepository;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.rule.RulesEngine;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.service.AccountService;

import edu.mum.cs.cs525.labs.exercises.project.creditcard.rule.PersonalAccountEmailRule;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.entity.CCCustomer;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.entity.CreditCardAccount;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.entity.CreditCardAccountType;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.factory.BronzeCreditCardTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.factory.CreditCardAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.factory.GoldCreditCardTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.factory.SilverCreditCardTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.rule.CompanyAccountEmailRule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CreditCardAccountServiceImpl extends AccountService {

    public CreditCardAccountServiceImpl(AccountRepository accountRepository) {
        super(accountRepository);

        RulesEngine rulesEngine = new RulesEngine();

        // Adding rules
        rulesEngine.addRule(new CompanyAccountEmailRule());
        rulesEngine.addRule(new PersonalAccountEmailRule());
        addTransactionObserver(EmailSender.getInstance(rulesEngine));
    }

    public CreditCardAccount createCreditCardAccountForCustomer(CCCustomer customer, String creditCardType) {
        AccountTypeFactory creditCard = switch (creditCardType) {
            case "Gold" -> new GoldCreditCardTypeFactory();
            case "Silver" -> new SilverCreditCardTypeFactory();
            case "Bronze" -> new BronzeCreditCardTypeFactory();
            default -> throw new IllegalArgumentException("Unknown credit card type!");
        };
        CreditCardAccount customerWithCreditCard = new CreditCardAccountFactory().createNewAccountForCustomer(customer, creditCard);
        this.getAccountRepository().save(customerWithCreditCard);

        return customerWithCreditCard;
    }



    @Override
    public String generateReport() {
        List<Account> allAccounts = getAccountRepository().getAllAccounts();
        List<CreditCardAccount> accounts = allAccounts.stream()
                .filter(CreditCardAccount.class::isInstance)
                .map(CreditCardAccount.class::cast)
                .toList();
        StringBuilder report = new StringBuilder("Credit Card Monthly Reports:\n");

        YearMonth lastMonth = YearMonth.now().minusMonths(0);
        LocalDate from = lastMonth.atDay(1);
        LocalDate to = lastMonth.atEndOfMonth();

        for (CreditCardAccount account : accounts) {

            BigDecimal previousBalance = account.getPreviousBalance();
            BigDecimal totalCharges = BigDecimal.ZERO;
            BigDecimal totalCredits = BigDecimal.ZERO;

            for (AccountEntry entry : account.getEntryList()) {
                System.out.println(entry.generateEntryReport());
                if (entry.getTransactionDate().toLocalDate().isAfter(from) && entry.getTransactionDate().toLocalDate().isBefore(to)) {
                    if (entry.getTransactionType() == TransactionType.CREDIT) {
                        totalCredits = totalCredits.add(entry.getAmount());
                    } else if (entry.getTransactionType() == TransactionType.DEBIT) {
                        totalCharges = totalCharges.add(entry.getAmount());
                    }
                }
            }

            CreditCardAccountType accountType = (CreditCardAccountType) account.getAccountType();
            BigDecimal rate = Objects.requireNonNullElse(
                    accountType.getInterestCalculationStrategy().getRate(), BigDecimal.ZERO);
            BigDecimal minimumPaymentRate = Objects.requireNonNullElse(accountType.getMinimumPaymentStrategy().getRate()
                    , BigDecimal.ZERO);
            BigDecimal newBalance = previousBalance.subtract(totalCredits).add(totalCharges).add(
                    (previousBalance.subtract(totalCredits)).multiply(rate));

            BigDecimal totalDue = newBalance.multiply(minimumPaymentRate);
//            if (totalDue.compareTo(BigDecimal.ZERO) < 0) {
//                totalDue = BigDecimal.ZERO;
//            }

            Customer owner = account.getAccountOwner();
            String address = owner.getStreet() + ", " + owner.getCity() + ", " + owner.getState() + ", " + owner.getZip();

            report.append("Name= ").append(owner.getName()).append("\r\n");
            report.append("Address= ").append(address).append("\r\n");
            report.append("CC number= ").append(account.getAccountNumber()).append("\r\n");
            //report.append("CC type= ").append(account.getAccountType().getClass().getSimpleName().toUpperCase()).append("\r\n");
            report.append("Previous balance = $ ").append(previousBalance.setScale(2, RoundingMode.HALF_UP)).append("\r\n");
            report.append("Total Credits = $ ").append(totalCredits.setScale(2, RoundingMode.HALF_UP)).append("\r\n");
            report.append("Total Charges = $ ").append(totalCharges.setScale(2, RoundingMode.HALF_UP)).append("\r\n");
            report.append("New balance = $ ").append(newBalance.setScale(2, RoundingMode.HALF_UP)).append("\r\n");
            report.append("Total amount due = $ ").append(totalDue.setScale(2, RoundingMode.HALF_UP)).append("\r\n");
            report.append("\r\n");

            account.setPreviousBalance(newBalance);
            getAccountRepository().update(account);
            report.append("\n\n");
        }
        return report.toString();
    }
}
