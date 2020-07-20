package com.example.emart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class SignActivity extends AppCompatActivity {


    Button login;
    Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().hide();

        login = findViewById(R.id.btnlogin);
        registration = findViewById(R.id.btnreg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignActivity.this,"Login has been clicked",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SignActivity.this, SignIn_Activity.class);
                startActivity(i);
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignActivity.this,"Register has been clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignActivity.this, SignUp_Activity.class);
                startActivity(intent);
            }
        });
    }
}
