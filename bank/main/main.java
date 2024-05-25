package edu.mum.cs.cs525.labs.exercises.project.bank.main;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.repository.AccountRepository;
import edu.mum.cs.cs525.labs.exercises.project.bank.ServiceLayer.CustmerService;
import edu.mum.cs.cs525.labs.exercises.project.bank.ServiceLayer.Implmentation.BankAccountService;
import edu.mum.cs.cs525.labs.exercises.project.bank.ServiceLayer.Implmentation.CustomerService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {




//
//        BankAccountFactory bankAccountFactory = new BankAccountFactory();
//        SavingTypeFactory savingTypeFactory=new SavingTypeFactory();
//        CheckingTypeFactory checkingTypeFactory=new CheckingTypeFactory();

//        Company company1=new Company("company1","company1email","street1","city1","state1"
//        ,"1234",10);
//
//        Person person1=new Person("person1","person1.email","streetPerson1","cit1",
//                "State1","552570", LocalDate.of(1999,12,11));
//
//        Account Companyaccount=bankAccountFactory.createNewAccountForCustomer(company1,savingTypeFactory);
//        Account Personalaccount=bankAccountFactory.createNewAccountForCustomer(person1,checkingTypeFactory);


        CustmerService custmerService=new CustomerService();
        Customer company1= custmerService.CreateCustmer("company1","company1email","street1","city1","state1"
                ,"1234",10);

        Customer  person1=custmerService.CreateCustmer("person1","person1.email","streetPerson1","cit1",
               "State1","552570", LocalDate.of(1999,12,11));

        BankAccountService bankAccountService =new BankAccountService(new AccountRepository());

        Account Companyaccount = bankAccountService.createAccount(company1,"S");

        Account Personalaccount = bankAccountService.createAccount(person1,"Ch"
        );







        System.out.println("deposite in both accoubts");
        System.out.println(" balance in company account : "+Companyaccount.getBalance());
        System.out.println(" balance in personal account "+Personalaccount.getBalance());

        Companyaccount.deposit(BigDecimal.valueOf(1000));
        Personalaccount.deposit(BigDecimal.valueOf(500));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Withdraw from both accounts");
        System.out.println(" balance in company account : "+Companyaccount.getBalance());
        System.out.println(" balance in personal account "+Personalaccount.getBalance());

        Companyaccount.withdraw(BigDecimal.valueOf(500));
        Personalaccount.withdraw(BigDecimal.valueOf(200));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Transferring mony from company account to personal accouhnt");
        System.out.println(" balance in company account : "+Companyaccount.getBalance());
        System.out.println(" balance in personal account "+Personalaccount.getBalance());


        Companyaccount.transferFunds(Personalaccount, BigDecimal.valueOf(100));


        System.out.println("-----------------------------------------------------------------");

        System.out.println(" balance in company account : "+Companyaccount.getBalance());
        System.out.println(" balance in personal account "+Personalaccount.getBalance());

        Companyaccount.addInterest();
        Personalaccount.addInterest();

        System.out.println("-----------------------------------------------------------------");

        System.out.println(" balance in company account : "+Companyaccount.getBalance());
        System.out.println(" balance in personal account "+Personalaccount.getBalance());

    }
}
