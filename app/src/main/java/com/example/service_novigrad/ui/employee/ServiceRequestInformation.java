package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.customer.CustomerFormRequest;
import com.example.service_novigrad.ui.services.FieldsAndAttachments;

import java.util.HashMap;

public class ServiceRequestInformation extends AppCompatActivity {

    TextView firstName, lastName, maidenName, gender, nationality, POB, DOB, address, height, weight, hairColour, eyeColour;
    ImageView imagePOS, imageDL, imageBC, imagePhoto, imageSIN, imagePR;
    CustomerFormRequest customer;

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

        //Replace with real customerFormRequest object
        FieldsAndAttachments fields = new FieldsAndAttachments("Photo ID Service");

        //Initialize the form's value
        initializeFields(fields);
        initializeImages();

    }
    public void initializeFields(FieldsAndAttachments list){
        if(list.isFirstName()){

        }
        else{

        }
        if(list.isLastName()){

        }
        else{

        }
        if(list.isMaidenName()){

        }
        else{

        }
        if(list.isGender()){

        }
        else{

        }
        if(list.isNationality()){

        }
        else{

        }
        if(list.isPOB()){

        }
        else{

        }
        if(list.isDOB()){

        }
        else{

        }
        if(list.isAddress()){

        }
        else{

        }
        if(list.isHeight()){

        }
        else{

        }
        if(list.isWeight()){

        }
        else{

        }
        if(list.isEyeColour()){

        }
        else{

        }
        if(list.isHairColour()){

        }
        else{

        }
    }

    public void initializeImages(){

    }
}