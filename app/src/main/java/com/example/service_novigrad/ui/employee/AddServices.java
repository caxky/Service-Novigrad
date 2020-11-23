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
    private ArrayList<ServiceItem> serviceList, branchServiceList;
    private String branchKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_add_services);

        //Retrieve info stored in intent
        branchServiceList = (ArrayList<ServiceItem>) this.getIntent().getSerializableExtra("branchServiceList");
        serviceList = (ArrayList<ServiceItem>) this.getIntent().getSerializableExtra("serviceList");
        branchKey = this.getIntent().getStringExtra("branchKey");

        //checks if the available service item exists already in teh branch if so remove it and not have it displayed
        for(int i = 0 ; i < serviceList.size() ; i++){
            for(ServiceItem item : branchServiceList){
                try{
                    if(serviceList.get(i).getServiceID().equals(item.getServiceID())){
                        removeItem(i);
                    }
                }
                catch(Exception e){
                }
            }
        }



        mRecyclerView = findViewById(R.id.employeeAddRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdaptor = new AddServicesAdapter(serviceList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdaptor);

        mAdaptor.setOnItemClickListener(new AddServicesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                //This is when the thing is clicked, here add the position of that service and add the equivalent service to the branch.
                DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey).child("Branch Services");
                String branchServiceKey = branchReference.push().getKey();
                branchReference.child(branchServiceKey).setValue(serviceList.get(position));

                changeItem(position, "Added!");//change text to added
                removeItem(position);//remove item in the recycle view

            }
        });

    }

    public void changeItem(int position, String text) {
        serviceList.get(position).changeText1(text);
        mAdaptor.notifyItemChanged(position);
    }

    public void removeItem(int position){
        serviceList.remove(position);
        mAdaptor.notifyItemRemoved(position);
    }
}