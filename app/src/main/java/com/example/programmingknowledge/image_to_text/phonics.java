package com.example.programmingknowledge.image_to_text;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class phonics extends AppCompatActivity{


    ImageView image1,image2,image3,image4;
    TextToSpeech textToSpeech;
    MediaPlayer playNoise;
    MediaPlayer playNoise2;
    MediaPlayer playNoise3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonics);


    }




}
