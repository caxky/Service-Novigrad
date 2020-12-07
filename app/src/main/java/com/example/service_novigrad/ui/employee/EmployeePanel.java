package com.example.service_novigrad.ui.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.customer.CustomerFormRequest;
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
        DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches").child(branchKey);
        branchReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Branch currentBranch = snapshot.getValue(Branch.class);

                branchEmailText.setText("Branch Email: " + currentBranch.getEmailAddress());
                branchPhoneText.setText("Branch Phone: " + currentBranch.getPhoneNumber());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        String nameText, accountIDText, branchIDString;
        nameText = "Employee Name: " + firstName + " " + lastName;
        accountIDText = "Employee Account ID: " + accountID;
        branchIDString = "Branch ID: " + branchID;
        employeeNameText.setText(nameText);
        employeeAccountIDText.setText(accountIDText);
        branchIDText.setText(branchIDString);


        addServicesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                //set intent to AddServices
                newIntent = new Intent(view.getContext(), AddServices.class);

                //initialize arraylist to be passed into intent
                serviceList = new ArrayList<>();

                // this block of code finds the service type available (created by admin an the services
                // already in the branch, put it in intent to be retrievable in AddServices and starts the activity
                servicesReference = FirebaseDatabase.getInstance().getReference("Services");

                serviceListener = new ValueEventListener() { // first layer to find the available services
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Iterable<DataSnapshot> children = snapshot.getChildren(); //gets an iterable of the service
                        for (DataSnapshot child : children) {
                            ServiceItem temp = child.getValue(ServiceItem.class);
                            serviceList.add(new ServiceItem(temp.getServiceName(), temp.getServiceType(), temp.getServiceID(), temp.getFieldsAndAttachments(), temp.getDefaultPrice()));
                        }
                        DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey).child("Branch Services");
                        branchReference.addListenerForSingleValueEvent(new ValueEventListener() { //second layer to find the branch services, put them in intent and startActivity
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Iterable<DataSnapshot> children = snapshot.getChildren(); //gets an iterable of the service
                                ArrayList<ServiceItem> branchServiceList = new ArrayList<>();
                                for (DataSnapshot child : children) {
                                    ServiceItem temp = child.getValue(ServiceItem.class);
                                    branchServiceList.add(new ServiceItem(temp.getServiceName(), temp.getServiceType(), temp.getServiceID(), temp.getFieldsAndAttachments(), temp.getDefaultPrice()));
                                }
                                //puts values in intent to be retrieved and worked on in the new activity
                                newIntent.putExtra("serviceList", serviceList);
                                newIntent.putExtra("branchServiceList", branchServiceList);
                                newIntent.putExtra("branchKey", branchKey);
                                startActivity(newIntent);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

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
                //Set the intent to the next activity removeService
                newIntent = new Intent(view.getContext(), RemoveServices.class);
                serviceList = new ArrayList<>(); //resets the arraylist

                //Reads for the list of service IN the branch already put it in the intent and start activity
                DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey).child("Branch Services");
                branchReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Iterable<DataSnapshot> children = snapshot.getChildren();
                        for (DataSnapshot child : children) { //iterate and add to the arraylist all the services in branch
                            ServiceItem temp = child.getValue(ServiceItem.class);
                            serviceList.add(new ServiceItem(temp.getServiceName(), temp.getServiceType(), temp.getServiceID(), temp.getFieldsAndAttachments(), temp.getDefaultPrice()
                            ));
                        }

                        //puts values in intent to be retrieved and worked on in the new activity
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
                //set intent to the branchInfo class
                newIntent = new Intent(view.getContext(), BranchInfo.class);
                DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches").child(branchKey);
                //Sends the preexisting info of the branch info for convenience and start activity
                branchReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Branch currentBranch = snapshot.getValue(Branch.class);
                        newIntent.putExtra("branchKey", branchKey);
                        newIntent.putExtra("branchID", branchID);

                        startActivity(newIntent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

        serviceRequestsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DatabaseReference requestReference = FirebaseDatabase.getInstance().getReference().child("Branches").child(branchKey).child("Branch Requests");
                newIntent = new Intent(view.getContext(), ServiceRequests.class);
                requestReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ArrayList<ServiceRequestItem> inputArrList = new ArrayList<>();
                        for (DataSnapshot child : snapshot.getChildren()) {
                            CustomerFormRequest temp = child.getValue(CustomerFormRequest.class);
                            inputArrList.add(new ServiceRequestItem(R.drawable.user_icon, temp.getBranchServiceItem().getBsServiceName(),temp));
                        }
                        newIntent.putExtra("serviceRequestItemList", inputArrList);
                        startActivity(newIntent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}