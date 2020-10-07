package com.example.service_novigrad.ui.register;
import com.example.service_novigrad.*;
import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.service_novigrad.R;
import com.example.service_novigrad.accounts.CustomerAccount;
import com.example.service_novigrad.accounts.EmployeeAccount;
import com.example.service_novigrad.ui.login.LoginViewModel;
import com.example.service_novigrad.ui.login.LoginViewModelFactory;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity{
    //Declaring Variables
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextBranchID;
    private Button buttonSubmit;
    private RadioButton employeeAccountTypeRadioButton;
    private RadioButton customerAccountTypeRadioButton;
    private RadioGroup radioGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Assigning Variables
        editTextFirstName = findViewById(R.id.firstname);
        editTextLastName = findViewById(R.id.lastname);
        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        editTextBranchID = findViewById(R.id.branchid);
//        final RadioGroup accountTypeRadioGroup =  findViewById(R.id.accountType);
        employeeAccountTypeRadioButton = findViewById(R.id.employee);
        customerAccountTypeRadioButton = findViewById(R.id.customer);
        buttonSubmit = findViewById(R.id.submit);
        radioGroup = (RadioGroup) findViewById(R.id.accountType);

        //Assigning TextChangedListeners to the above variables.
        editTextUsername.addTextChangedListener(registerTextWatcher);
        editTextPassword.addTextChangedListener(registerTextWatcher);
        editTextFirstName.addTextChangedListener(registerTextWatcher);
        editTextLastName.addTextChangedListener(registerTextWatcher);
        editTextBranchID.addTextChangedListener(registerTextWatcher);
        employeeAccountTypeRadioButton.addTextChangedListener(registerTextWatcher);
        customerAccountTypeRadioButton.addTextChangedListener(registerTextWatcher);



        buttonSubmit.setOnClickListener(new View.OnClickListener() { //this submits the information the user inputs and stores it in the firebase database
            public void onClick(View view) {

                //initialize and fill in the values of the data we found from the users
                String firstName, lastName, username, password;
                int branchID;

                firstName = editTextFirstName.getText().toString();
                lastName = editTextLastName.getText().toString();
                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                branchID = Integer.parseInt(editTextBranchID.getText().toString());



                FirebaseDatabase database = FirebaseDatabase.getInstance(); //creates an instance so you can read and write to it



                if (employeeAccountTypeRadioButton.isChecked()){

                    branchID = Integer.parseInt(editTextBranchID.getText().toString());
                    //Create references that take the form similar to a json file this is a template basically to show the format and how stuff will be shown
                    DatabaseReference newEmployeeAccount = database.getReference("Employee Accounts/");


                    EmployeeAccount newEmployee = new EmployeeAccount(username, password, firstName, lastName, branchID);
                    newEmployeeAccount.push().setValue(newEmployee);


                }else if (customerAccountTypeRadioButton.isChecked()){
                    DatabaseReference newCustomerAccount = database.getReference("Customer Accounts/");


                    CustomerAccount newCustomer = new CustomerAccount(username,password,firstName,lastName);

                    newCustomerAccount.push().setValue(newCustomer);

                }

                finish();

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                editTextUsername.setEnabled(true);
                editTextPassword.setEnabled(true);
                editTextFirstName.setEnabled(true);
                editTextLastName.setEnabled(true);
                editTextBranchID.setEnabled(employeeAccountTypeRadioButton.isChecked());
            }
        });
    }
    /*
    TextWatcher, it's function is to look at the field in the register layout and only unlock the register button
    after all the appropriate fields are inputted, it also serves as the function to set the error if the text fields inputted are
    not according to format.
    */
    private TextWatcher registerTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //Declaring and assigning the input from the user
            String usernameInput = editTextUsername.getText().toString().trim();
            String passwordInput = editTextPassword.getText().toString().trim();
            String firstNameInput = editTextFirstName.getText().toString().trim();
            String lastNameInput = editTextLastName.getText().toString().trim();
            String BranchIDInput = editTextBranchID.getText().toString().trim();

            //Enables the button if true
            if(employeeAccountTypeRadioButton.isChecked()){
                buttonSubmit.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() && !firstNameInput.isEmpty() && !lastNameInput.isEmpty() && BranchIDInput.length()==3 && passwordInput.length() > 5);
            }
            else if(customerAccountTypeRadioButton.isChecked()){
                buttonSubmit.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() && !firstNameInput.isEmpty() && !lastNameInput.isEmpty() && passwordInput.length() > 5);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            /*
            Sets an error in the text fields if they haven't been appropriatly addressed.
             */
            if(editTextFirstName.getText().toString().length() <= 0){
                editTextFirstName.setError("First name can't be empty.");
            }
            else{
                editTextFirstName.setError(null);
            }

            if(editTextLastName.getText().toString().length() <= 0){
                editTextLastName.setError("Last name can't be empty.");
            }
            else{
                editTextLastName.setError(null);
            }

            if(editTextUsername.getText().toString().length() <= 0){
                editTextUsername.setError("Username can't be empty.");
            }
            else{
                editTextUsername.setError(null);
            }

            if(editTextPassword.getText().toString().length() <= 5){
                editTextPassword.setError("Password needs to be more than five characters.");
            }
            else{
                editTextPassword.setError(null);
            }

            if(editTextBranchID.getText().toString().length() > 999 || editTextBranchID.getText().toString().length() < 100 && !customerAccountTypeRadioButton.isChecked()){
                editTextBranchID.setError("BranchID needs to be exactly 3 digits.");
            }
            else{
                editTextBranchID.setError(null);
            }
        }
    };
}

