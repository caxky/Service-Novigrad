package com.example.service_novigrad.ui.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.admin.AdminServices;

import java.util.ArrayList;

public class ServiceItemActivity extends AppCompatActivity {

    private CheckBox firstName, lastName, maidenName, gender, nationality, POB, expiryDate, issueDate, DOB, signature, address, issuingAuthority, height, weight, bloodType, hairColour, eyeColour, classID, passport, birthCertificate, driversLicense, citzenshipCard, SIN, healthInsurance;
    private Button apply;
    private ArrayList<String> fields;
    private ArrayList<String> attachments;

    private TextView textViewServiceName;
    private TextView textViewServiceType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.default_services);

        String srName = intent.getStringExtra(AdminServices.EXTRA_TEXT);
        String srType = intent.getStringExtra(AdminServices.EXTRA_TEXT2);
        textViewServiceName = (TextView) findViewById(R.id.textViewServiceName);
        textViewServiceType = (TextView) findViewById(R.id.textViewServiceType);
        textViewServiceName.setText(srName);
        textViewServiceType.setText(srType);

        firstName = findViewById(R.id.checkBoxFirstName);
        lastName = findViewById(R.id.checkBoxLastName);
        maidenName = findViewById(R.id.checkBoxMaidenName);
        gender = findViewById(R.id.checkBoxGender);
        nationality = findViewById(R.id.checkBoxNationality);
        POB = findViewById(R.id.checkBoxPlaceOfBirth);
        expiryDate = findViewById(R.id.checkBoxExpiryDate);
        issueDate = findViewById(R.id.checkBoxIssueDate);
        DOB = findViewById(R.id.checkBoxDateOfBirth);
        signature = findViewById(R.id.checkBoxSignature);
        address = findViewById(R.id.checkBoxAddress);
        issuingAuthority = findViewById(R.id.checkBoxIssuingAuthority);
        height = findViewById(R.id.checkBoxHeight);
        weight = findViewById(R.id.checkBoxWeight);
        bloodType = findViewById(R.id.checkBoxBloodType);
        hairColour = findViewById(R.id.checkBoxHairColour);
        eyeColour = findViewById(R.id.checkBoxEyeColour);
        classID = findViewById(R.id.checkBoxClass);

        passport = findViewById(R.id.checkBoxPassport);
        birthCertificate = findViewById(R.id.checkBoxBirthCertificate);
        driversLicense = findViewById(R.id.checkBoxDriversLicense);
        citzenshipCard = findViewById(R.id.checkBoxCitizenshipCard);
        SIN = findViewById(R.id.checkBoxSocialSecurity);
        healthInsurance = findViewById(R.id.checkBoxHealthInsurance);

        fields = new ArrayList<String>();
        attachments = new ArrayList<String>();

        apply = findViewById(R.id.applySelectedServices);
        apply.setEnabled(false);


    }
    public void onFieldCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxFirstName:
                if (checked){
                    fields.add("First Name");
                }
                else{
                    fields.remove("First Name");
                }
                break;

            case R.id.checkBoxLastName:
                if (checked){
                    fields.add("Last Name");
                }
                else{
                    fields.remove("Last Name");
                }
                break;

            case R.id.checkBoxMaidenName:
                if (checked) {
                    fields.add("Maiden Name");
                }
                else{
                    fields.remove("Maiden Name");
                }
                break;

            case R.id.checkBoxGender:
                if (checked) {
                    fields.add("Gender");
                }
                else{
                    fields.remove("Gender");
                }
                break;
            case R.id.checkBoxNationality:
                if (checked) {
                    fields.add("Nationality");
                }
                else{
                    fields.remove("Nationality");
                }
                break;

            case R.id.checkBoxPlaceOfBirth:
                if (checked) {
                    fields.add("Place of Birth");
                }
                else{
                    fields.remove("Place of Birth");
                }
                break;

            case R.id.checkBoxExpiryDate:
                if (checked) {
                    fields.add("Expiry Date");
                }
                else{
                    fields.remove("Expiry Date");
                }
                break;

            case R.id.checkBoxIssueDate:
                if (checked) {
                    fields.add("Issue Date");
                }
                else{
                    fields.remove("Issue Date");
                }
                break;

            case R.id.checkBoxDateOfBirth:
                if (checked) {
                    fields.add("Birth Date");
                }
                else{
                    fields.remove("Birth Date");
                }
                break;

            case R.id.checkBoxSignature:
                if (checked) {
                    fields.add("Signature");
                }
                else{
                    fields.remove("Signature");
                }
                break;

            case R.id.checkBoxAddress:
                if (checked) {
                    fields.add("Address");
                }
                else{
                    fields.remove("Address");
                }
                break;

            case R.id.checkBoxIssuingAuthority:
                if (checked) {
                    fields.add("Issuing Authority");
                }
                else{
                    fields.remove("Issuing Authority");
                }
                break;

            case R.id.checkBoxHeight:
                if (checked) {
                    fields.add("Height");
                }
                else{
                    fields.remove("Height");
                }
                break;

            case R.id.checkBoxWeight:
                if (checked) {
                    fields.add("Weight");
                }
                else{
                    fields.remove("Weight");
                }
                break;

            case R.id.checkBoxBloodType:
                if (checked) {
                    fields.add("Blood Type");
                }
                else{
                    fields.remove("Blood Type");
                }
                break;

            case R.id.checkBoxHairColour:
                if (checked) {
                    fields.add("Hair Colour");
                }
                else{
                    fields.remove("Hair Colour");
                }
                break;

            case R.id.checkBoxEyeColour:
                if (checked) {
                    fields.add("Eye Colour");
                }
                else{
                    fields.remove("Eye Colour");
                }
                break;

            case R.id.checkBoxClass:
                if (checked) {
                    fields.add("Class");
                }
                else{
                    fields.remove("Class");
                }
                break;
        }
    }

    public void onAttachmentCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxPassport:
                if (checked) {
                    attachments.add("Passport");
                } else {
                    attachments.remove("Passport");
                }
                break;

            case R.id.checkBoxBirthCertificate:
                if (checked) {
                    attachments.add("Birth Certificate");
                } else {
                    attachments.remove("Birth Certificate");
                }
                break;

            case R.id.checkBoxDriversLicense:
                if (checked) {
                    attachments.add("Driver's License");
                } else {
                    attachments.remove("Driver's License");
                }
                break;

            case R.id.checkBoxCitizenshipCard:
                if (checked) {
                    attachments.add("Citizenship Card");
                } else {
                    attachments.remove("Citizenship Card");
                }
                break;

            case R.id.checkBoxSocialSecurity:
                if (checked) {
                    attachments.add("SIN");
                } else {
                    attachments.remove("SIN");
                }
                break;

            case R.id.checkBoxHealthInsurance:
                if (checked) {
                    attachments.add("Health Insurance");
                } else {
                    attachments.remove("Health Insurance");
                }
                break;
        }
    }
}
