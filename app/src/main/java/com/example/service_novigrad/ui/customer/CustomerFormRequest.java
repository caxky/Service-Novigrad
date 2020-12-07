package com.example.service_novigrad.ui.customer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import com.example.service_novigrad.ui.services.FieldsAndAttachments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerFormRequest implements Parcelable {
    FieldsAndAttachments booleanfields;
    Map<String, String> filledfields;
    Map<String, String> attachments;
    BranchServiceItem branchServiceItem;
    public CustomerFormRequest(){

    }
    public CustomerFormRequest(FieldsAndAttachments fields, HashMap<String, String> filledfields, HashMap<String, String> attachments, BranchServiceItem branchServiceItem) {
        this.booleanfields = fields;
        this.filledfields = filledfields;
        this.attachments = attachments;
        this.branchServiceItem = branchServiceItem;
    }


    public FieldsAndAttachments getBooleanfields() {
        return booleanfields;
    }

    public Map<String, String> getFilledfields() {
        return filledfields;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public BranchServiceItem getBranchServiceItem() {
        return branchServiceItem;
    }


    protected CustomerFormRequest(Parcel in) {
        booleanfields = in.readParcelable(FieldsAndAttachments.class.getClassLoader());
        branchServiceItem = in.readParcelable(BranchServiceItem.class.getClassLoader());
    }

    public static final Creator<CustomerFormRequest> CREATOR = new Creator<CustomerFormRequest>() {
        @Override
        public CustomerFormRequest createFromParcel(Parcel in) {
            return new CustomerFormRequest(in);
        }

        @Override
        public CustomerFormRequest[] newArray(int size) {
            return new CustomerFormRequest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(booleanfields, i);
        parcel.writeParcelable(branchServiceItem,i);
    }
}
