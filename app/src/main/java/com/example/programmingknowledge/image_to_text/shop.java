package com.example.programmingknowledge.image_to_text;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class shop extends AppCompatActivity implements View.OnClickListener{


    ImageView image1,image2,image3,image4,image5,image6,image7;
    TextToSpeech textToSpeech;
    MediaPlayer playNoise;
    MediaPlayer playNoise2;
    MediaPlayer playNoise3;
    MediaPlayer playNoise4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        image1=findViewById(R.id.imageView9);
        image2=findViewById(R.id.imageView11);
        image3=findViewById(R.id.imageView12);
        image4=findViewById(R.id.imageView13);
        image5=findViewById(R.id.imageView15);
        image6=findViewById(R.id.imageView14);
        image7=findViewById(R.id.imageView16);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);
        image7.setOnClickListener(this);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

    }
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.imageView9:
                textToSpeech.speak("SHOP",TextToSpeech.QUEUE_FLUSH,null);

                break;

            case R.id.imageView11:
                if(playNoise==null){
                    playNoise= MediaPlayer.create(this,R.raw.sh);
                }
                playNoise.start();
                break;

            case R.id.imageView12:
                if(playNoise2==null){
                    playNoise2= MediaPlayer.create(this,R.raw.sh);
                }
                playNoise2.start();
                break;

            case R.id.imageView13:
                if(playNoise3==null){
                    playNoise3= MediaPlayer.create(this,R.raw.o);
                }
                playNoise3.start();
                break;


            case R.id.imageView16:
                if(playNoise4==null){
                    playNoise4= MediaPlayer.create(this,R.raw.p);
                }
                playNoise4.start();
                break;

            case R.id.imageView15:
                startActivity(new Intent(this,level.class));
                break;

            case R.id.imageView14:
                startActivity(new Intent(this,chop.class));
                break;
        }
    }



}
