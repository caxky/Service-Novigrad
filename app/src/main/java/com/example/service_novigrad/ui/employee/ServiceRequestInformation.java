package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.customer.CustomerFormRequest;
import com.example.service_novigrad.ui.services.FieldsAndAttachments;

public class ServiceRequestInformation extends AppCompatActivity {

    TextView firstName, lastName, maidenName, gender, nationality, POB, DOB, address, height, weight, hairColour, eyeColour;
    ImageView imagePOS, imageDL, imageBC, imagePhoto, imageSIN, imagePR;
    CustomerFormRequest customer;
    ServiceRequestItem req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_service_request_information);

        //Associating the textviews with the appropriate IDs
        firstName = findViewById(R.id.empFormReviewFirstName);
        lastName = findViewById(R.id.empFormReviewLastName);
        maidenName = findViewById(R.id.empFormReviewMaidenName);
        gender = findViewById(R.id.empFormReviewGender);
        nationality = findViewById(R.id.empFormReviewNationality);
        POB = findViewById(R.id.empFormReviewPOB);
        DOB = findViewById(R.id.empFormReviewDOB);
        address = findViewById(R.id.empFormReviewAddress);
        height = findViewById(R.id.empFormReviewHeight);
        weight = findViewById(R.id.empFormReviewWeight);
        hairColour = findViewById(R.id.empFormReviewHairColour);
        eyeColour = findViewById(R.id.empFormReviewEyeColour);

        //Associate the imageview with their appropriate imageviewIDS
        imagePOS = findViewById(R.id.empFormReviewImagePOS);
        imageBC = findViewById(R.id.empFormReviewImageBC);
        imageDL = findViewById(R.id.empFormReviewImageDL);
        imagePhoto = findViewById(R.id.empFormReviewImagePhoto);
        imageSIN = findViewById(R.id.empFormReviewImageSIN);
        imagePR = findViewById(R.id.textview2312);

        //Replace with real customerFormRequest object
        req = this.getIntent().getParcelableExtra("serviceRequest");

        //Initialize the form's value
        initializeFields(req.getForm().getBooleanFields());
        initializeImages();

    }
    public void initializeFields(FieldsAndAttachments list){
        if(list.isFirstName()){
            if(req.getForm().getFilledFields().containsKey("First Name"))
            {firstName.setText(req.getForm().getFilledFields().get("First Name"));}
        }
        else{

        }
        if(list.isLastName()){
            if(req.getForm().getFilledFields().containsKey("Last Name"))
            {lastName.setText(req.getForm().getFilledFields().get("Last Name"));}
        }
        else{

        }
        if(list.isMaidenName()){
            if(req.getForm().getFilledFields().containsKey("Maiden Name"))
            {maidenName.setText(req.getForm().getFilledFields().get("Maiden Name"));}
        }
        else{

        }
        if(list.isGender()){
            if(req.getForm().getFilledFields().containsKey("Gender"))
            {gender.setText(req.getForm().getFilledFields().get("Gender"));}
        }
        else{

        }
        if(list.isNationality()){
            if(req.getForm().getFilledFields().containsKey("Nationality"))
            {nationality.setText(req.getForm().getFilledFields().get("Nationality"));}
        }
        else{

        }
        if(list.isPOB()){
            if(req.getForm().getFilledFields().containsKey("Place of Birth"))
            {POB.setText(req.getForm().getFilledFields().get("Place of Birth"));}
        }
        else{

        }
        if(list.isDOB()){
            if(req.getForm().getFilledFields().containsKey("Date of Birth"))
            {DOB.setText(req.getForm().getFilledFields().get("Date of Birth"));}
        }
        else{

        }
        if(list.isAddress()){
            if(req.getForm().getFilledFields().containsKey("Address"))
            {address.setText(req.getForm().getFilledFields().get("Address"));}
        }
        else{

        }
        if(list.isHeight()){
            if(req.getForm().getFilledFields().containsKey("Height"))
            {height.setText(req.getForm().getFilledFields().get("Height"));}
        }
        else{

        }
        if(list.isWeight()){
            if(req.getForm().getFilledFields().containsKey("Weight"))
            {weight.setText(req.getForm().getFilledFields().get("Weight"));}
        }
        else{

        }
        if(list.isEyeColour()){
            if(req.getForm().getFilledFields().containsKey("Eye Colour"))
            {eyeColour.setText(req.getForm().getFilledFields().get("Eye Colour"));}
        }
        else{

        }
        if(list.isHairColour()){
            if(req.getForm().getFilledFields().containsKey("Hair Colour"))
            {hairColour.setText(req.getForm().getFilledFields().get("Hair Colour"));}
        }
        else{

        }
    }

    public void initializeImages(){

    }
}