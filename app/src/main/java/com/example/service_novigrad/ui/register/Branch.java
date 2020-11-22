package com.example.service_novigrad.ui.register;

public class Branch {
    private String weekdayOpeningHours, weekdayClosingHours, saturdayOpeningHours, saturdayClosingHours,
            sundayOpeningHours, sundayClosingHours, phoneNumber, emailAddress, branchFirebaseKey;
    private int branchID;

    //Constructors =================================================================================
    public Branch(){

    }

    public Branch(int branchID, String branchFirebaseKey){
        this.branchID = branchID;
        this.branchFirebaseKey = branchFirebaseKey;
        this.phoneNumber = "";
        this.emailAddress = "";

        this.weekdayOpeningHours = "";
        this.weekdayClosingHours = "";
        this.saturdayOpeningHours = "";
        this.saturdayClosingHours = "";
        this.sundayOpeningHours = "";
        this.sundayClosingHours = "";

    }

    public Branch(String branchFirebaseKey, String weekdayOpeningHours, String weekdayClosingHours, String saturdayOpeningHours, String saturdayClosingHours, String sundayOpeningHours, String sundayClosingHours, int branchID, String phoneNumber, String emailAddress) {
        this.branchID = branchID;
        this.branchFirebaseKey = branchFirebaseKey;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

        this.weekdayOpeningHours = weekdayOpeningHours;
        this.weekdayClosingHours = weekdayClosingHours;
        this.saturdayOpeningHours = saturdayOpeningHours;
        this.saturdayClosingHours = saturdayClosingHours;
        this.sundayOpeningHours = sundayOpeningHours;
        this.sundayClosingHours = sundayClosingHours;

    }




    //Getter =======================================================================================
    public String getBranchFirebaseKey(){
        return branchFirebaseKey;
    }

    public String getWeekdayOpeningHours() {
        return weekdayOpeningHours;
    }

    public String getWeekdayClosingHours() {
        return weekdayClosingHours;
    }

    public String getSaturdayOpeningHours() {
        return saturdayOpeningHours;
    }

    public String getSaturdayClosingHours() {
        return saturdayClosingHours;
    }

    public String getSundayOpeningHours() {
        return sundayOpeningHours;
    }

    public String getSundayClosingHours() {return sundayClosingHours;}

    public String getPhoneNumber() {return phoneNumber;}

    public int getBranchID() {return branchID;}

    public String getEmailAddress() {return emailAddress;}




    //Setter =======================================================================================
    public void setWeekdayOpeningHours(String weekdayOpeningHours) {
        this.weekdayOpeningHours = weekdayOpeningHours;
    }

    public void setWeekdayClosingHours(String weekdayClosingHours) {
        this.weekdayClosingHours = weekdayClosingHours;
    }

    public void setSaturdayOpeningHours(String saturdayOpeningHours) {
        this.saturdayOpeningHours = saturdayOpeningHours;
    }

    public void setSaturdayClosingHours(String saturdayClosingHours) {
        this.saturdayClosingHours = saturdayClosingHours;
    }

    public void setSundayOpeningHours(String sundayOpeningHours) {
        this.sundayOpeningHours = sundayOpeningHours;
    }

    public void setSundayClosingHours(String sundayClosingHours) {
        this.sundayClosingHours = sundayClosingHours;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setBranchFirebaseKey(String branchFirebaseKey) {
        this.branchFirebaseKey = branchFirebaseKey;
    }
}
