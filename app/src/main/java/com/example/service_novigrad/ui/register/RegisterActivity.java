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
import com.example.service_novigrad.ui.login.LoginViewModel;
import com.example.service_novigrad.ui.login.LoginViewModelFactory;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity{



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText firstNameEditText = findViewById(R.id.firstname);
        final EditText lastNameEditText = findViewById(R.id.lastname);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final EditText branchIDEditText = findViewById(R.id.branchid);
//        final RadioGroup accountTypeRadioGroup =  findViewById(R.id.accountType);
        final RadioButton employeeAccountTypeRadioButton = findViewById(R.id.employee);
        final RadioButton customerAccountTypeRadioButton = findViewById(R.id.customer);
        final Button submitButton = findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() { //this submits the information the user inputs and stores it in the firebase database
            public void onClick(View view) {
                String firstName, lastName, username, password, branchID;
                firstName = firstNameEditText.getText().toString();
                lastName = lastNameEditText.getText().toString();
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
                branchID = branchIDEditText.getText().toString();

//                int checkedID = accountTypeRadioGroup.getCheckedRadioButtonId();// finds the item id that is checked by the radio group
//                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedID);//using the id found above to find the exact radio button
//                String checkedAccountType = checkedRadioButton.getText().toString();//find
                FirebaseDatabase database = FirebaseDatabase.getInstance();//creates an instance so you can read and write to it

                if (employeeAccountTypeRadioButton.isChecked()){

                    //Create references that take the form similar to a json file this is a template basically to show the format and how stuff will be shown
                    DatabaseReference newEmployeeUsername = database.getReference("Employee Accounts/"+ username);
                    DatabaseReference newEmployeeFirstName = database.getReference("Employee Accounts/"+ username+"/first name");
                    DatabaseReference newEmployeeLastName = database.getReference("Employee Accounts/"+ username+"/last name");
                    DatabaseReference newEmployeePassword = database.getReference("Employee Accounts/"+ username+"/password");
                    DatabaseReference newEmployeeBranchID = database.getReference("Employee Accounts/"+ username+"/branch id");

                    //Set the values into the "template"(references) we created
                    newEmployeeUsername.setValue(username);
                    newEmployeeFirstName.setValue(firstName);
                    newEmployeeLastName.setValue(lastName);
                    newEmployeePassword.setValue(password);
                    newEmployeeBranchID.setValue(branchID);

                }else if (customerAccountTypeRadioButton.isChecked()){
                    DatabaseReference newCustomerAccount = database.getReference("Customer Accounts/");
                    DatabaseReference newCustomerUsername = database.getReference("Customer Accounts/"+ username);
                    DatabaseReference newCustomerFirstName = database.getReference("Customer Accounts/"+username +"/first name");
                    DatabaseReference newCustomerLastName = database.getReference("Customer Accounts/"+ username +"/last name");
                    DatabaseReference newCustomerPassword = database.getReference("Customer Accounts/"+ username +"/password");


                    newCustomerUsername.setValue(username);
                    newCustomerFirstName.setValue(firstName);
                    newCustomerLastName.setValue(lastName);
                    newCustomerPassword.setValue(password);
//                    CustomerAccount newCustomer = new CustomerAccount(username,password,firstName,lastName);


                }
                finish();



            }
        });


    }


}

