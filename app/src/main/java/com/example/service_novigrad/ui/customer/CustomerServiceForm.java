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
import com.example.service_novigrad.ui.welcome.WelcomeActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CustomerServiceForm extends AppCompatActivity implements View.OnClickListener{

    private static final int PICK_FILE_REQUEST = 234;
    private BranchServiceItem branchItem;
    private TextView firstName, lastName, maidenName, gender, nationality, DOB, POB, address, height, weight, bloodType, hairColour, eyeColour;
    private EditText editTextFirstName, editTextLastName, editTextMaidenName, editTextNationality,editTextPOB, editTextDOB, editTextAddress, editTextHeight, editTextWeight, editTextHairColour, editTextEyeColour;
    private RadioGroup bloodTypeRG, genderRG;
    private RadioButton male,female,other, aplus, bplus, oplus, oneg, abneg, abplus, aneg, bneg;
    private Button msubmit, buttonPOS, buttonBC, buttonDL, buttonPhoto, buttonSIN, buttonPR;

    //Attachments
    private Uri filePathPOS, filePathBC, filePathDL, filePathPhoto, filePathSIN, filePathPR;
    private String filePath;
    private StorageReference storageReference;

    //Fields and attachments
    private FieldsAndAttachments test;

    //final storage
    HashMap<String, String> fields;
    HashMap<String, Uri> attachments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_branch_service_form);
        test = this.getIntent().getParcelableExtra("fieldsAndAttach");
        branchItem = this.getIntent().getParcelableExtra("branchItem");

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
                fields = new HashMap<>();
                attachments = new HashMap<>();
                finalizeFields();
                finalizeAttachments();
                CustomerFormRequest req = new CustomerFormRequest(test,fields,attachments,branchItem.getOriginalServiceKey());
                uploadFile();

                //go back
                Intent intent = new Intent(getBaseContext(), WelcomeActivity.class);
                startActivity(intent);
            }
        });

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


        initializeForm(test);

        //Storage
        storageReference = FirebaseStorage.getInstance().getReference(branchItem.getBranchServiceName());

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
        if(!list.isProofOfStatus()){
            buttonPOS.setEnabled(false);
        }
        if(!list.isDriversLicense()){
            buttonDL.setEnabled(false);
        }
        if(!list.isBirthCertificate()){
            buttonBC.setEnabled(false);
        }
        if(!list.isPhotoOfCustomer()){
            buttonPhoto.setEnabled(false);
        }
        if(!list.isProofOfResidence()){
            buttonPR.setEnabled(false);
        }
        if(!list.isSIN()){
            buttonSIN.setEnabled(false);
        }
    }

    private void showFileChooser(String text){
        filePath = text;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select file"), PICK_FILE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            switch(filePath){
                case "POS":
                    filePathPOS = data.getData();
                    Toast.makeText(getApplicationContext(),"File Attached", Toast.LENGTH_LONG).show();
                    break;
                case "DL":
                    filePathDL = data.getData();
                    Toast.makeText(getApplicationContext(),"File Attached", Toast.LENGTH_LONG).show();
                    break;
                case "BC":
                    filePathBC = data.getData();
                    Toast.makeText(getApplicationContext(),"File Attached", Toast.LENGTH_LONG).show();
                    break;
                case "Photo":
                    filePathPhoto = data.getData();
                    Toast.makeText(getApplicationContext(),"File Attached", Toast.LENGTH_LONG).show();
                    break;
                case "PR":
                    filePathPR = data.getData();
                    Toast.makeText(getApplicationContext(),"File Attached", Toast.LENGTH_LONG).show();
                    break;
                case "SIN":
                    filePathSIN = data.getData();
                    Toast.makeText(getApplicationContext(),"File Attached", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    private void uploadFile(){
        if(filePathPOS != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference refPOS = storageReference.child(fields.get("First Name")+"/filePOS.jpg");
            refPOS.putFile(filePathPOS)
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
        }
        if(filePathDL != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference refDL = storageReference.child(fields.get("First Name")+"/fileDL.jpg");
            refDL.putFile(filePathDL)
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
        }
        if(filePathBC != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference refBC = storageReference.child(fields.get("First Name")+"/fileBC.jpg");
            refBC.putFile(filePathBC)
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
        }
        if(filePathPhoto != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference refPhoto = storageReference.child(fields.get("First Name")+"/filePhoto.jpg");
            refPhoto.putFile(filePathPhoto)
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
        }
        if(filePathSIN != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference refSIN = storageReference.child(fields.get("First Name")+"/fileSIN.jpg");
            refSIN.putFile(filePathSIN)
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
        }
        if(filePathPR != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference refPR = storageReference.child(fields.get("First Name")+"/filePR.jpg");
            refPR.putFile(filePathPR)
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
        }
    }

    @Override
    public void onClick(View v) {
        if (buttonPOS.equals(v)) {
            showFileChooser("POS");
        }
        else if (buttonDL.equals(v)) {
            showFileChooser("DL");
        }
        else if (buttonBC.equals(v)) {
            showFileChooser("BC");
        }
        else if (buttonPR.equals(v)) {
            showFileChooser("PR");
        }
        else if (buttonPhoto.equals(v)) {
            showFileChooser("Photo");
        }
        else if (buttonSIN.equals(v)) {
            showFileChooser("SIN");
        }
    }

    public void finalizeFields(){
        if(test.isFirstName()){
            fields.put("First Name", editTextFirstName.getText().toString().trim());
        }
        if(test.isLastName()){
            fields.put("Last Name", editTextLastName.getText().toString().trim());
        }
        if(test.isMaidenName()){
            fields.put("Maiden Name", editTextMaidenName.getText().toString().trim());
        }
        if(test.isNationality()){
            fields.put("Nationality", editTextNationality.getText().toString().trim());
        }
        if(test.isDOB()){
            fields.put("Date of Birth", editTextDOB.getText().toString().trim());
        }
        if(test.isPOB()){
            fields.put("Place of Birth", editTextPOB.getText().toString().trim());
        }
        if(test.isAddress()){
            fields.put("Address", editTextAddress.getText().toString().trim());
        }
        if(test.isWeight()){
            fields.put("Weight", editTextWeight.getText().toString().trim());
        }
        if(test.isHeight()){
            fields.put("Height", editTextHeight.getText().toString().trim());
        }
        if(test.isHairColour()){
            fields.put("Hair Colour", editTextHairColour.getText().toString().trim());
        }
        if(test.isEyeColour()){
            fields.put("Eye Colour", editTextFirstName.getText().toString().trim());
        }
    }
    public void finalizeAttachments(){
        if(test.isProofOfStatus()){
            attachments.put("Proof of Status", filePathPOS);
        }
        if(test.isDriversLicense()){
            attachments.put("Drivers License", filePathDL);
        }
        if(test.isBirthCertificate()){
            attachments.put("Birth Certificate", filePathBC);
        }
        if(test.isPhotoOfCustomer()){
            attachments.put("Photo of Customer", filePathPhoto);
        }
        if(test.isSIN()){
            attachments.put("SIN", filePathSIN);
        }
        if(test.isProofOfResidence()){
            attachments.put("Proof of Residence", filePathPR);
        }
    }
}


