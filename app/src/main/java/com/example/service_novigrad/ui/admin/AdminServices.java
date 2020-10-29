package com.example.service_novigrad.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.example.service_novigrad.ui.services.ServicesAdapter;

import java.util.ArrayList;

public class AdminServices extends AppCompatActivity {
    private ArrayList<ServiceItem> list;

    private RecyclerView mRecyclerView;
    private ServicesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText serviceName;

    private Button insertService;

    private RadioGroup servicesGroup;
    private RadioButton healthCardButton;
    private RadioButton photoIDButton;
    private RadioButton driversLicenseButton;

    private String serviceTypeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_services);

        createList();
        buildRecyclerView();

        insertService = findViewById(R.id.insertButton);
        serviceName = findViewById(R.id.serviceName);
        servicesGroup = (RadioGroup) findViewById(R.id.servicesRadioGroup);
        healthCardButton = findViewById(R.id.healthCardButton);
        photoIDButton = findViewById(R.id.photoIDButton);
        driversLicenseButton = findViewById(R.id.driversLicenseButton);


        insertService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = list.size();
                insertItem(pos);
            }
        });

        servicesGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                insertService.setEnabled(true);

                if (id == healthCardButton.getId())
                    serviceTypeString = "Health Card Service"; //Health Card Service
                else if (id == photoIDButton.getId())
                    serviceTypeString = "Photo ID Service"; //Photo ID Service
                else if (id == driversLicenseButton.getId())
                    serviceTypeString = "Driver's License Service"; //Driver's License Service

            }
        });

    }


    public void insertItem(int pos){
        list.add(new ServiceItem(R.drawable.gear, serviceName.getText().toString(), serviceTypeString));
        mAdapter.notifyItemInserted(pos);
    }

    public void removeItem(int pos){
        list.remove(pos);
        mAdapter.notifyItemRemoved(pos);
    }

    public void createList(){
        list = new ArrayList<>();
        //list.add(new ServiceItem(R.drawable.gear, "Line 1", "Line 2"));
    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.servicesRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ServicesAdapter(list);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnServiceClickListener(new ServicesAdapter.OnServiceClickListener() {
            @Override
            public void onItemClick(int pos) {
                list.get(pos).changeText1("Clicked");
                mAdapter.notifyItemChanged(pos);
            }

            @Override
            public void onDeleteClick(int pos) {
                removeItem(pos);
            }
        });
    }
}