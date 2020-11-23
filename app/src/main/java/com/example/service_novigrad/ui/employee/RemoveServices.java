package com.example.service_novigrad.ui.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Service;
import android.os.Bundle;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RemoveServices extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RemoveServicesAdapter mAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ServiceItem> branchServiceList;
    private String branchKey;
    private int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_remove_services);

        branchServiceList =  (ArrayList<ServiceItem>) this.getIntent().getSerializableExtra("branchServiceList");
        //What you'll want to do here is access the database, itereate through it and fill up the array list.
//        branchServiceList.add(new ServiceItem(R.drawable.gear, "Service Name" , "Service Type", "22ff"));
        branchKey = this.getIntent().getStringExtra("branchKey");
        DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference("Branches").child(branchKey);


        mRecyclerView = findViewById(R.id.employeeRemoveRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdaptor = new RemoveServicesAdapter(branchServiceList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdaptor);



        mAdaptor.setOnItemClickListener(new RemoveServicesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {

            }

            @Override
            public void onDeleteClick(final int position) {
                currentPosition = position;
                //Remove service from branch database here, or inside the above function.
                DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey).child("Branch Services");
                branchReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Iterable<DataSnapshot>children = snapshot.getChildren();
                        for(DataSnapshot child: children){
                            ServiceItem temp = child.getValue(ServiceItem.class);
                            if (branchServiceList.get(currentPosition).getServiceID().equals(temp.getServiceID())){
                                child.getRef().removeValue();
                                removeItem(currentPosition);
                                mAdaptor.notifyItemRemoved(position);
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }

    public void removeItem(int position){
        branchServiceList.remove(position);
        mAdaptor.notifyItemRemoved(position);
    }
}