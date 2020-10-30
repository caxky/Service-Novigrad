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
        setContentView(R.layout.default_services);

        String srName = intent.getStringExtra(AdminServices.EXTRA_TEXT);
        String srType = intent.getStringExtra(AdminServices.EXTRA_TEXT2);
        TextView textViewServiceName = (TextView) findViewById(R.id.textViewServiceName);
        TextView textViewServiceType = (TextView) findViewById(R.id.textViewServiceType);
        textViewServiceName.setText(srName);
        textViewServiceType.setText(srType);

    }
}
