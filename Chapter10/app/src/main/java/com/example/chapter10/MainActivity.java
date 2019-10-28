package com.example.chapter10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button moveXml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveXml = (Button)findViewById(R.id.moveXml);

        moveXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 새로운 액티비티를 띄워주기 위한 코드들..
                // Intent라는 걸 활용 - 4대 컴포넌트들:
                // (액티비티, 서비스, 콘텐트프로바이더, 브로드리시버)
                // 들이 서로 데이터를 주고받기 위해 사용하는 메시지 객체

                // 1. getApplicationContext(), [Java파일명].class
                // Context = 어떤 Activity나 Application인지를 '구별'하는 정보
                // getApplicationContext() = MainActivity.this
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}