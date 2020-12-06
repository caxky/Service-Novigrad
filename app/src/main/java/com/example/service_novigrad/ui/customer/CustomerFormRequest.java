package com.example.service_novigrad.ui.customer;

import android.net.Uri;
import android.util.Pair;

import com.example.service_novigrad.ui.services.FieldsAndAttachments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerFormRequest {
    FieldsAndAttachments booleanfields;
    Map<String,String> filledfields;
    Map<String,Uri> attachments;
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

    public Map<String,String> getFilledfields() {
        return filledfields;
    }

    public Map<String,Uri> getAttachments() {
        return attachments;
    }

    public String getServicekey() {
        return serviceKey;
    }
}
