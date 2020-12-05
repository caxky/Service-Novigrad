package com.example.service_novigrad.ui.register;

//This class is used to store an info of the branch
public class Branch {
    private String mondayOpeningHours, mondayClosingHours, tuesdayOpeningHours, tuesdayClosingHours, wednesdayOpeningHours, wednesdayClosingHours, thursdayOpeningHours, thursdayClosingHours, fridayOpeningHours, fridayClosingHours, saturdayOpeningHours, saturdayClosingHours,
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

        this.mondayOpeningHours = "";
        this.mondayClosingHours = "";
        this.tuesdayOpeningHours = "";
        this.tuesdayClosingHours = "";
        this.wednesdayOpeningHours = "";
        this.wednesdayClosingHours = "";
        this.thursdayOpeningHours = "";
        this.thursdayClosingHours = "";
        this.fridayOpeningHours = "";
        this.fridayClosingHours = "";
        this.saturdayOpeningHours = "";
        this.saturdayClosingHours = "";
        this.sundayOpeningHours = "";
        this.sundayClosingHours = "";

    }

    public Branch(String branchFirebaseKey, String mondayOpeningHours, String mondayClosingHours, String tuesdayOpeningHours, String tuesdayClosingHours, String wednesdayOpeningHours, String wednesdayClosingHours, String thursdayOpeningHours, String thursdayClosingHours, String fridayOpeningHours, String fridayClosingHours, String saturdayOpeningHours, String saturdayClosingHours, String sundayOpeningHours, String sundayClosingHours, int branchID, String phoneNumber, String emailAddress) {
        this.branchID = branchID;
        this.branchFirebaseKey = branchFirebaseKey;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

        this.mondayOpeningHours = mondayOpeningHours;
        this.mondayClosingHours = mondayClosingHours;
        this.tuesdayOpeningHours = tuesdayOpeningHours;
        this.tuesdayClosingHours = tuesdayClosingHours;
        this.wednesdayOpeningHours = wednesdayOpeningHours;
        this.wednesdayClosingHours = wednesdayClosingHours;
        this.thursdayOpeningHours = thursdayOpeningHours;
        this.thursdayClosingHours = thursdayClosingHours;
        this.fridayOpeningHours = fridayOpeningHours;
        this.fridayClosingHours = fridayClosingHours;
        this.saturdayOpeningHours = saturdayOpeningHours;
        this.saturdayClosingHours = saturdayClosingHours;
        this.sundayOpeningHours = sundayOpeningHours;
        this.sundayClosingHours = sundayClosingHours;

    }




    //Getter =======================================================================================
    public String getBranchFirebaseKey(){
        return branchFirebaseKey;
    }

    public String getMondayOpeningHours() {
        return mondayOpeningHours;
    }

    public String getMondayClosingHours() {
        return mondayClosingHours;
    }

    public String getTuesdayOpeningHours() {
        return tuesdayOpeningHours;
    }

    public String getTuesdayClosingHours() {
        return tuesdayClosingHours;
    }

    public String getWednesdayOpeningHours() {
        return wednesdayOpeningHours;
    }

    public String getWednesdayClosingHours() {
        return wednesdayClosingHours;
    }

    public String getThursdayOpeningHours() {
        return thursdayOpeningHours;
    }

    public String getThursdayClosingHours() {
        return thursdayClosingHours;
    }

    public String getFridayOpeningHours() {
        return fridayOpeningHours;
    }

    public String getFridayClosingHours() {
        return fridayClosingHours;
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
    public void setMondayOpeningHours(String mondayOpeningHours) {
        this.mondayOpeningHours = mondayOpeningHours;
    }

    public void setMondayClosingHours(String mondayClosingHours) {
        this.mondayClosingHours = mondayClosingHours;
    }

    public void setTuesdayOpeningHours(String tuesdayOpeningHours) {
        this.tuesdayOpeningHours = tuesdayOpeningHours;
    }

    public void setTuesdayClosingHours(String tuesdayClosingHours) {
        this.tuesdayClosingHours = tuesdayClosingHours;
    }

    public void setWednesdayOpeningHours(String wednesdayOpeningHours) {
        this.wednesdayOpeningHours = wednesdayOpeningHours;
    }

    public void setWednesdayClosingHours(String wednesdayClosingHours) {
        this.wednesdayClosingHours = wednesdayClosingHours;
    }

    public void setThursdayOpeningHours(String thursdayOpeningHours) {
        this.thursdayOpeningHours = thursdayOpeningHours;
    }

    public void setThursdayClosingHours(String thursdayClosingHours) {
        this.thursdayClosingHours = thursdayClosingHours;
    }

    public void setFridayOpeningHours(String fridayOpeningHours) {
        this.fridayOpeningHours = fridayOpeningHours;
    }

    public void setFridayClosingHours(String fridayClosingHours) {
        this.fridayClosingHours = fridayClosingHours;
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
