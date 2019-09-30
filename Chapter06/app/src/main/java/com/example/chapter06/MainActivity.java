package com.example.chapter06;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
//viewFlipper

    Button btn1, btn2;
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewflipper);

        btn1 = (Button)findViewById(R.id.b1);
        btn2 = (Button)findViewById(R.id.b2);
        vf = (ViewFlipper)findViewById(R.id.ViewFlipper);

//      <-버튼 정의
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                vf.setFlipInterval(250);
//                vf.startFlipping();
                vf.showPrevious();
            }
        });

//      ->버튼 정의
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.showNext();
//                vf.stopFlipping();
            }
        });


    }
}



//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_slidingdrawer);
//    }
//}
















