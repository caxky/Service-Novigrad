package com.example.service_novigrad.ui.customer;


public class BranchServiceItem{
    private int bsImageResource;
    private String bsServiceName;

    public BranchServiceItem(int imageResource, String serviceName) {
        bsServiceName = serviceName;
        bsImageResource = imageResource;
    }

    public int getImageResource() {
        return bsImageResource;
    }

    public String getBranchServiceName() {
        return bsServiceName;
    }
}