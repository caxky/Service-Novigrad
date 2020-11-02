package com.example.service_novigrad.ui.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.admin.AdminServices;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServiceItemActivity extends AppCompatActivity {

    private CheckBox firstName, lastName, maidenName, gender, nationality, POB, expiryDate, issueDate, DOB, signature, address, issuingAuthority, height, weight, bloodType, hairColour, eyeColour, classID, proofOfStatus, birthCertificate, driversLicense, photoOfCustomer, SIN, proofOfResidence;
    private Button apply;


    private TextView textViewServiceName;
    private TextView textViewServiceType;

    private ServiceItem currentService;
    private FieldsAndAttachments currentFieldOfAttachment;

    private FieldsAndAttachments newFieldsAndAttachments = new FieldsAndAttachments();

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

        initializeCheckboxes();

        apply = findViewById(R.id.applySelectedServices);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //when apply is pressed update the service's field and attachment in teh server
                final DatabaseReference fieldAndAttachmentReference = FirebaseDatabase.getInstance().getReference("Services").child(currentServiceID).child("fieldsAndAttachments");
                fieldAndAttachmentReference.setValue(newFieldsAndAttachments);
            }
        });

    }
    public void initializeCheckboxes(){
        //initializes the checkboxes using preiviously filled fields
        DatabaseReference fieldAndAttachmentReference = FirebaseDatabase.getInstance().getReference("Services").child(currentServiceID);
        fieldAndAttachmentReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //check all the previous fields and add / apply it to a new FieldsAndAttachment so we can add to it
                currentService = snapshot.getValue(ServiceItem.class);
                currentFieldOfAttachment= currentService.getFieldsAndAttachments();
                if (currentFieldOfAttachment.isAddress()){
                    address.setChecked(true);
                    newFieldsAndAttachments.setAddress(true);
                }
                if(currentFieldOfAttachment.isBirthCertificate()){
                    birthCertificate.setChecked(true);
                    newFieldsAndAttachments.setBirthCertificate(true);
                }
                if (currentFieldOfAttachment.isBloodType()){
                    bloodType.setChecked(true);
                    newFieldsAndAttachments.setBloodType(true);
                }
                if (currentFieldOfAttachment.isClassID()){
                    classID.setChecked(true);
                    newFieldsAndAttachments.setClassID(true);
                }
                if (currentFieldOfAttachment.isDOB()){
                    DOB.setChecked(true);
                    newFieldsAndAttachments.setDOB(true);
                }
                if (currentFieldOfAttachment.isDriversLicense()){
                    driversLicense.setChecked(true);
                    newFieldsAndAttachments.setDriversLicense(true);
                }
                if (currentFieldOfAttachment.isExpiryDate()){
                    expiryDate.setChecked(true);
                    newFieldsAndAttachments.setExpiryDate(true);
                }
                if (currentFieldOfAttachment.isEyeColour()){
                    eyeColour.setChecked(true);
                    newFieldsAndAttachments.setEyeColour(true);
                }
                if (currentFieldOfAttachment.isFirstName()){
                    firstName.setChecked(true);
                    newFieldsAndAttachments.setFirstName(true);
                }
                if (currentFieldOfAttachment.isGender()){
                    gender.setChecked(true);
                    newFieldsAndAttachments.setGender(true);
                }
                if (currentFieldOfAttachment.isHairColour()){
                    hairColour.setChecked(true);
                    newFieldsAndAttachments.setHairColour(true);
                }
                if (currentFieldOfAttachment.isHeight()){
                    height.setChecked(true);
                    newFieldsAndAttachments.setHeight(true);
                }
                if (currentFieldOfAttachment.isIssueDate()){
                    issueDate.setChecked(true);
                    newFieldsAndAttachments.setIssueDate(true);
                }
                if (currentFieldOfAttachment.isIssuingAuthority()){
                    issuingAuthority.setChecked(true);
                    newFieldsAndAttachments.setIssuingAuthority(true);
                }
                if (currentFieldOfAttachment.isLastName()){
                    lastName.setChecked(true);
                    newFieldsAndAttachments.setLastName(true);
                }
                if (currentFieldOfAttachment.isMaidenName()){
                    maidenName.setChecked(true);
                    newFieldsAndAttachments.setMaidenName(true);
                }
                if (currentFieldOfAttachment.isNationality()){
                    nationality.setChecked(true);
                    newFieldsAndAttachments.setNationality(true);
                }
                if (currentFieldOfAttachment.isPhotoOfCustomer()){
                    photoOfCustomer.setChecked(true);
                    newFieldsAndAttachments.setPhotoOfCustomer(true);
                }
                if (currentFieldOfAttachment.isPOB()){
                    POB.setChecked(true);
                    newFieldsAndAttachments.setPOB(true);
                }
                if (currentFieldOfAttachment.isProofOfResidence()){
                    proofOfResidence.setChecked(true);
                    newFieldsAndAttachments.setProofOfResidence(true);
                }
                if (currentFieldOfAttachment.isProofOfStatus()){
                    proofOfStatus.setChecked(true);
                    newFieldsAndAttachments.setProofOfStatus(true);
                }
                if (currentFieldOfAttachment.isSignature()){
                    signature.setChecked(true);
                    newFieldsAndAttachments.setSignature(true);
                }
                if (currentFieldOfAttachment.isSIN()){
                    SIN.setChecked(true);
                    newFieldsAndAttachments.setSIN(true);
                }
                if (currentFieldOfAttachment.isWeight()){
                    weight.setChecked(true);
                    newFieldsAndAttachments.setWeight(true);
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        if (currentFieldOfAttachment.isAddress()){
//            address.setChecked(true);
//        }
//        if(currentFieldOfAttachment.isBirthCertificate()){
//            birthCertificate.setChecked(true);
//        }

    }

    public void onFieldCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxFirstName:
                if (checked){
                    newFieldsAndAttachments.setFirstName(true);
                }
                else{
                    newFieldsAndAttachments.setFirstName(false);
                }
                break;

            case R.id.checkBoxLastName:
                if (checked){
                    newFieldsAndAttachments.setLastName(true);
                }
                else{
                    newFieldsAndAttachments.setLastName(false);
                }
                break;

            case R.id.checkBoxMaidenName:
                if (checked) {
                    newFieldsAndAttachments.setMaidenName(true);
                }
                else{
                    newFieldsAndAttachments.setMaidenName(false);
                }
                break;

            case R.id.checkBoxGender:
                if (checked) {
                    newFieldsAndAttachments.setGender(true);
                }
                else{
                    newFieldsAndAttachments.setGender(false);
                }
                break;
            case R.id.checkBoxNationality:
                if (checked) {
                    newFieldsAndAttachments.setNationality(true);
                }
                else{
                    newFieldsAndAttachments.setNationality(false);
                }
                break;

            case R.id.checkBoxPlaceOfBirth:
                if (checked) {
                    newFieldsAndAttachments.setPOB(true);
                }
                else{
                    newFieldsAndAttachments.setPOB(false);
                }
                break;

            case R.id.checkBoxExpiryDate:
                if (checked) {
                    newFieldsAndAttachments.setExpiryDate(true);
                }
                else{
                    newFieldsAndAttachments.setExpiryDate(false);
                }
                break;

            case R.id.checkBoxIssueDate:
                if (checked) {
                    newFieldsAndAttachments.setIssueDate(true);
                }
                else{
                    newFieldsAndAttachments.setIssueDate(false);
                }
                break;

            case R.id.checkBoxDateOfBirth:
                if (checked) {
                    newFieldsAndAttachments.setDOB(true);
                }
                else{
                    newFieldsAndAttachments.setDOB(false);
                }
                break;

            case R.id.checkBoxSignature:
                if (checked) {
                    newFieldsAndAttachments.setSignature(true);
                }
                else{
                    newFieldsAndAttachments.setSignature(false);
                }
                break;

            case R.id.checkBoxAddress:
                if (checked) {
                    newFieldsAndAttachments.setAddress(true);
                }
                else{
                    newFieldsAndAttachments.setAddress(false);
                }
                break;

            case R.id.checkBoxIssuingAuthority:
                if (checked) {
                    newFieldsAndAttachments.setIssuingAuthority(true);
                }
                else{
                    newFieldsAndAttachments.setIssuingAuthority(false);
                }
                break;

            case R.id.checkBoxHeight:
                if (checked) {
                    newFieldsAndAttachments.setHeight(true);
                }
                else{
                    newFieldsAndAttachments.setHeight(false);
                }
                break;

            case R.id.checkBoxWeight:
                if (checked) {
                    newFieldsAndAttachments.setWeight(true);
                }
                else{
                    newFieldsAndAttachments.setWeight(false);
                }
                break;

            case R.id.checkBoxBloodType:
                if (checked) {
                    newFieldsAndAttachments.setBloodType(true);
                }
                else{
                    newFieldsAndAttachments.setBloodType(false);
                }
                break;

            case R.id.checkBoxHairColour:
                if (checked) {
                    newFieldsAndAttachments.setHairColour(true);
                }
                else{
                    newFieldsAndAttachments.setHairColour(false);
                }
                break;

            case R.id.checkBoxEyeColour:
                if (checked) {
                    newFieldsAndAttachments.setEyeColour(true);
                }
                else{
                    newFieldsAndAttachments.setEyeColour(false);
                }
                break;

            case R.id.checkBoxClass:
                if (checked) {
                    newFieldsAndAttachments.setClassID(true);
                }
                else{
                    newFieldsAndAttachments.setClassID(false);
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
                    newFieldsAndAttachments.setProofOfStatus(true);
                } else {
                    newFieldsAndAttachments.setProofOfStatus(false);
                }
                break;

            case R.id.checkBoxBirthCertificate:
                if (checked) {
                    newFieldsAndAttachments.setBirthCertificate(true);
                } else {
                    newFieldsAndAttachments.setBirthCertificate(false);
                }
                break;

            case R.id.checkBoxDriversLicense:
                if (checked) {
                    newFieldsAndAttachments.setDriversLicense(true);
                } else {
                    newFieldsAndAttachments.setDriversLicense(false);
                }
                break;

            case R.id.checkBoxPhotoOfCustomer:
                if (checked) {
                    newFieldsAndAttachments.setPhotoOfCustomer(true);
                } else {
                    newFieldsAndAttachments.setPhotoOfCustomer(false);
                }
                break;

            case R.id.checkBoxSocialSecurity:
                if (checked) {
                    newFieldsAndAttachments.setSIN(true);
                } else {
                    newFieldsAndAttachments.setSIN(false);
                }
                break;

            case R.id.checkBoxProofOfResidence:
                if (checked) {
                    newFieldsAndAttachments.setProofOfResidence(true);
                } else {
                    newFieldsAndAttachments.setProofOfResidence(false);
                }
                break;
        }
    }


}
