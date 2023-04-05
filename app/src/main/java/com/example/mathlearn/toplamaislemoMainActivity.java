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

public class toplamaislemoMainActivity extends AppCompatActivity {
    private TextView txtSoru;
    private EditText editTxtTahmin;
    private ArrayList<String> islemTurleri;
    private Random rndIslem,rndSayi;
    private int rndIslemNumber,rndSayiNumber;
    private  String soru,txtTahmin;
    private int s1,s2,s3,s4,s5,sonuc;
    private ToggleButton btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplamaislemo_main);
        islemTurleri=new ArrayList<>();
        rndIslem=new Random();
        rndSayi=new Random();
        txtSoru=(TextView)findViewById(R.id.txtSoruTo);
        editTxtTahmin=(EditText)findViewById(R.id.editTxtTahminTo);
        btn1=(ToggleButton) findViewById(R.id.toggleBtnTo);
        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    islemTurleri.add("+");
                }
                else
                {
                    islemTurleri.remove("+");

                Intent kendime=new Intent(toplamaislemoMainActivity.this,kendineGuvenActivity.class);
                startActivity(kendime);
                }

            }
        });
    }
    public void btnClickF(View v)
    {
        switch (v.getId())
        {
            case R.id.btnSoruGetirTo:
                txtSoru.setText(İslemTurunuVeSoruyuBelirle());
                break;
            case R.id.btnTahmindeBulunTo:
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
                txtSoru.setText(İslemTurunuVeSoruyuBelirle());
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
            soru+=islemTurleri.get(rndIslemNumber);

            soru+=" ";
            s3=randomSayiGetir();
            soru+=s3;
            soru+=" ";

            soru+=islemTurleri.get(rndIslemNumber);

            soru+=" ";
            s4=randomSayiGetir();
            soru+=s4;

            soru+=" ";
            soru+=islemTurleri.get(rndIslemNumber);

            soru+=" ";
            s5=randomSayiGetir();
            soru+=s5;


            switch (islemTurleri.get(rndIslemNumber))
            {
                case"+":

                    sonuc= s1+s2+s3+s4+s5;
                    break;


            }
        }
        return soru;
    }
    private int randomSayiGetir()
    {

        rndSayiNumber=rndSayi.nextInt(10)+1;


        return rndSayiNumber;
    }
}