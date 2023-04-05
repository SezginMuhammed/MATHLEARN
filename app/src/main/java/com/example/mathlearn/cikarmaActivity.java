package com.example.mathlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cikarmaActivity extends AppCompatActivity {
    private Button btnck,btnco,btncz;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cikarma);

    btnck=(Button) findViewById(R.id.btnFk);
    btnco=(Button) findViewById(R.id.btnFo);
    btncz=(Button) findViewById(R.id.btnFz);


        btnck.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View view) {
        Intent merhaba=new Intent(cikarmaActivity.this,cikarmaislemActivity.class);
        startActivity(merhaba);
    }
    });
        btnco.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View view) {
        Intent merhaba=new Intent(cikarmaActivity.this,cikarmaislemoActivity.class);
        startActivity(merhaba);

    }
    });
        btncz.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View view) {
        Intent merhaba=new Intent(cikarmaActivity.this,cikarmaislemzActivity.class);
        startActivity(merhaba);
    }
    });
}
}