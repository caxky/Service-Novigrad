package com.example.service_novigrad.ui.customer;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class BranchItem implements Parcelable {
    private int bImageResource;
    private String bBranchID;
    private String bBranchOpen;
    private String bBranchClose;
    private String bBranchKey;
    private String[] bServicesOffered;

    public BranchItem(int imageResource, String branchID, String branchOpen, String branchClose, String branchKey) {
        bImageResource = imageResource;
        bBranchID = branchID;
        bBranchOpen = branchOpen;
        bBranchClose = branchClose;
        bBranchKey = branchKey;
        bServicesOffered = new String[]{"Test Service", "Another Service"}; //Loop through the database for the given branchID and push all services to this array
    }

    protected BranchItem(Parcel in) {
        bImageResource = in.readInt();
        bBranchID = in.readString();
        bBranchOpen = in.readString();
        bBranchClose = in.readString();
        bBranchKey = in.readString();
        bServicesOffered = in.createStringArray();
    }

    public static final Creator<BranchItem> CREATOR = new Creator<BranchItem>() {
        @Override
        public BranchItem createFromParcel(Parcel in) {
            return new BranchItem(in);
        }

        @Override
        public BranchItem[] newArray(int size) {
            return new BranchItem[size];
        }
    };

    public String getBranchKey() {
        return  bBranchKey;
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

    public void setbServicesOffered(String[] bServicesOffered) {
        this.bServicesOffered = bServicesOffered;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(bImageResource);
        parcel.writeString(bBranchID);
        parcel.writeString(bBranchOpen);
        parcel.writeString(bBranchClose);
        parcel.writeString(bBranchKey);
        parcel.writeStringArray(bServicesOffered);
    }
}
