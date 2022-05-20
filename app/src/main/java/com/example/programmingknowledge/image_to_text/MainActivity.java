package com.example.programmingknowledge.image_to_text;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;


public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    ImageView imageView;
    TextView textView;
    Bitmap bitmap;
    TextToSpeech textToSpeech;
    String sentence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Button button1=findViewById(R.id.showText);
        Button button3=findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextFromImage();
            }
        });

        textToSpeech = new TextToSpeech(this, this);

        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                click();
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
                stringBuilder.append("\n");
                sentence = String.valueOf(stringBuilder);
            }
            textView.setText(sentence);

        }
    }
    public void onInit ( int status){

        textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {

            //called when speaking starts
            @Override
            public void onStart(String utteranceId) {
                Log.i("TTS", "utterance started");
            }

            //called when speaking is finished.
            @Override
            public void onDone(String utteranceId) {
                Log.i("TTS", "utterance done");
            }

            //called when an error has occurred during processing.
            @Override
            public void onError(String utteranceId) {
                Log.i("TTS", "utterance error");
            }

            //called when the TTS service is about to speak
            //the specified range of the utterance with the given utteranceId.
            @Override
            public void onRangeStart(String utteranceId,
                                     final int start,
                                     final int end,
                                     int frame) {
                Log.i("TTS", "onRangeStart() ... utteranceId: " + utteranceId + ", start: " + start
                        + ", end: " + end + ", frame: " + frame);


                // onRangeStart (and all UtteranceProgressListener callbacks) do not run on main thread
                // so we explicitly manipulate views on the main thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Spannable textWithHighlights = new SpannableString(sentence);


                        textWithHighlights.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                        textView.setText(textWithHighlights);


                    }
                });

            }

        });

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void click() {

        textToSpeech.speak(sentence, TextToSpeech.QUEUE_FLUSH, null, "UNIQUE_UTTERANCE_ID");

    }
    @Override
    public void onDestroy() {
        //don't forget to shutdown tts
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}