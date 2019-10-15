package com.example.chapter07;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

// 메뉴를 포함시키기 위해 Java 코딩에서 필요한 것
// 1. onCreateOptionsMenu() 메소드 ~ 오버라이딩
// 2. onOptionsItemSelected() 메소드 ~ 오버라이딩
public class MainActivity extends AppCompatActivity {

    // 메뉴의 각 기능들을 선택했을 때 연동될 수 있도록...
    LinearLayout menuLayout;
    TextView menuTextView;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        menuLayout = (LinearLayout) findViewById(R.id.baseLayout);
        menuTextView = (TextView) findViewById(R.id.textView);
        menuButton = (Button) findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 자동완성된 내용을 아래와 같이 바꿔주세요
        super.onCreateOptionsMenu(menu);

        // 인플레이터 (Inflater)
        // 정적으로 존재하는 XML파일을 Java코드에서 사용하기
        // MenuInflater, (LayoutInflater 등 등 등... 이 존재)

        MenuInflater mInf = getMenuInflater();
        mInf.inflate(R.menu.menu1, menu); // R.menu.menu1(메뉴xml이름), menu(형식)
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // switch case로 각 메뉴들의 기능 구현
        // item.getItemId()
        switch (item.getItemId()) {
            case R.id.setBgBlack:
                menuLayout.setBackgroundColor(Color.BLACK);
                return true;

            case R.id.setBgRed:
                menuLayout.setBackgroundColor(Color.RED);
                return true;
]
            case R.id.ChangeTextView:
                menuTextView.setText("텍스트뷰의 내용을 변경함");
                return true;

            case R.id.ChangeButton:
                menuButton.setRotation(30);
                // Toast  간단한 알림  (어디에, 무슨내용, 길이)
                Toast msg = Toast.makeText(MainActivity.this, "띠용!", Toast.LENGTH_LONG);
                msg.show();
                return true;
        }
        return true;
    }
}

//// MainActivity 기본 형태 복사본
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}