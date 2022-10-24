package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    private SeekBar red, green, blue, seek4, seek5, seek6;
    private ImageView zdjecie;
    private ImageView zdjecie2;
    private Button button2,button1;
    int baseHeight = 300;
    int baseWidth = 300;
    private int r = 0, g = 0, b = 0;


    private final int GALLERY_REQ_CODE = 1000;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.s1);
        green = findViewById(R.id.s2);
        blue = findViewById(R.id.s3);
        seek4 = findViewById(R.id.s4);
        seek5 = findViewById(R.id.s5);
        seek6 = findViewById(R.id.s6);
        button2=findViewById(R.id.b2);
        button1=findViewById(R.id.b1);
        zdjecie = findViewById(R.id.txt2);
        zdjecie2 = findViewById(R.id.txt3);
        red.setMax(255);
        green.setMax(255);
        blue.setMax(255);


        Button btnGallery = findViewById(R.id.losuj);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, GALLERY_REQ_CODE);


            }
        });

      button1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              zdjecie.setRotation(zdjecie.getRotation()+90);
          }
      });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zdjecie.setRotation(zdjecie.getRotation()-90);
            }
        });
        zdjecie = (ImageView) findViewById(R.id.txt2);
        zdjecie.setImageResource(R.drawable.images);

        zdjecie2 = (ImageView) findViewById(R.id.txt3);

        seek5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                zdjecie.getLayoutParams().height = baseHeight * seek5.getProgress();
                zdjecie.requestLayout();
            }
        });
        seek6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                zdjecie.getLayoutParams().width = baseWidth * seek6.getProgress();
                zdjecie.requestLayout();
            }
        });
        seek4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                zdjecie.setColorFilter((Color.argb(seek4.getProgress(), red.getProgress(), green.getProgress(), blue.getProgress())));
            }
        });
        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                zdjecie.setColorFilter((Color.argb(seek4.getProgress(), red.getProgress(), green.getProgress(), blue.getProgress())));
            }
        });
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                zdjecie.setColorFilter((Color.argb(seek4.getProgress(), red.getProgress(), green.getProgress(), blue.getProgress())));
            }
        });
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                zdjecie.setColorFilter((Color.argb(seek4.getProgress(), red.getProgress(), green.getProgress(), blue.getProgress())));
            }
        });
    }


    public void ustawKolor(int r, int g, int b){
        zdjecie2.setBackgroundColor(Color.rgb(r, g, b));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                zdjecie.setImageURI(data.getData());
            }
        }

    }
}