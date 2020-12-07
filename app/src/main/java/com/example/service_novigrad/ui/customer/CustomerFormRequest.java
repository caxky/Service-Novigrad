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
    FieldsAndAttachments booleanFields;
    Map<String, String> filledFields;
    Map<String, String> attachments;
    BranchServiceItem branchServiceItem;
    public CustomerFormRequest(){

    }
    public CustomerFormRequest(FieldsAndAttachments booleanFields, Map<String, String> filledFields, Map<String, String> attachments, BranchServiceItem branchServiceItem) {
        this.booleanFields = booleanFields;
        this.filledFields = filledFields;
        this.attachments = attachments;
        this.branchServiceItem = branchServiceItem;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public FieldsAndAttachments getBooleanFields() {
        return booleanFields;
    }

    public Map<String, String> getFilledFields() {
        return filledFields;
    }

    public BranchServiceItem getBranchServiceItem() {
        return branchServiceItem;
    }


    protected CustomerFormRequest(Parcel in) {
        booleanFields = in.readParcelable(FieldsAndAttachments.class.getClassLoader());
        branchServiceItem = in.readParcelable(BranchServiceItem.class.getClassLoader());
        filledFields = in.readHashMap(HashMap.class.getClassLoader());
        attachments = in.readHashMap(HashMap.class.getClassLoader());
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
        parcel.writeParcelable(booleanFields, i);
        parcel.writeParcelable(branchServiceItem,i);
        parcel.writeMap(filledFields);
        parcel.writeMap(attachments);
    }
}
