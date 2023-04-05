package com.example.mathlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class carpmaActivity extends AppCompatActivity {


    private Button btnck, btnco, btncz;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpma);

        btnck = (Button) findViewById(R.id.btnCk);
        btnco = (Button) findViewById(R.id.btnCo);
        btncz = (Button) findViewById(R.id.btnCz);


        btnck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent merhaba = new Intent(carpmaActivity.this, carpmaislemActivity.class);
                startActivity(merhaba);
            }
        });
        btnco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent merhaba = new Intent(carpmaActivity.this, carpmaislemoActivity.class);
                startActivity(merhaba);

            }
        });
        btncz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent merhaba = new Intent(carpmaActivity.this, carpmaislemzActivity.class);
                startActivity(merhaba);
            }
        });
    }
}