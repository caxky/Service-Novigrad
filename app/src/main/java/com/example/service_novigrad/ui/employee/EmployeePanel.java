package com.example.service_novigrad.ui.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.register.Branch;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EmployeePanel extends AppCompatActivity {

    private TextView employeeNameText;
    private TextView branchEmailText;
    private TextView branchPhoneText;
    private TextView employeeAccountIDText;
    private TextView branchIDText;
    private ArrayList<ServiceItem> serviceList = new ArrayList<>();
    ;
    private String branchKey;
    private Intent newIntent;
    private DatabaseReference servicesReference;
    private ValueEventListener serviceListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_panel);

        final ImageButton addServicesButton = findViewById(R.id.employeeAddServicesButton);
        final ImageButton removeServicesButton = findViewById(R.id.employeeRemoveServicesButton);
        final ImageButton branchInfoButton = findViewById(R.id.employeeEditBranchInfoButton);
        final ImageButton serviceRequestsButton = findViewById(R.id.employeeServiceRequestsButton);

        employeeNameText = findViewById(R.id.employeeName);
        branchEmailText = findViewById(R.id.employeeEmail);
        branchPhoneText = findViewById(R.id.employeePhone);
        employeeAccountIDText = findViewById(R.id.employeeAccountID);
        branchIDText = findViewById(R.id.branchID);

        //all the info got from before sent when logging in
        String firstName = getIntent().getStringExtra("employeeFirstName");
        String lastName = getIntent().getStringExtra("employeeLastName");
        long accountID = getIntent().getLongExtra("employeeAccountID", -1);
        final int branchID = getIntent().getIntExtra("branchID", -1);
        branchKey = getIntent().getStringExtra("branchKey");
        // branch email and branch phone when changed 

        String nameText, accountIDText, branchIDString;
        nameText = "Employee Name: " + firstName + " " + lastName;
        accountIDText = "Employee Account ID: " + accountID;
        branchIDString = "Branch ID: " + branchID;
        employeeNameText.setText(nameText);
        employeeAccountIDText.setText(accountIDText);
        branchIDText.setText(branchIDString);




        addServicesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                newIntent = new Intent(view.getContext(), AddServices.class);
                serviceList = new ArrayList<>();
                // This is used to get the list of services that a branch can choose that is created by admin
                // In addition after this the new activity is started
                servicesReference = FirebaseDatabase.getInstance().getReference("Services");
                serviceListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Iterable<DataSnapshot> children = snapshot.getChildren(); //gets an iterable of the service
                        for (DataSnapshot child : children) {
                            ServiceItem temp = child.getValue(ServiceItem.class);
                            serviceList.add(new ServiceItem( temp.getServiceName(), temp.getServiceType(), temp.getServiceID(),temp.getFieldsAndAttachments()));
                        }
                        newIntent.putExtra("serviceList", serviceList);
                        newIntent.putExtra("branchKey", branchKey);
                        startActivity(newIntent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                servicesReference.addListenerForSingleValueEvent(serviceListener);

            }
        });

        removeServicesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                newIntent = new Intent(view.getContext(), RemoveServices.class);
                serviceList = new ArrayList<>();
                DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey).child("Branch Services");
                branchReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Iterable<DataSnapshot>children = snapshot.getChildren();
                        for(DataSnapshot child: children){
                            ServiceItem temp = child.getValue(ServiceItem.class);
                            serviceList.add(new ServiceItem(temp.getServiceName(), temp.getServiceType(), temp.getServiceID(),temp.getFieldsAndAttachments()));
                        }
                        newIntent.putExtra("branchKey", branchKey);
                        newIntent.putExtra("branchServiceList", serviceList);
                        startActivity(newIntent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        branchInfoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                newIntent = new Intent(view.getContext(), BranchInfo.class);
                newIntent.putExtra("branchKey", branchKey);
                newIntent.putExtra("branchID", branchID);
                startActivity(newIntent);

            }
        });

        serviceRequestsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), ServiceRequests.class));
            }
        });
    }
}