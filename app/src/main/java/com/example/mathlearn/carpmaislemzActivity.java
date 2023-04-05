package com.example.mathlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Random;

public class carpmaislemzActivity extends AppCompatActivity {

    private TextView txtSorut;
    private EditText editTxtTahmin;
    private ArrayList<String> islemTurleri;
    private Random rndIslem,rndSayi;
    private int rndIslemNumber,rndSayiNumber;
    private  String soru,txtTahmin;
    private int s1,s2,sonuc;
    private ToggleButton btn1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpmaislemz);
        islemTurleri=new ArrayList<>();
        rndIslem=new Random();
        rndSayi=new Random();
        txtSorut=(TextView)findViewById(R.id.txtSoruCz);
        editTxtTahmin=(EditText)findViewById(R.id.editTxtTahminCz);
        btn1=(ToggleButton) findViewById(R.id.toggleBtnCz);


        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    islemTurleri.add("*");
                }
                else
                {
                    islemTurleri.remove("*");
                    Intent kendime=new Intent(carpmaislemzActivity.this,kendineGuvenActivity.class);
                    startActivity(kendime);
                }
            }
        });


    }
    public void btnClickB(View v)
    {
        switch (v.getId())
        {
            case R.id.btnSoruGetirCz:
                txtSorut.setText(İslemTurunuVeSoruyuBelirle());
                break;
            case R.id.btnTahmindeBulunCz:
                TahminKontrol();
                break;
        }
    }
    private void TahminKontrol()
    {
        txtTahmin=editTxtTahmin.getText().toString();

        if (!TextUtils.isEmpty(txtTahmin))
        {
            if (txtTahmin.matches(String.valueOf(sonuc)))
            {
                Toast.makeText(getApplicationContext(),"Tebrikler Doğru Tahminde Bulundunuz :)",Toast.LENGTH_SHORT).show();

                editTxtTahmin.setText("");
                txtSorut.setText(İslemTurunuVeSoruyuBelirle());
            }else
                Toast.makeText(getApplicationContext(),"Yanlış Tahminde Bulundunuz :(",Toast.LENGTH_SHORT).show();





        }else
            Toast.makeText(getApplicationContext(),"Girilen Değer Geçersizdir.",Toast.LENGTH_SHORT).show();
    }
    private String İslemTurunuVeSoruyuBelirle()
    {
        soru="";
        if (islemTurleri.size()>0)
        {
            rndIslemNumber=rndIslem.nextInt(islemTurleri.size());
            s1=randomSayiGetir();
            soru+=s1;
            soru+=" ";

            soru+=islemTurleri.get(rndIslemNumber);

            soru+=" ";
            s2=randomSayiGetir();
            soru+=s2;
            soru+=" ";



            switch (islemTurleri.get(rndIslemNumber))
            {
                case"*":
                    sonuc= s1 * s2 ;
                    break;


            }
        }
        return soru;
    }
    private int randomSayiGetir()
    {

        rndSayiNumber=rndSayi.nextInt(100)+1;


        return rndSayiNumber;
    }
    private int randomSayiGetir1()
    {

        rndSayiNumber=rndSayi.nextInt(1000)+1;


        return rndSayiNumber;
    }
}