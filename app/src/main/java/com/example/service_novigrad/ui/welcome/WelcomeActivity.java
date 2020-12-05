package com.example.service_novigrad.ui.welcome;
import com.example.service_novigrad.accounts.Account;
import com.example.service_novigrad.accounts.CustomerAccount;
import com.example.service_novigrad.accounts.EmployeeAccount;
import com.example.service_novigrad.ui.customer.BranchItem;
import com.example.service_novigrad.ui.customer.CustomerPanel;
import com.example.service_novigrad.ui.login.*;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
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
import com.example.service_novigrad.ui.register.Branch;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    ArrayList<BranchItem> branchItemList = new ArrayList<>();
    // Searches for the account in the database, finds the account type and set the username and accountID accordingly onto the textview in welcome activity
    public void searchAndSetUsernameAndAccountID(DatabaseReference accountsReference, final String userName, final String password, final TextView usernameTitleTextView, final TextView accountIDTextView){
        accountsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> children = snapshot.getChildren();// gets iterable of customer accounts

                // iterates through customer accounts and check if the user is in this type of account if yes set the accounttype and username textview
                for (DataSnapshot child: children){
                    CustomerAccount temp = child.getValue(CustomerAccount.class);
                    if(temp.getUsername().equals(userName)&&temp.getPassword().equals(password)){
                        usernameTitleTextView.setText(userName);
                        accountIDTextView.setText("Customer");
                        break;
                    }

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        //if nothing is found in customer account type we switch to find it in employee accounts
        accountsReference = FirebaseDatabase.getInstance().getReference().child("Employee Accounts");
        accountsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> children = snapshot.getChildren();// gets iterable of employee accounts

                // iterates through employee accounts and check if the user is in this type of account if yes set the accounttype and username textview
                for (DataSnapshot child: children){
                    EmployeeAccount temp = child.getValue(EmployeeAccount.class);;


                    if(temp.getUsername().equals(userName)&&temp.getPassword().equals(password)){
                        usernameTitleTextView.setText(userName);
                        accountIDTextView.setText("Employee");
                        break;
                    }

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        //Variables needed for the
        String userName = LoginActivity.userName;
        String password = LoginActivity.password;
        TextView usernameTitleTextView = findViewById(R.id.username);
        TextView accountIDTextView = findViewById(R.id.accountID);

        //Sets the UserName and the account type onto the welcome screen
        DatabaseReference accountsReference = FirebaseDatabase.getInstance().getReference().child("Customer Accounts"); //give the reference(location) to the customer accounts in the db
        searchAndSetUsernameAndAccountID(accountsReference,userName, password,usernameTitleTextView, accountIDTextView);

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(4000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                                        DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/");
                    branchReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot child : snapshot.getChildren()) {
                                Branch temp = child.getValue(Branch.class);
                                branchItemList.add(new BranchItem(R.drawable.gear, Integer.toString(temp.getBranchID()), temp.getSaturdayOpeningHours(), temp.getSaturdayClosingHours(), temp.getBranchFirebaseKey()));
                            }
                            Intent intent = new Intent(WelcomeActivity.this, CustomerPanel.class);
                            intent.putExtra("branchList", branchItemList);
                            startActivity(intent);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        };
        thread.start();

    }

}
