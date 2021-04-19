package com.example.wheelerdocfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private Button tipbutton,servicebutton,helpbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");

        Button tipbutton = findViewById(R.id.tipbutton);
        Button servicebutton = findViewById(R.id.servicebutton);
        Button helpbutton = findViewById(R.id.helpbutton);

        tipbutton.setOnClickListener(this);
        servicebutton.setOnClickListener(this);
        helpbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tipbutton:
                Intent intent = new Intent(getApplicationContext(),Tips.class);
                startActivity(intent);

                break;
            case R.id.servicebutton:
                Intent intent1 = new Intent(getApplicationContext(),Service.class);
                startActivity(intent1);

                break;
            case R.id.helpbutton:
                Intent intent2 = new Intent(getApplicationContext(),Help.class);
                startActivity(intent2);

                break;

        }



        }
    }
