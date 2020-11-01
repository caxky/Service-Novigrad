package com.example.service_novigrad.ui.accounts;


public class AccountItem {

    private int aImageResource;
    private int aAccountID;
    private int aAccountType;
    private int aBranchID;
    private String aName;
    private String aUsername;

    public AccountItem(int imageResource, int accountID, String firstName, String lastName, String username) {
        aImageResource = imageResource;
        aAccountType = 0;
        aAccountID = accountID;
        aName = firstName + " " + lastName;
        aUsername = username;
    }

    public AccountItem(int imageResource, int accountID, String firstName, String lastName, String username, int branchID) {
        aImageResource = imageResource;
        aAccountType = 1;
        aAccountID = accountID;
        aBranchID = branchID;
        aName = firstName + " " + lastName;
        aUsername = username;
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
}