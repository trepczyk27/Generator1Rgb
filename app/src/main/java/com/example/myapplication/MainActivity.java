package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SeekBar red, green, blue;
    private ImageView zdjecie;
    private int r = 0, g = 0, b = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.s1);
        green = findViewById(R.id.s2);
        blue = findViewById(R.id.s3);
        zdjecie = findViewById(R.id.txt2);

        red.setMax(255);
        green.setMax(255);
        blue.setMax(255);




        ImageView zdjecie =(ImageView) findViewById(R.id.txt2);
        zdjecie.setImageResource(R.drawable.images);


        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                r = progress;
                ustawKolor(r, g, b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                g = progress;
                ustawKolor(r, g, b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b = progress;
                ustawKolor(r, g, b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void ustawKolor(int r, int g, int b){
        zdjecie.setBackgroundColor(Color.rgb(r, g, b));
    }


}