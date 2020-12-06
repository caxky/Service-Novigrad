package com.example.service_novigrad.ui.services;

import android.os.Parcel;
import android.os.Parcelable;

//This class is used to enter all the field and attachment info to a service into the database
public class FieldsAndAttachments implements Parcelable {

    private boolean firstName, lastName, maidenName, gender, nationality, POB, expiryDate, issueDate, DOB, signature, address, issuingAuthority, height, weight, bloodType, hairColour, eyeColour, classID, proofOfStatus, birthCertificate, driversLicense, photoOfCustomer, SIN, proofOfResidence;
    private String serviceCost;
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
            serviceCost = "54.99";

        }else if (serviceType.equals("Photo ID Service")){
            firstName = true;
            lastName = true;
            DOB = true;
            address = true;
            proofOfResidence = true;
            proofOfStatus = true;
            serviceCost = "25.99";
        }else if (serviceType.equals("Driver's License Service")){
            firstName = true;
            lastName = true;
            DOB = true;
            address = true;
            proofOfResidence = true;
            photoOfCustomer = true;
            serviceCost = "25.99";

        }
    }
    //getters for the fields and attachments =======================================================


    protected FieldsAndAttachments(Parcel in) {
        firstName = in.readByte() != 0;
        lastName = in.readByte() != 0;
        maidenName = in.readByte() != 0;
        gender = in.readByte() != 0;
        nationality = in.readByte() != 0;
        POB = in.readByte() != 0;
        expiryDate = in.readByte() != 0;
        issueDate = in.readByte() != 0;
        DOB = in.readByte() != 0;
        signature = in.readByte() != 0;
        address = in.readByte() != 0;
        issuingAuthority = in.readByte() != 0;
        height = in.readByte() != 0;
        weight = in.readByte() != 0;
        bloodType = in.readByte() != 0;
        hairColour = in.readByte() != 0;
        eyeColour = in.readByte() != 0;
        classID = in.readByte() != 0;
        proofOfStatus = in.readByte() != 0;
        birthCertificate = in.readByte() != 0;
        driversLicense = in.readByte() != 0;
        photoOfCustomer = in.readByte() != 0;
        SIN = in.readByte() != 0;
        proofOfResidence = in.readByte() != 0;
        serviceCost = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (firstName ? 1 : 0));
        dest.writeByte((byte) (lastName ? 1 : 0));
        dest.writeByte((byte) (maidenName ? 1 : 0));
        dest.writeByte((byte) (gender ? 1 : 0));
        dest.writeByte((byte) (nationality ? 1 : 0));
        dest.writeByte((byte) (POB ? 1 : 0));
        dest.writeByte((byte) (expiryDate ? 1 : 0));
        dest.writeByte((byte) (issueDate ? 1 : 0));
        dest.writeByte((byte) (DOB ? 1 : 0));
        dest.writeByte((byte) (signature ? 1 : 0));
        dest.writeByte((byte) (address ? 1 : 0));
        dest.writeByte((byte) (issuingAuthority ? 1 : 0));
        dest.writeByte((byte) (height ? 1 : 0));
        dest.writeByte((byte) (weight ? 1 : 0));
        dest.writeByte((byte) (bloodType ? 1 : 0));
        dest.writeByte((byte) (hairColour ? 1 : 0));
        dest.writeByte((byte) (eyeColour ? 1 : 0));
        dest.writeByte((byte) (classID ? 1 : 0));
        dest.writeByte((byte) (proofOfStatus ? 1 : 0));
        dest.writeByte((byte) (birthCertificate ? 1 : 0));
        dest.writeByte((byte) (driversLicense ? 1 : 0));
        dest.writeByte((byte) (photoOfCustomer ? 1 : 0));
        dest.writeByte((byte) (SIN ? 1 : 0));
        dest.writeByte((byte) (proofOfResidence ? 1 : 0));
        dest.writeString(serviceCost);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FieldsAndAttachments> CREATOR = new Creator<FieldsAndAttachments>() {
        @Override
        public FieldsAndAttachments createFromParcel(Parcel in) {
            return new FieldsAndAttachments(in);
        }

        @Override
        public FieldsAndAttachments[] newArray(int size) {
            return new FieldsAndAttachments[size];
        }
    };

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
