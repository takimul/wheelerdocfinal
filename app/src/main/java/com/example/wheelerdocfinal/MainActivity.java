package com.example.wheelerdocfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.function.LongConsumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signinemail, signinpassword;
    private Button nsignup;
    private Button signinbutton;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        signinemail=findViewById(R.id.signinemail);
        signinpassword=findViewById(R.id.signinpassword);
        signinbutton=findViewById(R.id.signinbutton);
        nsignup=findViewById(R.id.nsignup);
        progressBar = findViewById(R.id.progressBar);

        nsignup.setOnClickListener(this);
        signinbutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signinbutton:
                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);

                break;
            case R.id.nsignup:
                Intent intent1 = new Intent(getApplicationContext(),signup.class);
                startActivity(intent1);
                break;
        }
    }

    private void userLogin() {
        String email= signinemail.getText().toString().trim();
        String password= signinpassword.getText().toString().trim();

        if(email.isEmpty())
        {
            signinemail.setError("Enter an email address");
            signinemail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signinemail.setError("Enter a valid email address");
            signinemail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(email.isEmpty())
        {
            signinpassword.setError("Enter a password");
            signinpassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    Intent intent= new Intent(getApplicationContext(),Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{

                    Toast.makeText(getApplicationContext(), "Login unsuccessfull", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}