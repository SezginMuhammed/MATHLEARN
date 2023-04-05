package com.example.mathlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button btnN,btnK;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnN=(Button) findViewById(R.id.btnNormal);
        btnK=(Button) findViewById(R.id.btnOyun);

        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent kendine=new Intent(MenuActivity.this,MainActivity.class);
               startActivity(kendine);
            }
        });

        btnK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent kendime=new Intent(MenuActivity.this,kendineGuvenActivity.class);
                startActivity(kendime);
            }
        });

    }

}