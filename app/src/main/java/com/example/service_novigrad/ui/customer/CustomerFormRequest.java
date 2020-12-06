package com.example.service_novigrad.ui.customer;

import android.net.Uri;
import android.util.Pair;

import com.example.service_novigrad.ui.services.FieldsAndAttachments;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerFormRequest {
    FieldsAndAttachments booleanfields;
    HashMap<String,String> filledfields;
    HashMap<String,Uri> attachments;
    String serviceKey;

    public CustomerFormRequest(FieldsAndAttachments fields, HashMap<String, String> filledfields, HashMap<String, Uri> attachments, String serviceKey){
        this.booleanfields = fields;
        this.filledfields = filledfields;
        this.attachments = attachments;
        this.serviceKey = serviceKey;
    }

    public FieldsAndAttachments getBooleanfields() {
        return booleanfields;
    }

    public HashMap<String,String> getFilledfields() {
        return filledfields;
    }

    public HashMap<String,Uri> getAttachments() {
        return attachments;
    }

    public String getServicekey() {
        return serviceKey;
    }
}
