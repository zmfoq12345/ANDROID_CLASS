package com.example.chapter10;
// 새로운 액티비티 사용하기 위해서는
// 1. XML 코드가 필요 (틀)
// 2. Java 클래스가 필요 (액티비티 활성화)

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

    Button finish;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        finish = (Button)findViewById(R.id.finishBtn);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
