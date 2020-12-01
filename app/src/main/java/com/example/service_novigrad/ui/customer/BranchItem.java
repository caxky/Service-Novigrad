package com.example.service_novigrad.ui.customer;

import android.widget.ImageView;

public class BranchItem {
    private int bImageResource;
    private String bBranchID;
    private String bBranchOpen;
    private String bBranchClose;
    private String[] bServicesOffered;

    public BranchItem(int imageResource, String branchID, String branchOpen, String branchClose) {
        bImageResource = imageResource;
        bBranchID = branchID;
        bBranchOpen = branchOpen;
        bBranchClose = branchClose;

        bServicesOffered = new String[]{"Test Service", "Another Service"}; //Loop through the database for the given branchID and push all services to this array
    }

    public int getImageResource(){
        return bImageResource;
    }

    public String getBranchID(){
        return bBranchID;
    }

    public String getBranchOpen(){
        return bBranchOpen;
    }

    public String getBranchClose(){
        return bBranchClose;
    }

    public String[] getServicesOffered() {
        return bServicesOffered;
    }

    public int getNumServicesOffered() {
        return bServicesOffered.length;
    }
}
