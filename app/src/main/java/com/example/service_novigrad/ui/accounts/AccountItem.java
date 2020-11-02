package com.example.service_novigrad.ui.accounts;


import com.example.service_novigrad.accounts.CustomerAccount;
import com.example.service_novigrad.accounts.EmployeeAccount;

public class AccountItem {

    private int aImageResource;
    private int aAccountID;
    private int aAccountType;
    private int aBranchID;
    private String aName;
    private String aUsername;
    private String accountKey;

    public AccountItem(int imageResource, CustomerAccount customerAccount) {
        aImageResource = imageResource;
        aAccountType = 0;
        aAccountID = (int)customerAccount.getAccountID();
        aName = customerAccount.getFirstName() + " " + customerAccount.getLastName();
        aUsername = customerAccount.getUsername();
        accountKey = customerAccount.getAccountKey();
    }

    public AccountItem(int imageResource, EmployeeAccount employeeAccount) {
        aImageResource = imageResource;
        aAccountType = 1;
        aAccountID = (int)employeeAccount.getAccountID();
        aBranchID = employeeAccount.getBranchID();
        aName = employeeAccount.getFirstName() + " " + employeeAccount.getLastName();
        aUsername = employeeAccount.getUsername();
        accountKey = employeeAccount.getAccountKey();
    }

    public int getImageResource() {
        return aImageResource;
    }

    public int getAccountType() {
        return aAccountType;
    }

    public int getAccountID() {
        return aAccountID;
    }

    public int getBranchID() {
        return aBranchID;
    }

    public String getName() {
        return aName;
    }

    public String getUsername() {
        return aUsername;
    }

    public String getAccountKey() {return accountKey; }
}