package com.example.mathlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kendineGuvenActivity extends AppCompatActivity {
    private Button btnt,btnf,btnb,btnc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kendine_guven);
        btnt=(Button) findViewById(R.id.btnt);
        btnf=(Button) findViewById(R.id.btnf);
        btnb=(Button) findViewById(R.id.btnb);
        btnc=(Button) findViewById(R.id.btnc);

        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kendime=new Intent(kendineGuvenActivity.this,ToplamaActivity.class);
                startActivity(kendime);
            }
        });
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kendime=new Intent(kendineGuvenActivity.this,cikarmaActivity.class);
                startActivity(kendime);

            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kendime=new Intent(kendineGuvenActivity.this,bolmeActivity.class);
                startActivity(kendime);
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kendime=new Intent(kendineGuvenActivity.this,carpmaActivity.class);
                startActivity(kendime);
            }
        });
    }
}