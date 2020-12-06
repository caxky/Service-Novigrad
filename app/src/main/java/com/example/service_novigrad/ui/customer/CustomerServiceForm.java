package com.example.service_novigrad.ui.customer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.FieldsAndAttachments;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class CustomerServiceForm extends AppCompatActivity implements View.OnClickListener{

    private static final int PICK_FILE_REQUEST = 234;

    private TextView firstName, lastName, maidenName, gender, nationality, DOB, POB, address, height, weight, bloodType, hairColour, eyeColour;
    private EditText editTextFirstName, editTextLastName, editTextMaidenName, editTextNationality,editTextPOB, editTextDOB, editTextAddress, editTextHeight, editTextWeight, editTextHairColour, editTextEyeColour;
    private RadioGroup bloodTypeRG, genderRG;
    private RadioButton male,female,other, aplus, bplus, oplus, oneg, abneg, abplus, aneg, bneg;
    private Button msubmit, buttonPOS, buttonBC, buttonDL, buttonPhoto, buttonSIN, buttonPR;

    //Attachments
    private Uri filePath;
    private StorageReference storageReference;

    //Fields and attachments
    private FieldsAndAttachments test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_branch_service_form);

        bloodTypeRG = findViewById(R.id.bloodTypeRadioGroup);
        genderRG = findViewById(R.id.genderRadioGroup);
        male = findViewById(R.id.maleRadioButton);
        female = findViewById(R.id.femaleRadioButton);
        other = findViewById(R.id.otherRadioButton);
        aplus = findViewById(R.id.radioButtonAplus);
        bplus = findViewById(R.id.radioButtonBplus);
        oplus = findViewById(R.id.radioButtonOplus);
        oneg = findViewById(R.id.radioButtonOneg);
        abneg = findViewById(R.id.radioButtonABneg);
        abplus = findViewById(R.id.radioButtonABplus);
        aneg = findViewById(R.id.radioButtonAneg);
        bneg = findViewById(R.id.radioButtonBneg);


        firstName = findViewById(R.id.textViewFirstName);
        lastName = findViewById(R.id.textViewLastName);
        maidenName = findViewById(R.id.textViewMaidenName);
        gender = findViewById(R.id.textViewGender);
        nationality = findViewById(R.id.textViewNationality);
        DOB = findViewById(R.id.textViewDOB);
        POB = findViewById(R.id.textViewPOB);
        address = findViewById(R.id.textViewAddress);
        height = findViewById(R.id.textViewHeight);
        weight = findViewById(R.id.textViewWeight);
        bloodType = findViewById(R.id.textViewBloodType);
        hairColour = findViewById(R.id.textViewHairColour);
        eyeColour = findViewById(R.id.textViewEyeColour);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextMaidenName = findViewById(R.id.editTextMaidenName);
        editTextNationality = findViewById(R.id.editTextNationality);
        editTextPOB = findViewById(R.id.editTextPOB);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHairColour = findViewById(R.id.editTextHairColour);
        editTextEyeColour= findViewById(R.id.editTextEyeColour);

        msubmit = (Button)findViewById(R.id.customerFormSubmit);
        msubmit.setEnabled(false);
        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finalize here


                //The following function uploads the file onto the database.
                //uploadFile();
            }
        });

        test = new FieldsAndAttachments("Health Card Service");
        initializeForm(test);

        //Attachments
        buttonBC = (Button) findViewById(R.id.buttonBC);
        buttonDL = (Button)findViewById(R.id.buttonDL);
        buttonPOS = (Button)findViewById(R.id.buttonPOS);
        buttonPhoto = (Button)findViewById(R.id.buttonPhoto);
        buttonSIN = (Button)findViewById(R.id.buttonSIN);
        buttonPR = (Button)findViewById(R.id.buttonPR);

        buttonBC.setOnClickListener(this);
        buttonDL.setOnClickListener(this);
        buttonPOS.setOnClickListener(this);
        buttonPhoto.setOnClickListener(this);
        buttonSIN.setOnClickListener(this);
        buttonPR.setOnClickListener(this);

        //Storage
        storageReference = FirebaseStorage.getInstance().getReference();

    }
    private TextWatcher textwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String inputfirstname = editTextFirstName.getText().toString().trim();
            String inputlastname = editTextLastName.getText().toString().trim();
            String inputmaidenname = editTextMaidenName.getText().toString().trim();
            String inputnationality = editTextNationality.getText().toString().trim();
            String inputpob = editTextPOB.getText().toString().trim();
            String inputdob = editTextDOB.getText().toString().trim();
            String inputaddress = editTextAddress.getText().toString().trim();
            String inputheight = editTextHeight.getText().toString().trim();
            String inputweight = editTextWeight.getText().toString().trim();
            String inputhaircolour = editTextHairColour.getText().toString().trim();
            String inputeyecolour = editTextEyeColour.getText().toString().trim();

            if((test.isFirstName() == !inputfirstname.isEmpty())
            && (test.isLastName() == !inputlastname.isEmpty())
            && (test.isMaidenName() == !inputmaidenname.isEmpty())
            && (test.isNationality() == !inputnationality.isEmpty())
            && (test.isPOB() == !inputpob.isEmpty())
            && (test.isDOB() == !inputdob.isEmpty())
            && (test.isAddress() == !inputaddress.isEmpty())
            && (test.isHeight() == !inputheight.isEmpty())
            && (test.isWeight() == !inputweight.isEmpty())
            && (test.isHairColour() == !inputhaircolour.isEmpty())
            && (test.isEyeColour() == !inputeyecolour.isEmpty()))
            {msubmit.setEnabled(true);}
        }

        @Override
        public void afterTextChanged(Editable s) {
            String inputfirstname = editTextFirstName.getText().toString().trim();
            String inputlastname = editTextLastName.getText().toString().trim();
            String inputmaidenname = editTextMaidenName.getText().toString().trim();
            String inputnationality = editTextNationality.getText().toString().trim();
            String inputpob = editTextPOB.getText().toString().trim();
            String inputdob = editTextDOB.getText().toString().trim();
            String inputaddress = editTextAddress.getText().toString().trim();
            String inputheight = editTextHeight.getText().toString().trim();
            String inputweight = editTextWeight.getText().toString().trim();
            String inputhaircolour = editTextHairColour.getText().toString().trim();
            String inputeyecolour = editTextEyeColour.getText().toString().trim();

            if(test.isFirstName() && inputfirstname.isEmpty()){
                editTextFirstName.setError("Can't be empty");
            }
            else if(test.isFirstName() && inputfirstname.matches(".*\\d.*")){
                editTextFirstName.setError("Can't have numbers");
            }
            if(test.isLastName() && inputlastname.isEmpty()){
                editTextLastName.setError("Can't be empty");
            }
            else if(test.isLastName() && inputlastname.matches(".*\\d.*")){
                editTextLastName.setError("Can't have numbers");
            }
            if(test.isMaidenName() && inputmaidenname.isEmpty()){
                editTextMaidenName.setError("Can't be empty");
            }
            else if(test.isMaidenName() && inputmaidenname.matches(".*\\d.*")){
                editTextMaidenName.setError("Can't have numbers");
            }
            if(test.isNationality() && inputnationality.isEmpty()){
                editTextNationality.setError("Can't be empty");
            }
            else if(test.isNationality() && inputnationality.matches(".*\\d.*")){
                editTextNationality.setError("Can't have numbers");
            }
            if(test.isPOB() && inputpob.isEmpty()){
                editTextPOB.setError("Can't be empty");
            }
            else if(test.isPOB() && inputpob.matches(".*\\d.*")){
                editTextPOB.setError("Can't have numbers");
            }
            if(test.isDOB() && inputdob.isEmpty()){
                editTextDOB.setError("Can't be empty");
            }
            else if(test.isDOB() && !inputdob.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){
                editTextDOB.setError("Format: dd/mm/yyyy");
            }
            if(test.isAddress() && inputaddress.isEmpty()){
                editTextAddress.setError("Can't be empty");
            }

        }
    };
    private void initializeForm(FieldsAndAttachments list){
        if(!list.isFirstName()){
            editTextFirstName.setText("");
            editTextFirstName.setHint("N/A");
            editTextFirstName.setEnabled(false);
        }
        else{
            editTextFirstName.setText("");
            editTextFirstName.setHint("Input Here");
            editTextFirstName.addTextChangedListener(textwatcher);
        }
        if(!list.isLastName()){
            editTextLastName.setText("");
            editTextLastName.setHint("N/A");
            editTextLastName.setEnabled(false);
        }
        else{
            editTextLastName.setText("");
            editTextLastName.setHint("Input Here");
            editTextLastName.addTextChangedListener(textwatcher);
        }
        if(!list.isMaidenName()){
            editTextMaidenName.setText("");
            editTextMaidenName.setHint("N/A");
            editTextMaidenName.setEnabled(false);
        }
        else{
            editTextMaidenName.setText("");
            editTextMaidenName.setHint("Input Here");
            editTextMaidenName.addTextChangedListener(textwatcher);
        }
        if(!list.isNationality()){
            editTextNationality.setText("");
            editTextNationality.setHint("N/A");
            editTextNationality.setEnabled(false);
        }
        else{
            editTextNationality.setText("");
            editTextNationality.setHint("Input Here");
            editTextNationality.addTextChangedListener(textwatcher);
        }
        if(!list.isDOB()){
            editTextDOB.setText("");
            editTextDOB.setHint("N/A");
            editTextDOB.setEnabled(false);
        }
        else{
            editTextDOB.setText("");
            editTextDOB.setHint("Input Here");
            editTextDOB.addTextChangedListener(textwatcher);
        }
        if(!list.isPOB()){
            editTextPOB.setText("");
            editTextPOB.setHint("N/A");
            editTextPOB.setEnabled(false);
        }
        else{
            editTextPOB.setText("");
            editTextPOB.setHint("Input Here");
            editTextPOB.addTextChangedListener(textwatcher);
        }
        if(!list.isAddress()){
            editTextAddress.setText("");
            editTextAddress.setHint("N/A");
            editTextAddress.setEnabled(false);
        }
        else{
            editTextAddress.setText("");
            editTextAddress.setHint("Input Here");
            editTextAddress.addTextChangedListener(textwatcher);
        }
        if(!list.isHeight()){
            editTextHeight.setText("");
            editTextHeight.setHint("N/A");
            editTextHeight.setEnabled(false);
        }
        else{
            editTextHeight.setText("");
            editTextHeight.setHint("Input Here");
            editTextHeight.addTextChangedListener(textwatcher);
        }
        if(!list.isWeight()){
            editTextWeight.setText("");
            editTextWeight.setHint("N/A");
            editTextWeight.setEnabled(false);
        }
        else{
            editTextWeight.setText("");
            editTextWeight.setHint("Input Here");
            editTextWeight.addTextChangedListener(textwatcher);
        }
        if(!list.isHairColour()){
            editTextHairColour.setText("");
            editTextHairColour.setHint("N/A");
            editTextHairColour.setEnabled(false);
        }
        else{
            editTextHairColour.setText("");
            editTextHairColour.setHint("Input Here");
            editTextHairColour.addTextChangedListener(textwatcher);
        }
        if(!list.isEyeColour()){
            editTextEyeColour.setText("");
            editTextEyeColour.setHint("N/A");
            editTextEyeColour.setEnabled(false);
        }else{
            editTextEyeColour.setText("");
            editTextEyeColour.setHint("Input Here");
            editTextEyeColour.addTextChangedListener(textwatcher);
        }
        if(!list.isBloodType()){
            bloodTypeRG.setEnabled(false);
            aplus.setEnabled(false);
            aneg.setEnabled(false);
            bplus.setEnabled(false);
            bneg.setEnabled(false);
            oplus.setEnabled(false);
            oneg.setEnabled(false);
            abplus.setEnabled(false);
            abneg.setEnabled(false);
            abneg.setEnabled(false);
        }
        else{

        }
        if(!list.isGender()){
            genderRG.setEnabled(false);
            male.setEnabled(false);
            female.setEnabled(false);
            other.setEnabled(false);
        }
        else{

        }
    }

    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select file"), PICK_FILE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
        }
    }

    private void uploadFile(){
        if(filePath != null) {

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            StorageReference riversRef = storageReference.child("images/file.jpg");
            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"File Uploaded", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),exception.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });
        } else{
            //display an error toast
        }
    }

    @Override
    public void onClick(View v) {
        if (buttonPOS.equals(v)) {
            showFileChooser();
        }
        else if (buttonDL.equals(v)) {
            showFileChooser();
        }
        else if (buttonBC.equals(v)) {
            showFileChooser();
        }
        else if (buttonPR.equals(v)) {
            showFileChooser();
        }
        else if (buttonPhoto.equals(v)) {
            showFileChooser();
        }
        else if (buttonSIN.equals(v)) {
            showFileChooser();
        }
    }
}
