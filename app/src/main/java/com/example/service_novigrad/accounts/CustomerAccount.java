package com.example.service_novigrad.accounts;

public class CustomerAccount extends Account{

    //Constructor
    public CustomerAccount(){

    }

    public CustomerAccount(String username, String password, String firstName, String lastName, long accountID){
        this.accountType = 0;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
    }

    //Class Methods
    public boolean checkIfFilled(){//check if there is a valid value in all
        return (username.equals("") || password.equals("") || firstName.equals("") || lastName.equals(""));
    }

    public void searchBranch(){}

    public void purchaseService(){}

    public void fillService(){}

    public void rateExperience(){}
}