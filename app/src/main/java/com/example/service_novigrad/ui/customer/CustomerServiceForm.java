package com.example.service_novigrad.ui.customer;

import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.FieldsAndAttachments;

public class CustomerServiceForm extends AppCompatActivity {

    private TextView firstName, lastName, maidenName, gender, nationality, DOB, POB, address, height, weight, bloodType, hairColour, eyeColour;
    private EditText editTextFirstName, editTextLastName, editTextMaidenName, editTextNationality,editTextPOB, editTextDOB, editTextAddress, editTextHeight, editTextWeight, editTextHairColour, editTextEyeColour;
    private RadioGroup bloodTypeRG, genderRG;
    private RadioButton male,female,other, aplus, bplus, oplus, oneg, abneg, abplus, aneg, bneg;
    private Button msubmit;


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

        msubmit = findViewById(R.id.customerFormSubmit);
        msubmit.setEnabled(false);
        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finalize here
            }
        });

        test = new FieldsAndAttachments("Health Card Service");
        test.setGender(true);
        initializeForm(test);

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
}
