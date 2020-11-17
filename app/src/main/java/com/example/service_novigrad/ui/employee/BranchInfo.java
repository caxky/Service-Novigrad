package com.example.service_novigrad.ui.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.service_novigrad.R;

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
    }
}