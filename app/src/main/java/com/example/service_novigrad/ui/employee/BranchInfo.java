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
import java.util.regex.Pattern;

public class BranchInfo extends AppCompatActivity {
    private TextView mondayOpeningHours;
    private ImageButton mondayOpeningButton;
    private TextView mondayClosingHours;
    private ImageButton mondayClosingButton;

    private TextView tuesdayOpeningHours;
    private ImageButton tuesdayOpeningButton;
    private TextView tuesdayClosingHours;
    private ImageButton tuesdayClosingButton;

    private TextView wednesdayOpeningHours;
    private ImageButton wednesdayOpeningButton;
    private TextView wednesdayClosingHours;
    private ImageButton wednesdayClosingButton;

    private TextView thursdayOpeningHours;
    private ImageButton thursdayOpeningButton;
    private TextView thursdayClosingHours;
    private ImageButton thursdayClosingButton;

    private TextView fridayOpeningHours;
    private ImageButton fridayOpeningButton;
    private TextView fridayClosingHours;
    private ImageButton fridayClosingButton;

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
    private DatabaseReference branchReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_branch_info);

        mondayOpeningButton = findViewById(R.id.mondayOpeningButton);
        mondayOpeningHours = findViewById(R.id.mondayOpening);
        mondayClosingButton = findViewById(R.id.mondayClosingButton);
        mondayClosingHours = findViewById(R.id.mondayClosing);

        tuesdayOpeningButton = findViewById(R.id.tuesdayOpeningButton);
        tuesdayOpeningHours = findViewById(R.id.tuesdayOpening);
        tuesdayClosingButton = findViewById(R.id.tuesdayClosingButton);
        tuesdayClosingHours = findViewById(R.id.tuesdayClosing);

        wednesdayOpeningButton = findViewById(R.id.wednesdayOpeningButton);
        wednesdayOpeningHours = findViewById(R.id.wednesdayOpening);
        wednesdayClosingButton = findViewById(R.id.wednesdayClosingButton);
        wednesdayClosingHours = findViewById(R.id.wednesdayClosing);

        thursdayOpeningButton = findViewById(R.id.thursdayOpeningButton);
        thursdayOpeningHours = findViewById(R.id.thursdayOpening);
        thursdayClosingButton = findViewById(R.id.thursdayClosingButton);
        thursdayClosingHours = findViewById(R.id.thursdayClosing);

        fridayOpeningButton = findViewById(R.id.fridayOpeningButton);
        fridayOpeningHours = findViewById(R.id.fridayOpening);
        fridayClosingButton = findViewById(R.id.fridayClosingButton);
        fridayClosingHours = findViewById(R.id.fridayClosing);

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

        editPhoneNumber.addTextChangedListener(branchInfoTextWatcher);
        editEmailAddress.addTextChangedListener(branchInfoTextWatcher);

        final Button submitButton = findViewById(R.id.submitButton);

        int branchIDInt = getIntent().getIntExtra("branchID", -1);
        //Get the branch info from the intent
        branchKey = getIntent().getStringExtra("branchKey");//grab the branch key sent by the employee panel
        branchID.setText(Integer.toString(branchIDInt));//set the branch id
        branchReference = FirebaseDatabase.getInstance().getReference().child("Branches/").child(branchKey);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        //Show the pre-existing value if any
        branchReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Branch currentBranch = snapshot.getValue(Branch.class);
                saturdayClosingHours.setText(currentBranch.getSaturdayClosingHours());
                saturdayOpeningHours.setText(currentBranch.getSaturdayOpeningHours());

                sundayClosingHours.setText(currentBranch.getSundayClosingHours());
                sundayOpeningHours.setText(currentBranch.getSundayOpeningHours());

                mondayClosingHours.setText(currentBranch.getMondayClosingHours());
                mondayOpeningHours.setText(currentBranch.getMondayOpeningHours());

                tuesdayClosingHours.setText(currentBranch.getTuesdayClosingHours());
                tuesdayOpeningHours.setText(currentBranch.getTuesdayOpeningHours());

                wednesdayClosingHours.setText(currentBranch.getWednesdayClosingHours());
                wednesdayOpeningHours.setText(currentBranch.getWednesdayOpeningHours());

                thursdayClosingHours.setText(currentBranch.getThursdayClosingHours());
                thursdayOpeningHours.setText(currentBranch.getThursdayOpeningHours());

                fridayClosingHours.setText(currentBranch.getFridayClosingHours());
                fridayOpeningHours.setText(currentBranch.getFridayOpeningHours());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        mondayOpeningButton.setOnClickListener(new View.OnClickListener() {

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
                        mondayOpeningHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        mondayClosingButton.setOnClickListener(new View.OnClickListener() {

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
                        mondayClosingHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        tuesdayOpeningButton.setOnClickListener(new View.OnClickListener() {

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
                        tuesdayOpeningHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        tuesdayClosingButton.setOnClickListener(new View.OnClickListener() {

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
                        tuesdayClosingHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        wednesdayOpeningButton.setOnClickListener(new View.OnClickListener() {

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
                        wednesdayOpeningHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        wednesdayClosingButton.setOnClickListener(new View.OnClickListener() {

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
                        wednesdayClosingHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        thursdayOpeningButton.setOnClickListener(new View.OnClickListener() {

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
                        thursdayOpeningHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        thursdayClosingButton.setOnClickListener(new View.OnClickListener() {

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
                        thursdayClosingHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        fridayOpeningButton.setOnClickListener(new View.OnClickListener() {

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
                        fridayOpeningHours.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();

            }
        });

        fridayClosingButton.setOnClickListener(new View.OnClickListener() {

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
                        fridayClosingHours.setText(time);
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
                //adds the new time values and branch infos into the firebase database
                setReference(branchReference);

                finish();

            }
        });

    }

    public void setReference(DatabaseReference branchReference) {
        branchReference.child("emailAddress").setValue(editEmailAddress.getText().toString());
        branchReference.child("phoneNumber").setValue(editPhoneNumber.getText().toString());

        branchReference.child("saturdayClosingHours").setValue(saturdayClosingHours.getText().toString());
        branchReference.child("saturdayOpeningHours").setValue(saturdayOpeningHours.getText().toString());

        branchReference.child("sundayClosingHours").setValue(sundayClosingHours.getText().toString());
        branchReference.child("sundayOpeningHours").setValue(sundayOpeningHours.getText().toString());

        branchReference.child("mondayClosingHours").setValue(mondayClosingHours.getText().toString());
        branchReference.child("mondayOpeningHours").setValue(mondayOpeningHours.getText().toString());

        branchReference.child("tuesdayClosingHours").setValue(tuesdayClosingHours.getText().toString());
        branchReference.child("tuesdayOpeningHours").setValue(tuesdayOpeningHours.getText().toString());

        branchReference.child("wednesdayClosingHours").setValue(wednesdayClosingHours.getText().toString());
        branchReference.child("wednesdayOpeningHours").setValue(wednesdayOpeningHours.getText().toString());

        branchReference.child("thursdayClosingHours").setValue(thursdayClosingHours.getText().toString());
        branchReference.child("thursdayOpeningHours").setValue(thursdayOpeningHours.getText().toString());

        branchReference.child("fridayClosingHours").setValue(fridayClosingHours.getText().toString());
        branchReference.child("fridayOpeningHours").setValue(fridayOpeningHours.getText().toString());
    }

    private Boolean validateEmail(String email){
        Boolean result = false;
        if(email.contains("@")){
            String[] splitUserName = email.split("@");
            if(splitUserName.length<3 && splitUserName.length>1){
                String prefix = splitUserName[0];
                String domain = splitUserName[1];
                if(domain.contains(".") && !domain.endsWith(".") && prefix.length() != 0 && !domain.startsWith(".")){
                    result = true;
                }
            }
        }
        return result;
    }

    private Boolean isValidMobile(String phone) {
        boolean result=false;
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            if(phone.length() < 6 || phone.length() > 13) {
                result = false;
            } else {
                result = true;
            }
        } else {
            result=false;
        }
        return result;
    }

    private TextWatcher branchInfoTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(!validateEmail(editEmailAddress.getText().toString())){
                editEmailAddress.setError("Invalid email");
            }
            else{
                editEmailAddress.setError(null);
            }

            if(!isValidMobile(editPhoneNumber.getText().toString())){
                editPhoneNumber.setError("Invalid phone");
            }
            else{
                editPhoneNumber.setError(null);
            }
        }
    };
}