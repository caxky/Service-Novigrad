package com.example.service_novigrad.ui.services;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

//Since we dont need image resources to be in the firebase we use @IgnoreExtraProperties + the
// exclude annotation on the getter to ignore it when we push it into firebase
@IgnoreExtraProperties
public class ServiceItem {

    private String mText1;
    private String mText2;
    private FieldsAndAttachments fieldsAndAttachments = new FieldsAndAttachments();
    private int mImageResource;

//    private boolean firstName, lastName, maidenName, gender, nationality, POB, expiryDate, issueDate, DOB, signature, address, issuingAuthority, height, weight, bloodType, hairColour, eyeColour, classID, passport, birthCertificate, driversLicense, citzenshipCard, SIN, healthInsurance;

    public ServiceItem(int imageResource, String serviceName, String serviceType) {
        mImageResource = imageResource;
        mText1 = serviceName;
        mText2 = serviceType;
        fieldsAndAttachments = new FieldsAndAttachments(serviceType);
    }


    public void changeText1(String text) {
        mText1 = text;
    }

    @Exclude
    public int getImageResource() {
        return mImageResource;
    }

    public String getServiceName() { return mText1;}

    public String getServiceType() { return mText2;}

    public FieldsAndAttachments getFieldsAndAttachments() {
        return fieldsAndAttachments;
    }


}
