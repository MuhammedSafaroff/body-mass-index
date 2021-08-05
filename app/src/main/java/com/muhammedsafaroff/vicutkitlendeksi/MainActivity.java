package com.muhammedsafaroff.vicutkitlendeksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView boy_tv,durum_tv,ideal_tv,kilo_tv;
    private SeekBar seekBar;
    private RadioGroup radioGroup;
    private boolean erkekmi=true;
    private double boy=0.0;
    private int kilo=50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editText = (EditText) findViewById(R.id.editText);
         boy_tv=(TextView) findViewById(R.id.boy);
         durum_tv =(TextView) findViewById(R.id.durum);
         ideal_tv =(TextView) findViewById(R.id.ideal);
         kilo_tv =(TextView) findViewById(R.id.kilo);
         seekBar =(SeekBar) findViewById(R.id.seek);
         radioGroup =(RadioGroup) findViewById(R.id.radiogroup);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    boy=(Double.parseDouble(s.toString())/100.0);

                }catch (NumberFormatException e){
                    boy=0.0;
                }
                guncelle();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                kilo=30+progress;
                guncelle();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.bay){
                    erkekmi=true;
                }else if(checkedId==R.id.bayan){
                    erkekmi=false;
                }
                guncelle();
            }
        });



        guncelle();


    }

    private void guncelle() {
        int idealBay = (int) (50+2.3*( boy*100*0.4 - 60 ));
        int idealBayan = (int) (45.5+2.3*( boy*100*0.4 - 60 ));
        double endeks=kilo/(boy*boy);

        if (erkekmi){
            ideal_tv.setText(String.valueOf(idealBay));
            if(endeks<18.5){
                durum_tv.setBackgroundResource(R.color.zayif);
                durum_tv.setText(R.string.zayif);
                //zayif
            }else if(18.5<=endeks && endeks<=24.9){
                //normal kilolu
                durum_tv.setBackgroundResource(R.color.normal);
                durum_tv.setText(R.string.normal);

            }else if(24.9<endeks && endeks<=29.9){
                //fazla kilolu
                durum_tv.setBackgroundResource(R.color.fazla);
                durum_tv.setText(R.string.fazla);

            }else if(29.9<endeks && endeks<=34.9){
                //I. derece obez
                durum_tv.setBackgroundResource(R.color.obez1);
                durum_tv.setText(R.string.obez1);

            }else if(34.9<endeks && endeks<=39.9){
                //II. derece obez
                durum_tv.setBackgroundResource(R.color.obez2);
                durum_tv.setText(R.string.obez2);

            }else if(39.9<endeks){
                //III. derece morbid obez
                durum_tv.setBackgroundResource(R.color.obez3);
                durum_tv.setText(R.string.obez3);

            }

        }else {
            ideal_tv.setText(String.valueOf(idealBayan));
            if(endeks<18.5){
                durum_tv.setBackgroundResource(R.color.zayif);
                durum_tv.setText(R.string.zayif);
                //zayif
            }else if(18.5<=endeks && endeks<=24.9){
                //normal kilolu
                durum_tv.setBackgroundResource(R.color.normal);
                durum_tv.setText(R.string.normal);

            }else if(24.9<endeks && endeks<=29.9){
                //fazla kilolu
                durum_tv.setBackgroundResource(R.color.fazla);
                durum_tv.setText(R.string.fazla);

            }else if(29.9<endeks && endeks<=34.9){
                //I. derece obez
                durum_tv.setBackgroundResource(R.color.obez1);
                durum_tv.setText(R.string.obez1);

            }else if(34.9<endeks && endeks<=39.9){
                //II. derece obez
                durum_tv.setBackgroundResource(R.color.obez2);
                durum_tv.setText(R.string.obez2);

            }else if(39.9<endeks){
                //III. derece morbid obez
                durum_tv.setBackgroundResource(R.color.obez3);
                durum_tv.setText(R.string.obez3);

            }
        }

        kilo_tv.setText(String.valueOf(kilo)+" kg");
        boy_tv.setText(String.valueOf(boy)+" m");

    }
}
