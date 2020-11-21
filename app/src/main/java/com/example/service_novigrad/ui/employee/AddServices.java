package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.service_novigrad.R;

import java.util.ArrayList;

public class AddServices extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AddServicesAdapter mAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<AddServicesItem> serviceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_add_services);


        serviceList = new ArrayList<>();
        //add stuff here
        serviceList.add(new AddServicesItem(R.drawable.gear, "Service Name" , "Service Type"));

        //
        mRecyclerView = findViewById(R.id.employeeAddRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdaptor = new AddServicesAdapter(serviceList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdaptor);

        mAdaptor.setOnItemClickListener(new AddServicesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Added!");
                //add the serviceList.get(position) to the branch service
            }
        });

    }
    public void changeItem(int position, String text){
        serviceList.get(position).changeText1(text);
        mAdaptor.notifyItemChanged(position);
    }
}