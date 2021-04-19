package com.example.wheelerdocfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Fuel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);
        getSupportActionBar().setTitle("FUEL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}