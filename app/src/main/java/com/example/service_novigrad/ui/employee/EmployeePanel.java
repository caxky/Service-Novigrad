package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.register.RegisterActivity;

public class EmployeePanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_panel);

        final ImageButton addServicesButton = findViewById(R.id.employeeAddServicesButton);
        final ImageButton removeServicesButton = findViewById(R.id.employeeRemoveServicesButton);
        final ImageButton branchInfoButton = findViewById(R.id.employeeEditBranchInfoButton);
        final ImageButton serviceRequestsButton = findViewById(R.id.employeeServiceRequestsButton);


        addServicesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(), BranchInfo.class));
            }
        });

        removeServicesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(), BranchInfo.class));
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