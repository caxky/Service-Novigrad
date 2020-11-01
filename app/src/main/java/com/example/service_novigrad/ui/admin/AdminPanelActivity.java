package com.example.service_novigrad.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.service_novigrad.R;

public class AdminPanelActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel);


        final ImageButton servicesButton = findViewById(R.id.manageServices);
        final ImageButton accountsButton = findViewById(R.id.manageAccounts);


        servicesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AdminServices.class));
            }
        });

        accountsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AdminAccounts.class));
            }
        });
    }


}
