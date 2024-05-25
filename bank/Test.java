package edu.mum.cs.cs525.labs.exercises.project.bank;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.notification.EmailSender;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.repository.AccountRepository;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.rule.RulesEngine;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.service.AccountTransactionService;
import edu.mum.cs.cs525.labs.exercises.project.bank.ServiceLayer.Implmentation.BankAccountService;
import edu.mum.cs.cs525.labs.exercises.project.bank.entity.BankingAccount;
import edu.mum.cs.cs525.labs.exercises.project.bank.entity.Custmers.Company;
import edu.mum.cs.cs525.labs.exercises.project.bank.rule.CompanyAccountEmailRule;
import edu.mum.cs.cs525.labs.exercises.project.bank.rule.PersonalAccountEmailRule;

import java.math.BigDecimal;
public class Test {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        RulesEngine rulesEngine = new RulesEngine();

        // Adding rules
        rulesEngine.addRule(new CompanyAccountEmailRule());
        rulesEngine.addRule(new PersonalAccountEmailRule());

        AccountTransactionService accountService = new BankAccountService(accountRepository);
        accountService.addTransactionObserver(EmailSender.getInstance(rulesEngine));

        // Create accounts and customers
        Customer johnDoe = new Company("John Doe", "john.doe@example.com", "1000 Main", "Fairfield", "IA", "52556", 10);

        Account johnsAccount = new BankingAccount(johnDoe, null);

        johnDoe.addAccount(johnsAccount);
        accountRepository.save(johnsAccount);

        // Perform transactions
        accountService.deposit("12345", BigDecimal.valueOf(1600));
        accountService.withdraw("12345", BigDecimal.valueOf(700));

//        AccountService service = new BankAccountServiceImpl(accountRepository);
//        System.out.println(service.generateReport());
    }
}
