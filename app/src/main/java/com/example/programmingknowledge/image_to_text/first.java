package com.example.programmingknowledge.image_to_text;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class first extends AppCompatActivity implements View.OnClickListener{


    ImageView image1,image2,image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        image1=findViewById(R.id.imageView4);
        image2=findViewById(R.id.imageView3);
        image3=findViewById(R.id.imageView8);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);

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
        }
    }

}
