package com.example.service_novigrad.ui.welcome;
import com.example.service_novigrad.accounts.Account;
import com.example.service_novigrad.accounts.CustomerAccount;
import com.example.service_novigrad.accounts.EmployeeAccount;
import com.example.service_novigrad.ui.login.*;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.service_novigrad.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    DataSnapshot parentDataSnapshot, userDataSnapShot;
    CustomerAccount currentCustomerAccount;
    EmployeeAccount currentEmployeeAccount;



    boolean isCustomer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        final String userName = LoginActivity.userName;
        final String password = LoginActivity.password;
        final TextView usernameTitleTextView = findViewById(R.id.username);
        final TextView accountIDTextView = findViewById(R.id.accountID);


        DatabaseReference accountsReference = FirebaseDatabase.getInstance().getReference().child("Customer Accounts");
        final ArrayList<CustomerAccount> customersUsers = new ArrayList<CustomerAccount>();
        accountsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> children = snapshot.getChildren();
                for (DataSnapshot child: children){
                    CustomerAccount temp = child.getValue(CustomerAccount.class);
                    if(temp.getUsername().equals(userName)&&temp.getPassword().equals(password)){
                        usernameTitleTextView.setText(userName);
                        accountIDTextView.setText(Long.toString(temp.getAccountID()));
                        break;
                    }

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

//        if (isCustomer){
//            currentCustomerAccount = userDataSnapShot.getValue(CustomerAccount.class);
//            usernameTitleTextView.setText(currentCustomerAccount.getUsername());
//        }else {
//            Account account  = userDataSnapShot.getValue(Account.class);
//            usernameTitleTextView.setText(currentEmployeeAccount.getUsername());
//        }


    }

}
