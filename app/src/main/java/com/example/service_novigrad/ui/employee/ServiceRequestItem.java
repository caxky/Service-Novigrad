package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.customer.CustomerFormRequest;
import com.example.service_novigrad.ui.customer.CustomerServiceForm;

public class ServiceRequestItem implements Parcelable {

    private int imageResource;
    private String serviceName;
    private String userName;
    private Boolean status;
    private CustomerFormRequest form;

    public ServiceRequestItem(int imageResource, String serviceName, CustomerFormRequest form){
        this.imageResource = imageResource;
        this.serviceName = serviceName;
        this.status = false;
        this.form = form;
        this.userName = form.getFilledfields().get("First Name");
    }

    protected ServiceRequestItem(Parcel in) {
        imageResource = in.readInt();
        userName = in.readString();
        byte tmpStatus = in.readByte();
        status = tmpStatus == 0 ? null : tmpStatus == 1;
        form = in.readParcelable(CustomerFormRequest.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResource);
        dest.writeString(userName);
        dest.writeByte((byte) (status == null ? 0 : status ? 1 : 2));
        dest.writeParcelable(form, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ServiceRequestItem> CREATOR = new Creator<ServiceRequestItem>() {
        @Override
        public ServiceRequestItem createFromParcel(Parcel in) {
            return new ServiceRequestItem(in);
        }

        @Override
        public ServiceRequestItem[] newArray(int size) {
            return new ServiceRequestItem[size];
        }
    };

    public CustomerFormRequest getForm(){
        return form;
    }

    public int getImageResource(){
        return imageResource;
    }

    public String getServiceName(){
        return serviceName;
    }

    public String getUserName(){
        return userName;
    }

    public Boolean getStatus(){
        return status;
    }

    public void setStatus(Boolean bool){
        status = bool;
    }
}