package com.example.service_novigrad.accounts;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomerAccount extends Account implements Parcelable {

    //Constructor
    public CustomerAccount(){

    }

//    public CustomerAccount(String username, String password, String firstName, String lastName, long accountID){
//        this.accountType = 0;
//        this.username = username;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.accountID = accountID;
//
//    }
    public CustomerAccount(String username, String password, String firstName, String lastName, long accountID, String accountKey){
        this.accountType = 0;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.accountKey = accountKey;
    }

    protected CustomerAccount(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CustomerAccount> CREATOR = new Creator<CustomerAccount>() {
        @Override
        public CustomerAccount createFromParcel(Parcel in) {
            return new CustomerAccount(in);
        }

        @Override
        public CustomerAccount[] newArray(int size) {
            return new CustomerAccount[size];
        }
    };

    //Class Methods
    public boolean checkIfFilled(){//check if there is a valid value in all
        return (username.equals("") || password.equals("") || firstName.equals("") || lastName.equals(""));
    }

    public void searchBranch(){}

    public void purchaseService(){}

    public void fillService(){}

    public void rateExperience(){}
}