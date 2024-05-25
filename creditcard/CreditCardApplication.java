package edu.mum.cs.cs525.labs.exercises.project.creditcard;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.factory.AccountTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.entity.CCCustomer;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.factory.BronzeCreditCardTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.factory.CreditCardAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.factory.GoldCreditCardTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.factory.SilverCreditCardTypeFactory;

import java.math.BigDecimal;

public class CreditCardApplication {
    public static void main(String[] args) {
        Customer company1 = new CCCustomer("Company 1", "info@company1.com", "1000 N, 4th street", "Fairfield", "IA", "52557");
        Customer company2 = new CCCustomer("Company 2", "info@company2.com", "1001 N, 5th street", "Des Moines", "IA", "52000");



        AccountTypeFactory goldCreditCard = new GoldCreditCardTypeFactory();
        AccountTypeFactory silverCreditCard = new SilverCreditCardTypeFactory();
        AccountTypeFactory bronzeCreditCard = new BronzeCreditCardTypeFactory();

        Account company1GoldCC = new CreditCardAccountFactory().createNewAccountForCustomer(company1, goldCreditCard);
        Account company1SilverCC = new CreditCardAccountFactory().createNewAccountForCustomer(company1, silverCreditCard);
        Account company2GoldCC = new CreditCardAccountFactory().createNewAccountForCustomer(company1, goldCreditCard);

        company1GoldCC.deposit(BigDecimal.valueOf(1000));
        company1GoldCC.addInterest();

        company2GoldCC.deposit(BigDecimal.valueOf(2000));
        company2GoldCC.addInterest();

        BigDecimal balanceCompany1GoldCC = company1GoldCC.getBalance();
        BigDecimal balanceCompany1SilverCC = company1SilverCC.getBalance();
        BigDecimal balanceCompany2GoldCC = company2GoldCC.getBalance();
        System.out.println("balance Company1 GoldCC: " + balanceCompany1GoldCC);
        System.out.println("balance Company1 SilverCC: " + balanceCompany1SilverCC);
        System.out.println("balance Company2 GoldCC: " + balanceCompany2GoldCC);
    }
}
