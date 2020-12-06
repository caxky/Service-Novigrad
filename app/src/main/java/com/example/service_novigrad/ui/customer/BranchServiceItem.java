package com.example.service_novigrad.ui.customer;


import android.os.Parcel;
import android.os.Parcelable;

public class BranchServiceItem implements Parcelable {
    private int bsImageResource;
    private String bsServiceName;
    private String originalServiceKey;

    public BranchServiceItem(int imageResource, String serviceName, String originalServiceKey) {
        bsServiceName = serviceName;
        bsImageResource = imageResource;
        this.originalServiceKey = originalServiceKey;
    }
    public int getImageResource() {
        return bsImageResource;
    }

    public String getOriginalServiceKey() {
        return originalServiceKey;
    }

    public String getBranchServiceName() {
        return bsServiceName;
    }

    protected BranchServiceItem(Parcel in) {
        bsImageResource = in.readInt();
        bsServiceName = in.readString();
        originalServiceKey = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bsImageResource);
        dest.writeString(bsServiceName);
        dest.writeString(originalServiceKey);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BranchServiceItem> CREATOR = new Creator<BranchServiceItem>() {
        @Override
        public BranchServiceItem createFromParcel(Parcel in) {
            return new BranchServiceItem(in);
        }

        @Override
        public BranchServiceItem[] newArray(int size) {
            return new BranchServiceItem[size];
        }
    };


}