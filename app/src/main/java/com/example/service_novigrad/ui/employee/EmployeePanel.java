package com.example.service_novigrad.ui.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.register.RegisterActivity;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EmployeePanel extends AppCompatActivity {

    private TextView employeeNameText;
    private TextView employeeEmailText;
    private TextView employeePhoneText;
    private TextView employeeAccountIDText;
    private TextView branchIDText;
    private ArrayList<ServiceItem> serviceList = new ArrayList<>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_panel);

        final ImageButton addServicesButton = findViewById(R.id.employeeAddServicesButton);
        final ImageButton removeServicesButton = findViewById(R.id.employeeRemoveServicesButton);
        final ImageButton branchInfoButton = findViewById(R.id.employeeEditBranchInfoButton);
        final ImageButton serviceRequestsButton = findViewById(R.id.employeeServiceRequestsButton);

        employeeNameText = findViewById(R.id.employeeName);
        employeeEmailText = findViewById(R.id.employeeEmail);
        employeePhoneText = findViewById(R.id.employeePhone);
        employeeAccountIDText = findViewById(R.id.employeeAccountID);
        branchIDText = findViewById(R.id.branchID);


        addServicesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {

                DatabaseReference servicesReference = FirebaseDatabase.getInstance().getReference("Services");
                ValueEventListener serviceListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Iterable<DataSnapshot> children = snapshot.getChildren(); //gets an iterable of the service
                        for (DataSnapshot child: children){
                            ServiceItem temp = child.getValue(ServiceItem.class);
                            serviceList.add(new ServiceItem(R.drawable.gear, temp.getServiceName(), temp.getServiceType(), temp.getServiceID()));
                        }
                        Intent intent = new Intent(view.getContext(), AddServices.class);
                        intent.putExtra("serviceList", serviceList);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                servicesReference.addValueEventListener(serviceListener);



            }
        });

        removeServicesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), RemoveServices.class));
            }
        });

        branchInfoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), BranchInfo.class));
            }
        });

        serviceRequestsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), ServiceRequests.class));
            }
        });
    }
}