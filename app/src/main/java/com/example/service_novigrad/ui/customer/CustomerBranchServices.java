package com.example.service_novigrad.ui.customer;

import androidx.annotation.NonNull;
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
import com.example.service_novigrad.ui.register.Branch;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    private String branchKey;

    private float ratedValue;
    private BranchItem currBranchItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_branch_services);

        createList();
        buildRecyclerView();

        branchKey = this.getIntent().getStringExtra("branchKey");
        ratingBar = findViewById(R.id.branchRatingBar);
        ratingBar.setNumStars(5);

        submitRatingButton = findViewById(R.id.submitRatingButton);
        ratingBox = findViewById(R.id.ratingBox);
        ratingComment = findViewById(R.id.ratingCommentEditText);

        currBranchItem = this.getIntent().getParcelableExtra("branchItem");

        submitRatingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ratingBox.setVisibility(View.GONE);
                ratedValue = ratingBar.getRating();
                final RatingClass rating = new RatingClass(ratingComment.getText().toString(), ratedValue);
                DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey).child("Ratings");
                branchReference.push().setValue(rating);
            }
        });
    }

    public void createList() {
        branchServiceList = this.getIntent().getParcelableArrayListExtra("branchServiceList");
//        branchServiceList.add(new BranchServiceItem(R.drawable.gear, "Health Card"));
//        branchServiceList.add(new BranchServiceItem(R.drawable.gear, "Drivers License"));
//        branchServiceList.add(new BranchServiceItem(R.drawable.gear, "SIN"));
    }

    public void buildRecyclerView() {
        bsRecyclerView = findViewById(R.id.branchServicesRecyclerView);
        bsLayoutManager = new LinearLayoutManager(this);
        bsAdapter = new BranchServiceAdapter(branchServiceList);

        bsRecyclerView.setLayoutManager(bsLayoutManager);
        bsRecyclerView.setAdapter(bsAdapter);

        bsAdapter.setOnItemClickListener(new BranchServiceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int pos) {
                BranchServiceItem branchService = branchServiceList.get(pos);
                DatabaseReference serviceReference = FirebaseDatabase.getInstance().getReference("Services").child(branchService.getOriginalServiceKey());
                serviceReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ServiceItem temp = snapshot.getValue(ServiceItem.class);
                        Intent intent = new Intent(getBaseContext(), CustomerServiceForm.class);
                        intent.putExtra("fieldsAndAttach", temp.getFieldsAndAttachments());
                        intent.putExtra("branchServiceItem", branchServiceList.get(pos));
                        intent.putExtra("branchItem", currBranchItem);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}