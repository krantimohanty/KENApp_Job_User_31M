package com.example.suchismita.essappleave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
CardView publicholiday,leaveApplication,leaveStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Leave Management System");

        publicholiday=(CardView)findViewById(R.id.public_holiday);

        publicholiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PublicHolidayActivity.class));
            }
        });
        leaveApplication=(CardView)findViewById(R.id.leave_application);
        leaveApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LeaveApplicationActivity.class));
            }
        });
        leaveStatus=(CardView)findViewById(R.id.leave_status);
        leaveStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LeaveStatusActivity.class));
            }
        });
    }
}
