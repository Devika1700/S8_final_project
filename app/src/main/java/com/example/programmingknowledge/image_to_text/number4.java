package com.example.programmingknowledge.image_to_text;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.util.Locale;

public class number4 extends AppCompatActivity {
    ImageView imageView,imageView2;
    TextView textView;
    Bitmap bitmap;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number4);

        Button button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        imageView2=findViewById(R.id.gif);
        textView=(TextView) findViewById(R.id.output);
        Button button1=findViewById(R.id.showText);
        imageView2.setVisibility(View.INVISIBLE);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextFromImage();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bitmap=(Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }
    public  void  getTextFromImage(){
        //Bitmap bitmap= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.id.imageView);
        TextRecognizer textRecognizer=new TextRecognizer.Builder(getApplicationContext()).build();
        if(!textRecognizer.isOperational()){
            Toast.makeText(getApplicationContext(),"Could Not Detect Text",Toast.LENGTH_SHORT);
        }
        else{
            Frame frame=new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> sparseArray=textRecognizer.detect(frame);
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<sparseArray.size();i++)
            {
                TextBlock textBlock=sparseArray.valueAt(i);
                stringBuilder.append(textBlock.getValue());
                //stringBuilder.append("\n");
                textView.setText(stringBuilder.toString());
            }

            String input=textView.getText().toString();
            if(input.equals("4")) {
                textToSpeech.speak("correct! Good Job!!",TextToSpeech.QUEUE_FLUSH,null);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textToSpeech.speak("Can you write number 5",TextToSpeech.QUEUE_FLUSH,null);
                        startActivity(new Intent(getApplicationContext(),number5.class));
                    }
                },3000);

            }
            else
            {
                imageView2.setVisibility(View.VISIBLE);
            }


        }
    }
}
