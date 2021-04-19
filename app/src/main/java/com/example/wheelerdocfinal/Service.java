package com.example.wheelerdocfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        getSupportActionBar().setTitle("SERVICES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}