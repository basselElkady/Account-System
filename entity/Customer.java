package edu.mum.cs.cs525.labs.exercises.project.accountparty.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private final List<Account> accounts;



    protected Customer(String name, String email,String street, String city, String state, String zip) {
        this.name = name;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        accounts = new ArrayList<>();
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }


    public void addAccount(Account account){
        accounts.add(account);
    }


    public List<Account> getAccounts(){
        return accounts;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public void setStreet(String street) {
        this.street = street;
    }



    public void setCity(String city) {
        this.city = city;
    }



    public void setState(String state) {
        this.state = state;
    }



    public void setZip(String zip) {
        this.zip = zip;
    }

    public abstract  String getType();

}
