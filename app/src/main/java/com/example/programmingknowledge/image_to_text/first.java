package com.example.programmingknowledge.image_to_text;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class first extends AppCompatActivity implements View.OnClickListener{


    ImageView image1,image2,image3,image4,image5;

    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        image1=findViewById(R.id.imageView4);
        image2=findViewById(R.id.imageView3);
        image3=findViewById(R.id.imageView8);
        image4=findViewById(R.id.imageView9);
        image5=findViewById(R.id.imageView10);
        image5.setOnClickListener(this);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.US);

                }

            }
        });

    }
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.imageView4:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.imageView3:
                startActivity(new Intent(this,speech.class));
                break;

            case R.id.imageView8:
                startActivity(new Intent(this,phonics.class));
                break;

            case R.id.imageView9:
                textToSpeech.speak("Can you write number 1",TextToSpeech.QUEUE_FLUSH,null);
                startActivity(new Intent(this,number.class));
                break;

            case R.id.imageView10:
                startActivity(new Intent(this,Dictionary.class));
                break;

        }
    }

}
