package com.example.service_novigrad.accounts;

public class EmployeeAccount extends Account {
    //Instance Variables
    private int branchID;

    //Constructor
    public EmployeeAccount(){

    }
    public EmployeeAccount(String username, String password, String firstName, String lastName, int branchID){
        this.accountType = 1;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.branchID = branchID;
    }

    //Class methods
    public void selectServices(){}

    public void setWorkingHours(){}

    public void viewRequests(){}

    //Setter and Getter methods
    public void setBranchID(int newID){
        this.branchID = newID;
    }
    public int getBranchID(){
        return this.branchID;
    }
}