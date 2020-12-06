package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.customer.CustomerFormRequest;
import com.example.service_novigrad.ui.customer.CustomerServiceForm;

public class ServiceRequestItem {

    private int imageResource;
    //private String serviceName;
    private String userName;
    private Boolean status;
    private CustomerFormRequest form;

    public ServiceRequestItem(int imageResource, String serviceName, String userName, CustomerFormRequest form){
        this.imageResource = imageResource;
        //this.serviceName = serviceName;
        this.status = false;
        this.form = form;
        this.userName = form.getFilledfields().get("First Name");
    }

    public CustomerFormRequest getForm(){
        return form;
    }

    public int getImageResource(){
        return imageResource;
    }

    //public String getServiceName(){
        //return serviceName;
   // }

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