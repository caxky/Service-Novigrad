package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItemActivity;
import com.example.service_novigrad.ui.services.ServicesAdapter;

import java.util.ArrayList;

public class ServiceRequests extends AppCompatActivity {
    ArrayList<ServiceRequestItem> requestList;

    private RecyclerView serviceRequestRecyclerView;
    private ServiceRequestAdapter serviceRequestAdapter;
    private RecyclerView.LayoutManager serviceRequestLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_service_requests);

        createServiceRequestList();
        buildRecyclerView();

    }

    public void acceptItem(int pos){
        requestList.get(pos).setStatus(true);
        requestList.remove(pos);
        serviceRequestAdapter.notifyItemRemoved(pos);
    }

    public void denyItem(int pos){
        requestList.get(pos).setStatus(false);
        requestList.remove(pos);
        serviceRequestAdapter.notifyItemRemoved(pos);
    }

    public void createServiceRequestList(){
        requestList = new ArrayList<>();
        /*requestList.add(new ServiceRequestItem(R.drawable.requests, "Health Card", "Bob Smith"));
        requestList.add(new ServiceRequestItem(R.drawable.requests, "Drivers License", "David James"));
        requestList.add(new ServiceRequestItem(R.drawable.requests, "Health Card", "Nathan Brown"));
        requestList.add(new ServiceRequestItem(R.drawable.requests, "Passport", "Joe George"));*/
    }

    public void buildRecyclerView(){
        serviceRequestRecyclerView = findViewById(R.id.employeeServicesRecyclerView);
        serviceRequestLayoutManager = new LinearLayoutManager(this);
        serviceRequestAdapter = new ServiceRequestAdapter(requestList);

        serviceRequestRecyclerView.setLayoutManager(serviceRequestLayoutManager);
        serviceRequestRecyclerView.setAdapter(serviceRequestAdapter);

        serviceRequestAdapter.setOnItemClickListener(new ServiceRequestAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent intent = new Intent(getBaseContext(), ServiceRequestInformation.class);
                startActivity(intent);
            }

            @Override
            public void onAcceptClick(int pos) {
                acceptItem(pos);
            }

            @Override
            public void onDenyClick(int pos){
                denyItem(pos);
            }
        });
    }
}