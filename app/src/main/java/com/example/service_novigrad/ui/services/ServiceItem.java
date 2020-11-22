package com.example.service_novigrad.ui.services;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.service_novigrad.R;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Since we dont need image resources to be in the firebase we use @IgnoreExtraProperties + the
// exclude annotation on the getter to ignore it when we push it into firebase
@IgnoreExtraProperties
public class ServiceItem implements Parcelable {

    private String serviceName;
    private String serviceType;
    private FieldsAndAttachments fieldsAndAttachments = new FieldsAndAttachments();
    private int imageResource;
    private String serviceID;

    public ServiceItem(){
    }
    public ServiceItem(String serviceName, String serviceType, String serviceID, FieldsAndAttachments fieldsAndAttachments){
        this.imageResource = R.drawable.gear;
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


    protected ServiceItem(Parcel in) {
        serviceName = in.readString();
        serviceType = in.readString();
        imageResource = in.readInt();
        serviceID = in.readString();
    }

    public static final Creator<ServiceItem> CREATOR = new Creator<ServiceItem>() {
        @Override
        public ServiceItem createFromParcel(Parcel in) {
            return new ServiceItem(in);
        }

        @Override
        public ServiceItem[] newArray(int size) {
            return new ServiceItem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(serviceName);
        parcel.writeString(serviceType);
        parcel.writeInt(imageResource);
        parcel.writeString(serviceID);
    }
}
