package com.example.implied_intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button callBtn, webBtn, mapBtn, camBtn;
    double lat =  35.14321727233706, lng =  126.79993172182658 ;
    String school = "광주소프트웨어마이스터고등학교";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callBtn = (Button) findViewById(R.id.Callbtn);
        webBtn = (Button) findViewById(R.id.Webbtn);
        mapBtn = (Button) findViewById(R.id.Mapbtn);
        camBtn = (Button) findViewById(R.id.Cambtn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(getApplication..) .. 명시적
                // 묵시적(암시적) 인텐트
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012341234"));
                startActivity(callIntent);

            }
        });

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webUri = Uri.parse("https://www.gsm.hs.kr");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
                startActivity(webIntent);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapUri = Uri.parse("http://maps.google.com/maps?q=" + school);//lat + "," + lng);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(mapIntent);
            }
        });

        camBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivity(camIntent);
            }
        });

    }
}
