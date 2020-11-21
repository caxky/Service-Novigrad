package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItem;

import java.util.ArrayList;

public class AddServices extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AddServicesAdapter mAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ServiceItem> serviceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_add_services);


        serviceList = new ArrayList<>();
        //What you'll want to do here is access the database, itereate through it and fill up the array list.
        serviceList.add(new ServiceItem(R.drawable.gear, "Service Name" , "Service Type", "22ff"));


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
                //This is when the thing is clicked, here add the position of that service and add the equivalent serivce to the branch.
            }
        });

    }
    public void changeItem(int position, String text){
        serviceList.get(position).changeText1(text);
        mAdaptor.notifyItemChanged(position);
    }
}