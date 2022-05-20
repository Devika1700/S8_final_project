package com.example.programmingknowledge.image_to_text;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class pract2 extends AppCompatActivity implements View.OnClickListener{

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView mVoiceInputTv;
    private ImageButton mSpeakBtn;
    ImageView image1,image2,image3,image4,image5,image6,image7;
    TextToSpeech textToSpeech;
    MediaPlayer playNoise;
    MediaPlayer playNoise2;
    MediaPlayer playNoise3;
    MediaPlayer playNoise4;
    MediaPlayer playNoise5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pract2);
        image1=findViewById(R.id.imageView5);
        image2=findViewById(R.id.imageView19);
        image3=findViewById(R.id.imageView20);
        image4=findViewById(R.id.imageView21);
        image6=findViewById(R.id.imageView22);
        image5=findViewById(R.id.imageView16);
        image7=findViewById(R.id.imageView15);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);
        image7.setOnClickListener(this);
        image5.setVisibility(View.INVISIBLE);
        mVoiceInputTv = (TextView) findViewById(R.id.voiceInput);
        mSpeakBtn = (ImageButton) findViewById(R.id.btnSpeak);
        mSpeakBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        });

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

    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final MediaPlayer clap = MediaPlayer.create(this, R.raw.clap);
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mVoiceInputTv.setText(result.get(0));

                }
                break;
            }

        }
        String input=mVoiceInputTv.getText().toString();
        String[] lines=input.split("\n");
        if(input.equals("pony")) {
            image5.setVisibility(View.VISIBLE);
            if(playNoise4==null){
                playNoise4= MediaPlayer.create(this,R.raw.sparkle);
            }
            playNoise4.start();

        }
        else {
            textToSpeech.speak("Try again!!",TextToSpeech.QUEUE_FLUSH,null);
        }
    }
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.imageView5:
                startActivity(new Intent(this, pract3.class));
                break;

            case R.id.imageView15:
                startActivity(new Intent(this, pract1.class));
                break;

            case R.id.imageView19:
                if(playNoise==null){
                    playNoise= MediaPlayer.create(this,R.raw.p);
                }
                playNoise.start();
                break;

            case R.id.imageView20:
                if(playNoise2==null){
                    playNoise2= MediaPlayer.create(this,R.raw.o);
                }
                playNoise2.start();
                break;

            case R.id.imageView21:
                if(playNoise3==null){
                    playNoise3= MediaPlayer.create(this,R.raw.n);
                }
                playNoise3.start();
                break;

            case R.id.imageView22:
                if(playNoise4==null){
                    playNoise4= MediaPlayer.create(this,R.raw.y);
                }
                playNoise4.start();
                break;
        }
    }
}
