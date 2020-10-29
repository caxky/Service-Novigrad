package com.example.service_novigrad.ui.services;

public class ServiceItem {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public ServiceItem(int imageResource, String serviceName, String serviceType) {
        mImageResource = imageResource;
        mText1 = serviceName;
        mText2 = serviceType;

    }

    public void changeText1(String text){
        mText1 = text;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getServiceName(){
        return mText1;
    }

    public String getServiceType(){
        return mText2;
    }

}
