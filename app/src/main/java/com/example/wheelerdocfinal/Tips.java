package com.example.wheelerdocfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        getSupportActionBar().setTitle("TIPS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}