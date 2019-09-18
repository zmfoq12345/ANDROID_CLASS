package com.example.androidclass_0910;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 1. xml에서 선언된 TextView를
    // 연결해주기 위한 변수 선언
    TextView textview1, textview2,textview3;
    Button btn;
    boolean ck = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview1 = (TextView)findViewById(R.id.tv1);
        textview2 = (TextView)findViewById(R.id.tv2);
        textview3 = (TextView)findViewById(R.id.tv3);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ck){
                    textview1.setText("바꿨습니다!.");
                    textview2.setAllCaps(ck);
                    textview3.setText("대문자");
                    ck = false;
                }else{
                    textview1.setText("바꿨어요!.");
                    textview2.setAllCaps(ck);
                    textview3.setText("소문자");
//                    textview3.setTextColor(Integer.parseInt("#0404B4"));
                    ck = true;
                }
            }
        });



    }

}
