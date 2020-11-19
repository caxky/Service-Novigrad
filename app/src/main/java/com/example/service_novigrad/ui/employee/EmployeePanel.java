package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.register.RegisterActivity;

public class EmployeePanel extends AppCompatActivity {

    private TextView employeeNameText;
    private TextView employeeEmailText;
    private TextView employeePhoneText;
    private TextView employeeAccountIDText;
    private TextView branchIDText;

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
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AddServices.class));
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