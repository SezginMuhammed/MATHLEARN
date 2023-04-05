package com.example.mathlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToplamaActivity extends AppCompatActivity {
    private Button btnk,btno,btnz;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplama);
        btnk=(Button) findViewById(R.id.btnTk);
        btno=(Button) findViewById(R.id.btnTo);
        btnz=(Button) findViewById(R.id.btnTz);


        btnk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent kendime=new Intent(ToplamaActivity.this,toplamaislemActivity.class);
                startActivity(kendime);
            }
        });
        btno.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent kendime=new Intent(ToplamaActivity.this,toplamaislemoMainActivity.class);
                startActivity(kendime);
            }
        });
        btnz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent kendime=new Intent(ToplamaActivity.this,toplamaislemzActivity.class);
                startActivity(kendime);
            }
        });

    }
}