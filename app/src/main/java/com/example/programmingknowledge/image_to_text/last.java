package com.example.programmingknowledge.image_to_text;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class last extends AppCompatActivity implements View.OnClickListener {

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView mVoiceInputTv;
    private ImageButton mSpeakBtn;
    TextToSpeech textToSpeech;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                    textToSpeech.speak("congratulations! You have completed the exercise!!",TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
        image=findViewById(R.id.imageView10);
        image.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.imageView10:
                startActivity(new Intent(this, first.class));
                break;


        }
    }


}
