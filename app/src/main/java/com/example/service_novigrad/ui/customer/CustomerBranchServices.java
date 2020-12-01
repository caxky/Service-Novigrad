package com.example.service_novigrad.ui.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.employee.ServiceRequestInformation;

import java.util.ArrayList;

public class CustomerBranchServices extends AppCompatActivity {

    private ArrayList<BranchServiceItem> branchServiceList;

    private RecyclerView bsRecyclerView;
    private BranchServiceAdapter bsAdapter;
    private RecyclerView.LayoutManager bsLayoutManager;

    private RatingBar ratingBar;
    private ImageButton submitRatingButton;
    private LinearLayout ratingBox;
    private EditText ratingComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_branch_services);

        createList();
        buildRecyclerView();

        ratingBar = findViewById(R.id.branchRatingBar);
        ratingBar.setNumStars(5);

        submitRatingButton = findViewById(R.id.submitRatingButton);
        ratingBox = findViewById(R.id.ratingBox);
        ratingComment = findViewById(R.id.ratingCommentEditText);



        submitRatingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ratingBox.setVisibility(View.GONE);
                float ratedValue = ratingBar.getRating();
            }
        });
    }

    public void createList(){
        branchServiceList = new ArrayList<>();
        branchServiceList.add(new BranchServiceItem(R.drawable.gear, "Health Card"));
        branchServiceList.add(new BranchServiceItem(R.drawable.gear, "Drivers License"));
        branchServiceList.add(new BranchServiceItem(R.drawable.gear, "SIN"));
    }

    public void buildRecyclerView(){
        bsRecyclerView = findViewById(R.id.branchServicesRecyclerView);
        bsLayoutManager = new LinearLayoutManager(this);
        bsAdapter = new BranchServiceAdapter(branchServiceList);

        bsRecyclerView.setLayoutManager(bsLayoutManager);
        bsRecyclerView.setAdapter(bsAdapter);

        bsAdapter.setOnItemClickListener(new BranchServiceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent intent = new Intent(getBaseContext(), ServiceRequestInformation.class);
                startActivity(intent);
            }
        });
    }
}