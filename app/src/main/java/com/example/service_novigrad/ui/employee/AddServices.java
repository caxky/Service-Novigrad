package com.example.service_novigrad.ui.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddServices extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AddServicesAdapter mAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ServiceItem> serviceList;
    private String branchKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_add_services);


        serviceList = (ArrayList<ServiceItem>) this.getIntent().getSerializableExtra("serviceList");
        branchKey = this.getIntent().getStringExtra("branchKey");
//        What you'll want to do here is access the database, itereate through it and fill up the array list.
//        serviceList.add(new ServiceItem(R.drawable.gear, "Service Name" , "Service Type", "22ff"));

//        DatabaseReference servicesReference = FirebaseDatabase.getInstance().getReference("Services");
//        ValueEventListener serviceListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Iterable<DataSnapshot> children = snapshot.getChildren(); //gets an iterable of the service
//                for (DataSnapshot child: children){
//                    ServiceItem temp = child.getValue(ServiceItem.class);
//                    serviceList.add(new ServiceItem(R.drawable.gear, temp.getServiceName(), temp.getServiceType(), temp.getServiceID()));
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//
//        servicesReference.addValueEventListener(serviceListener);


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
                DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey).child("Branch Services").child(String.valueOf(position));
//                String branchServiceKey = branchReference.push().getKey();
                branchReference.setValue(serviceList.get(position));
                
            }
        });

    }

    public void changeItem(int position, String text) {
        serviceList.get(position).changeText1(text);
        mAdaptor.notifyItemChanged(position);
    }
}