package com.example.service_novigrad.ui.services;

//This class is used to enter all the field and attachment info to a service into the database
public class FieldsAndAttachments {

    private boolean firstName, lastName, maidenName, gender, nationality, POB, expiryDate, issueDate, DOB, signature, address, issuingAuthority, height, weight, bloodType, hairColour, eyeColour, classID, proofOfStatus, birthCertificate, driversLicense, photoOfCustomer, SIN, proofOfResidence;

    //Default Constructor
    public FieldsAndAttachments(){

    }

    //Constructor
    public FieldsAndAttachments(String serviceType){
        if (serviceType.equals("Health Card Service")){
            firstName = true;
            lastName = true;
            DOB = true;
            address = true;
            driversLicense = true;
            proofOfResidence = true;

        }else if (serviceType.equals("Photo ID Service")){
            firstName = true;
            lastName = true;
            DOB = true;
            address = true;
            proofOfResidence = true;
            proofOfStatus = true;
        }else if (serviceType.equals("Driver's License Service")){
            firstName = true;
            lastName = true;
            DOB = true;
            address = true;
            proofOfResidence = true;
            photoOfCustomer = true;

        }
    }
    //getters for the fields and attachments =======================================================


    public boolean isFirstName() {
        return firstName;
    }

    public boolean isLastName() {
        return lastName;
    }

    public boolean isMaidenName() {
        return maidenName;
    }

    public boolean isGender() {
        return gender;
    }

    public boolean isNationality() {
        return nationality;
    }

    public boolean isPOB() {
        return POB;
    }

    public boolean isExpiryDate() {
        return expiryDate;
    }

    public boolean isIssueDate() {
        return issueDate;
    }

    public boolean isDOB() {
        return DOB;
    }

    public boolean isSignature() {
        return signature;
    }

    public boolean isAddress() {
        return address;
    }

    public boolean isIssuingAuthority() {
        return issuingAuthority;
    }

    public boolean isHeight() {
        return height;
    }

    public boolean isWeight() {
        return weight;
    }

    public boolean isBloodType() {
        return bloodType;
    }

    public boolean isHairColour() {
        return hairColour;
    }

    public boolean isEyeColour() {
        return eyeColour;
    }

    public boolean isClassID() {
        return classID;
    }

    public boolean isProofOfStatus() {
        return proofOfStatus;
    }

    public boolean isBirthCertificate() {
        return birthCertificate;
    }

    public boolean isDriversLicense() {
        return driversLicense;
    }

    public boolean isPhotoOfCustomer() {
        return photoOfCustomer;
    }

    public boolean isSIN() {
        return SIN;
    }

    public boolean isProofOfResidence() {
        return proofOfResidence;
    }




    //setters for the fields and attachments =======================================================
    public void setFirstName(boolean firstName) {
        this.firstName = firstName;
    }

    public void setLastName(boolean lastName) {
        this.lastName = lastName;
    }

    public void setMaidenName(boolean maidenName) {
        this.maidenName = maidenName;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setNationality(boolean nationality) {
        this.nationality = nationality;
    }

    public void setPOB(boolean POB) {
        this.POB = POB;
    }

    public void setExpiryDate(boolean expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setIssueDate(boolean issueDate) {
        this.issueDate = issueDate;
    }

    public void setDOB(boolean DOB) {
        this.DOB = DOB;
    }

    public void setSignature(boolean signature) {
        this.signature = signature;
    }

    public void setAddress(boolean address) {
        this.address = address;
    }

    public void setIssuingAuthority(boolean issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public void setHeight(boolean height) {
        this.height = height;
    }

    public void setWeight(boolean weight) {
        this.weight = weight;
    }

    public void setBloodType(boolean bloodType) {
        this.bloodType = bloodType;
    }

    public void setHairColour(boolean hairColour) {
        this.hairColour = hairColour;
    }

    public void setEyeColour(boolean eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setClassID(boolean classID) {
        this.classID = classID;
    }

    public void setProofOfStatus(boolean proofOfStatus) {
        this.proofOfStatus = proofOfStatus;
    }

    public void setBirthCertificate(boolean birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public void setDriversLicense(boolean driversLicense) {
        this.driversLicense = driversLicense;
    }

    public void setPhotoOfCustomer(boolean photoOfCustomer) {
        this.photoOfCustomer = photoOfCustomer;
    }

    public void setSIN(boolean SIN) {
        this.SIN = SIN;
    }

    public void setProofOfResidence(boolean proofOfResidence) {
        this.proofOfResidence = proofOfResidence;
    }
}
