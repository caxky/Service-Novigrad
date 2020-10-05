package com.example.service_novigrad.accounts;

public abstract class Account{
    //Instance Variables
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected int accountID;
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
}