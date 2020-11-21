package com.example.service_novigrad.ui.employee;

public class AddServicesItem {
    private int mImageResource;
    private String empServiceName;
    private String empServiceType;

    public AddServicesItem(int imageResource, String serviceName, String serviceType){
        mImageResource = imageResource;
        empServiceName = serviceName;
        empServiceType = serviceType;
    }

    public int getmImageResource(){return mImageResource;}

    public String getEmpServiceName(){return empServiceName;}

    public String  getEmpServiceType(){return empServiceType;}

    public void changeText1(String text){
        empServiceName = text;
    }
}
