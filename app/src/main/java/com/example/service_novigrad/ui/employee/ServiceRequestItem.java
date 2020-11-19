package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.service_novigrad.R;

public class ServiceRequestItem {

    private int imageResource;
    private String serviceName;
    private String userName;
    private Boolean status;

    public ServiceRequestItem(int imageResource, String serviceName, String userName){
        this.imageResource = imageResource;
        this.serviceName = serviceName;
        this.userName = userName;
        this.status = false;
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