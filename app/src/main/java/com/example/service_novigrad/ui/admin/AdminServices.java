package com.example.service_novigrad.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.example.service_novigrad.ui.services.ServicesAdapter;

import java.util.ArrayList;

public class AdminServices extends AppCompatActivity {
    private ArrayList<ServiceItem> list;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button insertService;
    private Button deleteService;
    private EditText indexDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_services);

        createList();
        buildRecyclerView();

        insertService = findViewById(R.id.insertButton);
        deleteService = findViewById(R.id.deleteButton);
        indexDelete = findViewById(R.id.deleteText);


        insertService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = list.size();
                insertItem(pos);
            }
        });

        deleteService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(indexDelete.getText().toString());
                removeItem(pos);
            }
        });


    }

    public void insertItem(int pos){
        list.add(new ServiceItem(R.drawable.gear, "New Item At Position" + pos, "Edit here"));
        mAdapter.notifyItemInserted(pos);
    }

    public void removeItem(int pos){
        list.remove(pos);
        mAdapter.notifyItemRemoved(pos);
    }

    public void createList(){
        list = new ArrayList<>();
        list.add(new ServiceItem(R.drawable.gear, "Line 1", "Line 2"));
        list.add(new ServiceItem(R.drawable.gear, "Line 3", "Line 4"));
        list.add(new ServiceItem(R.drawable.gear, "Line 5", "Line 6"));
    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.servicesRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ServicesAdapter(list);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}