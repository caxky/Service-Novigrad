package com.example.service_novigrad.ui.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.admin.AdminServices;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ServiceItemActivity extends AppCompatActivity {

    private CheckBox firstName, lastName, maidenName, gender, nationality, POB, expiryDate, issueDate, DOB, signature, address, issuingAuthority, height, weight, bloodType, hairColour, eyeColour, classID, proofOfStatus, birthCertificate, driversLicense, photoOfCustomer, SIN, proofOfResidence;
    private Button apply;
    private ArrayList<String> fields;
    private ArrayList<String> attachments;

    private TextView textViewServiceName;
    private TextView textViewServiceType;

    private ServiceItem currentService;
    private FieldsAndAttachments fieldsAndAttachments = new FieldsAndAttachments();

    private String currentServiceID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.default_services);

        final String srName = intent.getStringExtra(AdminServices.EXTRA_TEXT);
        final String srType = intent.getStringExtra(AdminServices.EXTRA_TEXT2);
        currentServiceID = intent.getStringExtra("serviceID");
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

        proofOfStatus = findViewById(R.id.checkBoxProofOfStatus);
        birthCertificate = findViewById(R.id.checkBoxBirthCertificate);
        driversLicense = findViewById(R.id.checkBoxDriversLicense);
        photoOfCustomer = findViewById(R.id.checkBoxPhotoOfCustomer);
        SIN = findViewById(R.id.checkBoxSocialSecurity);
        proofOfResidence = findViewById(R.id.checkBoxProofOfResidence);

        fields = new ArrayList<String>();
        attachments = new ArrayList<String>();

        apply = findViewById(R.id.applySelectedServices);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference fieldAndAttachmentReference = FirebaseDatabase.getInstance().getReference("Services").child(currentServiceID).child("fieldsAndAttachments");
                fieldAndAttachmentReference.setValue(fieldsAndAttachments);
            }
        });

    }
    public void onFieldCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxFirstName:
                if (checked){
                    fieldsAndAttachments.setFirstName(true);
                }
                else{
                    fieldsAndAttachments.setFirstName(false);
                }
                break;

            case R.id.checkBoxLastName:
                if (checked){
                    fieldsAndAttachments.setLastName(true);
                }
                else{
                    fieldsAndAttachments.setLastName(false);
                }
                break;

            case R.id.checkBoxMaidenName:
                if (checked) {
                    fieldsAndAttachments.setMaidenName(true);
                }
                else{
                    fieldsAndAttachments.setMaidenName(false);
                }
                break;

            case R.id.checkBoxGender:
                if (checked) {
                    fieldsAndAttachments.setGender(true);
                }
                else{
                    fieldsAndAttachments.setGender(false);
                }
                break;
            case R.id.checkBoxNationality:
                if (checked) {
                    fieldsAndAttachments.setNationality(true);
                }
                else{
                    fieldsAndAttachments.setNationality(false);
                }
                break;

            case R.id.checkBoxPlaceOfBirth:
                if (checked) {
                    fieldsAndAttachments.setPOB(true);
                }
                else{
                    fieldsAndAttachments.setPOB(false);
                }
                break;

            case R.id.checkBoxExpiryDate:
                if (checked) {
                    fieldsAndAttachments.setExpiryDate(true);
                }
                else{
                    fieldsAndAttachments.setExpiryDate(false);
                }
                break;

            case R.id.checkBoxIssueDate:
                if (checked) {
                    fieldsAndAttachments.setIssueDate(true);
                }
                else{
                    fieldsAndAttachments.setIssueDate(false);
                }
                break;

            case R.id.checkBoxDateOfBirth:
                if (checked) {
                    fieldsAndAttachments.setDOB(true);
                }
                else{
                    fieldsAndAttachments.setDOB(false);
                }
                break;

            case R.id.checkBoxSignature:
                if (checked) {
                    fieldsAndAttachments.setSignature(true);
                }
                else{
                    fieldsAndAttachments.setSignature(false);
                }
                break;

            case R.id.checkBoxAddress:
                if (checked) {
                    fieldsAndAttachments.setAddress(true);
                }
                else{
                    fieldsAndAttachments.setAddress(false);
                }
                break;

            case R.id.checkBoxIssuingAuthority:
                if (checked) {
                    fieldsAndAttachments.setIssuingAuthority(true);
                }
                else{
                    fieldsAndAttachments.setIssuingAuthority(false);
                }
                break;

            case R.id.checkBoxHeight:
                if (checked) {
                    fieldsAndAttachments.setHeight(true);
                }
                else{
                    fieldsAndAttachments.setHeight(false);
                }
                break;

            case R.id.checkBoxWeight:
                if (checked) {
                    fieldsAndAttachments.setWeight(true);
                }
                else{
                    fieldsAndAttachments.setWeight(false);
                }
                break;

            case R.id.checkBoxBloodType:
                if (checked) {
                    fieldsAndAttachments.setBloodType(true);
                }
                else{
                    fieldsAndAttachments.setBloodType(false);
                }
                break;

            case R.id.checkBoxHairColour:
                if (checked) {
                    fieldsAndAttachments.setHairColour(true);
                }
                else{
                    fieldsAndAttachments.setHairColour(false);
                }
                break;

            case R.id.checkBoxEyeColour:
                if (checked) {
                    fieldsAndAttachments.setEyeColour(true);
                }
                else{
                    fieldsAndAttachments.setEyeColour(false);
                }
                break;

            case R.id.checkBoxClass:
                if (checked) {
                    fieldsAndAttachments.setClassID(true);
                }
                else{
                    fieldsAndAttachments.setClassID(false);
                }
                break;
        }
    }

    public void onAttachmentCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxProofOfStatus:
                if (checked) {
                    fieldsAndAttachments.setProofOfStatus(true);
                } else {
                    fieldsAndAttachments.setProofOfStatus(false);
                }
                break;

            case R.id.checkBoxBirthCertificate:
                if (checked) {
                    fieldsAndAttachments.setBirthCertificate(true);
                } else {
                    fieldsAndAttachments.setBirthCertificate(false);
                }
                break;

            case R.id.checkBoxDriversLicense:
                if (checked) {
                    fieldsAndAttachments.setDriversLicense(true);
                } else {
                    fieldsAndAttachments.setDriversLicense(false);
                }
                break;

            case R.id.checkBoxPhotoOfCustomer:
                if (checked) {
                    fieldsAndAttachments.setPhotoOfCustomer(true);
                } else {
                    fieldsAndAttachments.setPhotoOfCustomer(false);
                }
                break;

            case R.id.checkBoxSocialSecurity:
                if (checked) {
                    fieldsAndAttachments.setSIN(true);
                } else {
                    fieldsAndAttachments.setSIN(false);
                }
                break;

            case R.id.checkBoxProofOfResidence:
                if (checked) {
                    fieldsAndAttachments.setProofOfResidence(true);
                } else {
                    fieldsAndAttachments.setProofOfResidence(false);
                }
                break;
        }
    }
}
