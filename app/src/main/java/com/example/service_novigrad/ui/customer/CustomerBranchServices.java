package com.example.service_novigrad.ui.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.example.service_novigrad.R;

public class CustomerBranchServices extends AppCompatActivity {

    private RatingBar ratingBar;
    private ImageButton submitRatingButton;
    private LinearLayout ratingBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_branch_services);

        ratingBar = findViewById(R.id.branchRatingBar);
        ratingBar.setNumStars(5);

        submitRatingButton = findViewById(R.id.submitRatingButton);
        ratingBox = findViewById(R.id.ratingBox);

        submitRatingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ratingBox.setVisibility(View.GONE);
            }
        });
    }
}