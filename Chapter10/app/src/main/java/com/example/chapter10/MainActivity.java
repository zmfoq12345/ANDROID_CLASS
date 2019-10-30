package com.example.chapter10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int QuestionLEN = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("정답률 45%를 자랑하는 마의 2번 문제");

        final int voteCnt[] = new int[QuestionLEN];
        RadioButton num[] = new RadioButton[QuestionLEN];
        Integer numId[] = {R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5};
        Button resume = (Button)findViewById(R.id.resume);

        for (int i = 0; i < QuestionLEN; i++) {
            final int idx = i;
            num[idx] = (RadioButton)findViewById(numId[idx]);
            num[idx].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCnt[idx]++;
                    Toast.makeText(getApplication(), (idx+1)+"번을 찍었습니다.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResumeActivity.class);
                // putExtra를 통해 박스포장해서 데이터를 넘겨줄 수 있다.
                intent.putExtra("CountInfo", voteCnt/*int 배열*/);
                startActivity(intent);
            }
        });

    }

}


/*
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
                {
                    // 새로운 액티비티를 띄워주기 위한 코드들..
                    // Intent라는 걸 활용 - 4대 컴포넌트들:
                    // (액티비티, 서비스, 콘텐트프로바이더, 브로드리시버)
                    // 들이 서로 데이터를 주고받기 위해 사용하는 메시지 객체

                    // 1. getApplicationContext(), [Java파일명].class
                    // Context = 어떤 Activity나 Application인지를 '구별'하는 정보
                    // getApplicationContext() = MainActivity.this
                }
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
 */
