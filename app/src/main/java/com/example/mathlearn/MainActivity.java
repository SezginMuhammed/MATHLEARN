package com.example.mathlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleTopla,toggleCarp,toggleFark,toggleBol;
    private TextView txtSoru;
    private EditText editTxtTahmin;
    private ArrayList<String> islemTurleri;
    private Random rndIslem,rndSayi;
    private int rndIslemNumber,rndSayiNumber;
    private  String soru,txtTahmin;
    private int s1,s2,sonuc;
    private Switch switchMuzik;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        islemTurleri=new ArrayList<>();
        rndIslem=new Random();
        rndSayi=new Random();
        toggleTopla=(ToggleButton)findViewById(R.id.toggleBtnTopla);
        toggleCarp=(ToggleButton)findViewById(R.id.toggleBtnCarp);
        toggleFark=(ToggleButton)findViewById(R.id.toggleBtnFark);
        toggleBol=(ToggleButton)findViewById(R.id.toggleBtnBolme);
        txtSoru=(TextView)findViewById(R.id.txtSoru);
        editTxtTahmin=(EditText)findViewById(R.id.editTxtTahmin);
        switchMuzik=(Switch)findViewById(R.id.switch1);

        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.m3);


        switchMuzik.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)

                    mediaPlayer.start();
                else
                    mediaPlayer.pause();
            }
        });



        toggleTopla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    islemTurleri.add("+");
                else
                    islemTurleri.remove("+");
            }
        });

        toggleCarp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    islemTurleri.add("*");
                else
                    islemTurleri.remove("*");

            }
        });

        toggleFark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    islemTurleri.add("-");

                else
                    islemTurleri.remove("-");

            }
        });

        toggleBol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    islemTurleri.add("/");
                else
                    islemTurleri.remove("/");
            }
        });


    }
    public void btnClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnSoruGetir:
                txtSoru.setText(İslemTurunuVeSoruyuBelirle());
                break;
             case R.id.btnTahmindeBulun:
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
            System.out.println("Girilen Değer Geçersizdir.");
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
                case"+":

                    sonuc= s1+s2;
                    break;
                case"-":
                        sonuc = s1 - s2;

                    break;
                case"*":
                    sonuc=s1*s2;
                    break;
                case"/":

                    sonuc=s1/s2;
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
