package com.example.service_novigrad.ui.services;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.admin.AdminServices;

public class ServiceItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String srType = intent.getStringExtra(AdminServices.EXTRA_TEXT2);
        if(srType.equals("Photo ID Service")){
            setContentView(R.layout.default_photoid);
        }
        else if(srType.equals("Health Card Service")){
            setContentView(R.layout.default_healthcard);
        }
        else{
            setContentView(R.layout.default_driverslicense);
        }

        String srName = intent.getStringExtra(AdminServices.EXTRA_TEXT);
        TextView textViewServiceName = (TextView) findViewById(R.id.textViewServiceName);
        textViewServiceName.setText(srName);

    }
}
