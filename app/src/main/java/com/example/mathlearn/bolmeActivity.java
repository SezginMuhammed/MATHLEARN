package com.example.mathlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bolmeActivity extends AppCompatActivity {

    private Button btnck,btnco,btncz;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolme);

        btnck=(Button) findViewById(R.id.btnBk);
        btnco=(Button) findViewById(R.id.btnBo);
        btncz=(Button) findViewById(R.id.btnBz);


        btnck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent merhaba=new Intent(bolmeActivity.this,bolmeislemActivity.class);
                startActivity(merhaba);
            }
        });
        btnco.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent merhaba=new Intent(bolmeActivity.this,bolmeislemoActivity.class);
                startActivity(merhaba);

            }
        });
        btncz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent merhaba=new Intent(bolmeActivity.this,bolmeislemzActivity.class);
                startActivity(merhaba);
            }
        });
    }
}