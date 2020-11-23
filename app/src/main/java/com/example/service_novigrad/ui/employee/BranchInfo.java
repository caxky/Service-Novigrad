package com.example.service_novigrad.ui.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.register.Branch;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class BranchInfo extends AppCompatActivity {
    private TextView weekdayOpeningHours;
    private ImageButton weekdayOpeningButton;
    private TextView weekdayClosingHours;
    private ImageButton weekdayClosingButton;

    private TextView saturdayOpeningHours;
    private ImageButton saturdayOpeningButton;
    private TextView saturdayClosingHours;
    private ImageButton saturdayClosingButton;

    private TextView sundayOpeningHours;
    private ImageButton sundayOpeningButton;
    private TextView sundayClosingHours;
    private ImageButton sundayClosingButton;

    private TextView branchID;
    private EditText editPhoneNumber;
    private EditText editEmailAddress;

    private String branchKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_branch_info);

        weekdayOpeningButton = findViewById(R.id.weekdayOpeningButton);
        weekdayOpeningHours = findViewById(R.id.weekdayOpening);
        weekdayClosingButton = findViewById(R.id.weekdayClosingButton);
        weekdayClosingHours = findViewById(R.id.weekdayClosing);

        saturdayOpeningButton = findViewById(R.id.saturdayOpeningButton);
        saturdayOpeningHours = findViewById(R.id.saturdayOpening);
        saturdayClosingButton = findViewById(R.id.saturdayClosingButton);
        saturdayClosingHours = findViewById(R.id.saturdayClosing);

        sundayOpeningButton = findViewById(R.id.sundayOpeningButton);
        sundayOpeningHours = findViewById(R.id.sundayOpening);
        sundayClosingButton = findViewById(R.id.sundayClosingButton);
        sundayClosingHours = findViewById(R.id.sundayClosing);

        branchID = findViewById(R.id.branchID);
        editPhoneNumber = findViewById(R.id.branchPhone);
        editEmailAddress = findViewById(R.id.branchEmailAddress);

        final Button submitButton = findViewById(R.id.submitButton);

        branchKey = getIntent().getStringExtra("branchKey");//grab the branch key sent by the employee panel
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        branchID.setText(getIntent().getStringExtra("branchID"));//set the branch id

        
        //Show the pre-existing value if any
        saturdayClosingHours.setText(getIntent().getStringExtra("saturdayClosingHours"));
        saturdayOpeningHours.setText(getIntent().getStringExtra("saturdayOpeningHours"));

        sundayClosingHours.setText(getIntent().getStringExtra("sundayClosingHours"));
        sundayOpeningHours.setText(getIntent().getStringExtra("sundayOpeningHours"));

        weekdayClosingHours.setText(getIntent().getStringExtra("weekdayClosingHours"));
        weekdayOpeningHours.setText(getIntent().getStringExtra("weekdayOpeningHours"));




        weekdayOpeningButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(BranchInfo.this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm");
                        String time = format.format(c.getTime());
                        weekdayOpeningHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();
            }
        });

        weekdayClosingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(BranchInfo.this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm");
                        String time = format.format(c.getTime());
                        weekdayClosingHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();
            }
        });

        saturdayOpeningButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(BranchInfo.this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm");
                        String time = format.format(c.getTime());
                        saturdayOpeningHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();
            }
        });

        saturdayClosingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(BranchInfo.this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm");
                        String time = format.format(c.getTime());
                        saturdayClosingHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();
            }
        });

        sundayOpeningButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(BranchInfo.this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm");
                        String time = format.format(c.getTime());
                        sundayOpeningHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();
            }
        });

        sundayClosingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(BranchInfo.this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm");
                        String time = format.format(c.getTime());
                        sundayClosingHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey);

                branchReference.child("emailAddress").setValue(editEmailAddress.getText().toString());
                branchReference.child("phoneNumber").setValue(editPhoneNumber.getText().toString());

                branchReference.child("saturdayClosingHours").setValue(saturdayClosingHours.getText().toString());
                branchReference.child("saturdayOpeningHours").setValue(saturdayOpeningHours.getText().toString());

                branchReference.child("sundayClosingHours").setValue(sundayClosingHours.getText().toString());
                branchReference.child("sundayOpeningHours").setValue(sundayOpeningHours.getText().toString());

                branchReference.child("weekdayClosingHours").setValue(weekdayClosingHours.getText().toString());
                branchReference.child("weekdayOpeningHours").setValue(weekdayOpeningHours.getText().toString());

                finish();
            }
        });

    }
}