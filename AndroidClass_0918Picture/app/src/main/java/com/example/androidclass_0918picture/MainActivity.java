package com.example.androidclass_0918picture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView img = (ImageView)findViewById(R.id.img);
        Switch sw = (Switch)findViewById(R.id.switch1);
        final Animation animTransAlpha = AnimationUtils.loadAnimation(
                this,R.anim.anim_translate_alpha);

//        LinearLayout l =(LinearLayout)findViewById(R.id.main);

        final RadioButton r1 = (RadioButton)findViewById(R.id.IRONMAN);
        final RadioButton r2 = (RadioButton)findViewById(R.id.CAPTAIN);
        final RadioButton r3 = (RadioButton)findViewById(R.id.THOR);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    r1.setVisibility(View.VISIBLE);
                    r2.setVisibility(View.VISIBLE);
                    r3.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }
                else {
                    r1.setVisibility(View.INVISIBLE);
                    r2.setVisibility(View.INVISIBLE);
                    r3.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    img.startAnimation(animTransAlpha);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            img.setImageResource(R.drawable.img1);
                        }
                    }, 500);

                    Toast.makeText(getApplicationContext(), "I AM IRONMAN", Toast.LENGTH_SHORT).show();
                }
            }
        });


        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    img.startAnimation(animTransAlpha);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            img.setImageResource(R.drawable.img2);
                        }
                    }, 500);

                    Toast.makeText(getApplicationContext(), "I CAN DO THIS ALL DAY", Toast.LENGTH_SHORT).show();
                }
            }
        });


        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){

                    img.startAnimation(animTransAlpha);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            img.setImageResource(R.drawable.img3);
                        }
                    }, 500);

                    Toast.makeText(getApplicationContext(), "I'M SON OF ODIN", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
