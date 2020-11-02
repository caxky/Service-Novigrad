package com.example.service_novigrad.accounts;

public abstract class Account{
    //Instance Variables
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String accountKey;
    protected long accountID;
    protected int accountType;

    //Setter methods
    public void setUsername(String newUsername){
        this.username = newUsername;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }
    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }
    public void setAccountKey(String newAccountKey){this.accountKey = newAccountKey;}
    public void setAccountID(long newAccountID){this.accountID = newAccountID;}


    //Getter methods
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAccountKey(){
        return this.accountKey;
    }
    public long getAccountID(){return this.accountID;}
}