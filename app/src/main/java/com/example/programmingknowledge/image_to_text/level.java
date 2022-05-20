package com.example.programmingknowledge.image_to_text;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class level extends AppCompatActivity implements View.OnClickListener{


    Button btn1,btn2,btn3;
    ImageView image4;
    TextToSpeech textToSpeech;
    MediaPlayer playNoise;
    MediaPlayer playNoise2;
    MediaPlayer playNoise3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
        btn1=(Button) findViewById(R.id.learn_btn);
        btn1.setOnClickListener(this);
        btn2=(Button) findViewById(R.id.practice_btn);
        btn2.setOnClickListener(this);
        btn3=(Button) findViewById(R.id.home_btn3);
        btn3.setOnClickListener(this);
        image4=findViewById(R.id.imageView15);
        image4.setOnClickListener(this);

    }
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.learn_btn:
                startActivity(new Intent(this,cat.class));
                break;

            case R.id.practice_btn:
                startActivity(new Intent(this,pony.class));
                break;

            case R.id.home_btn3:
                startActivity(new Intent(this,owl.class));
                break;

            case R.id.imageView15:
                startActivity(new Intent(this,phonics.class));
                break;
        }
    }



}
