package com.example.service_novigrad.ui.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
import com.example.service_novigrad.ui.services.ServiceItemActivity;
import com.example.service_novigrad.ui.services.ServicesAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminServices extends AppCompatActivity {


    public static final String EXTRA_TEXT = "com.example.service_novigrad.example.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.service_novigrad.example.EXTRA_TEXT2";

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

    private ServiceItem currentService;
    private String currentServiceID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_services);

        list = new ArrayList<>();
        insertService = findViewById(R.id.insertButton);
        serviceName = findViewById(R.id.serviceName);
        servicesGroup = (RadioGroup) findViewById(R.id.servicesRadioGroup);
        healthCardButton = findViewById(R.id.healthCardButton);
        photoIDButton = findViewById(R.id.photoIDButton);
        driversLicenseButton = findViewById(R.id.driversLicenseButton);


        createList();
        buildRecyclerView();


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
                serviceName.setError("Service name must be between 1 and 13 characters");
                //Insert Service has been relocated to the text watcher.
                //insertService.setEnabled(true);

                if (id == healthCardButton.getId())
                    serviceTypeString = "Health Card Service"; //Health Card Service
                else if (id == photoIDButton.getId())
                    serviceTypeString = "Photo ID Service"; //Photo ID Service
                else if (id == driversLicenseButton.getId())
                    serviceTypeString = "Driver's License Service"; //Driver's License Service

            }
        });

        //Checks if the service name is in the proper format.
        serviceName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            if(serviceName.getText().toString().length() <= 0 || serviceName.getText().toString().length() > 13){
                serviceName.setError("Service name must be between 1 and 13 characters");
                insertService.setEnabled(false);
            }
            else{
                serviceName.setError(null);
                insertService.setEnabled(true);
            }
            }
        });
    }

    //insert the item into the recycle list and push the item into the firebase server
    public void insertItem(int pos){
        //first create the path/reference its going to take
        DatabaseReference servicesReference = FirebaseDatabase.getInstance().getReference("Services");

        //get the key
        currentServiceID = servicesReference.push().getKey();

        //prepare the variable to be pushed
        currentService = new ServiceItem(R.drawable.gear, serviceName.getText().toString(), serviceTypeString, currentServiceID,20);

        //write the var
        servicesReference.child(currentServiceID).setValue(currentService);

        //also add to the recycle view
        list.add(currentService);
        mAdapter.notifyItemInserted(pos);
    }

    public void removeItem(int pos){
        //get the key from the serviceItem
        String serviceIDToDelete = list.get(pos).getServiceID();

        //get reference and delete it from the server
        DatabaseReference servicesDeleteReference = FirebaseDatabase.getInstance().getReference("Services").child(serviceIDToDelete);
        servicesDeleteReference.removeValue();

        //add to list to show on recycle view
        list.remove(pos);
        mAdapter.notifyItemRemoved(pos);
    }

    public void createList(){
        // get the reference of where the preexisting services are
        DatabaseReference servicesReference = FirebaseDatabase.getInstance().getReference("Services");

        //read the services and add them into the list to show them
        servicesReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> children = snapshot.getChildren(); //gets an iterable of the service
                for (DataSnapshot child: children){
                    ServiceItem temp = child.getValue(ServiceItem.class);
                    list.add(temp);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.servicesRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ServicesAdapter(list);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //when
        mAdapter.setOnServiceClickListener(new ServicesAdapter.OnServiceClickListener() {
            @Override
            public void onItemClick(int pos) {
                String text = list.get(pos).getServiceName();
                String text2 = list.get(pos).getServiceType();
                mAdapter.notifyItemChanged(pos);

                Intent intent = new Intent(getBaseContext(), ServiceItemActivity.class);
                intent.putExtra(EXTRA_TEXT,text);
                intent.putExtra(EXTRA_TEXT2,text2);
                intent.putExtra("serviceID",list.get(pos).getServiceID());
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int pos) {
                removeItem(pos);
            }
        });
    }


}