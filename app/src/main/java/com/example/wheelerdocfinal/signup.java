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

public class signup extends AppCompatActivity implements View.OnClickListener {

    private EditText signupemail, signuppassword;
    private TextView signInTextviewId;
    private Button signupbutton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.setTitle("Sign Up");

        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressBar);
        signupemail=findViewById(R.id.signupemail);
        signuppassword=findViewById(R.id.signuppassword);
        signupbutton=findViewById(R.id.signupbutton);
        signInTextviewId=findViewById(R.id.signInTextviewId);

        signInTextviewId.setOnClickListener(this);
        signupbutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signupbutton:
                userRegister();

                break;
            case R.id.signInTextviewId:
                Intent intent= new Intent( getApplicationContext(),MainActivity.class);
                startActivity(intent);

                break;
        }
    }

    private void userRegister() {
        String email= signupemail.getText().toString().trim();
        String password= signuppassword.getText().toString().trim();

        if(email.isEmpty())
        {
            signupemail.setError("Enter an email address");
            signupemail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signupemail.setError("Enter a valid email address");
            signupemail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(email.isEmpty())
        {
            signuppassword.setError("Enter a password");
            signuppassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Register is successfull", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Register is not successfull", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}