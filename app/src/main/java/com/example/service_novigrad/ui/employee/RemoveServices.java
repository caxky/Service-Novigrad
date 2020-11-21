package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItem;

import java.util.ArrayList;

public class RemoveServices extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RemoveServicesAdapter mAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ServiceItem> branchServiceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_remove_services);

        branchServiceList = new ArrayList<>();
        //What you'll want to do here is access the database, itereate through it and fill up the array list.
        branchServiceList.add(new ServiceItem(R.drawable.gear, "Service Name" , "Service Type", "22ff"));

        mRecyclerView = findViewById(R.id.employeeRemoveRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdaptor = new RemoveServicesAdapter(branchServiceList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdaptor);

        mAdaptor.setOnItemClickListener(new RemoveServicesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
                //Remove service from branch database here, or inside the above function.
            }
        });
    }

    public void removeItem(int position){
        branchServiceList.remove(position);
        mAdaptor.notifyItemRemoved(position);
    }
}