package com.example.service_novigrad.ui.services;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

//Since we dont need image resources to be in the firebase we use @IgnoreExtraProperties + the
// exclude annotation on the getter to ignore it when we push it into firebase
@IgnoreExtraProperties
public class ServiceItem {

    private String serviceName;
    private String serviceType;
    private FieldsAndAttachments fieldsAndAttachments = new FieldsAndAttachments();
    private int imageResource;
    private String serviceID;

    public ServiceItem(){
    }
    public ServiceItem(String serviceName, String serviceType, String serviceID, FieldsAndAttachments fieldsAndAttachments){
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.fieldsAndAttachments = fieldsAndAttachments;
    }
    public ServiceItem(int imageResource, String serviceName, String serviceType, String serviceID) {
        this.imageResource = imageResource;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        fieldsAndAttachments = new FieldsAndAttachments(serviceType);
        this.serviceID = serviceID;
    }


    public int getImageResource() {
        return imageResource;
    }

    public String getServiceName() { return serviceName;}

    public String getServiceType() { return serviceType;}

    public FieldsAndAttachments getFieldsAndAttachments() {
        return fieldsAndAttachments;
    }

    public String getServiceID(){ return serviceID;}

    public void changeText1(String text) {
        serviceName = text;
    }
}
