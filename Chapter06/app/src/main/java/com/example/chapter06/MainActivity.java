package com.example.chapter06;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button move, prev;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        url = (EditText)findViewById(R.id.urlText);
        move = (Button)findViewById(R.id.move);
        prev = (Button)findViewById(R.id.back);
        web = (WebView)findViewById(R.id.web);

        // 2. (1)에서 생성한 클래스를 생성하여 webview에 연결

        web.setWebViewClient(new WebViewTestClient());

        // 부가기능
        // webSettings 클래스에 웹뷰의 설정값을 가져오고
        // 여러 기능을 추가 할 수 있다. 돋보기 - 확대 축소 기능 - 만 적용
        WebSettings webset = web.getSettings();
        webset.setBuiltInZoomControls(true);

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(url.getText().toString());
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.goBack();
            }
        });
    }

    // 1. 클래스 생성 webViewClient를 상속받는
    class WebViewTestClient extends WebViewClient
    {
        // WebViewClient 클래스를 상속받았는ㄷ, 이 클래스에서
        // 필요한 메소드를 오버라이딩하여 사용하자.
        // 다 외우진 말고 Android Studio 에서 제공하는 기능사용
        // 클래스 내부에 커서를 놓고 [code] - [Override Methods] - [shouldOverrideUrlLoading] 선택


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}

//@SuppressWarnings("deprecation")
//public class MainActivity extends TabActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tabhost);
//
//
//        // 1. xml에서 생성한 탭호스트
//        // (@android:id/tabhost 로 id를 지정한 탭 호스트)
//        // 를 가져옴
//
//        TabHost tab = getTabHost();
//
//        // 2. 탭 위젯에 필요한 내용을 등록한다.
//        // 아래의 세 줄을 반복해서 필요한 만큼 등록
//        TabHost.TabSpec redTab = tab.newTabSpec("red").setIndicator("빨간색 탭");
//        redTab.setContent(R.id.tab1);
//        tab.addTab(redTab);
//
//        TabHost.TabSpec blueTab = tab.newTabSpec("blue").setIndicator("파랑색 탭");
//        blueTab.setContent(R.id.tab2);
//        tab.addTab(blueTab);
//
//        TabHost.TabSpec greenTab = tab.newTabSpec("green").setIndicator("초록색 탭");
//        greenTab.setContent(R.id.tab3);
//        tab.addTab(greenTab);
//
//        // 탭호스트를 activity에 띄우기 위한 코드
//        tab.setCurrentTab(0);
//    }
//}


//public class MainActivity extends AppCompatActivity {
////viewFlipper
//
//    Button btn1, btn2;
//    ViewFlipper vf;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_viewflipper);
//
//        btn1 = (Button)findViewById(R.id.b1);
//        btn2 = (Button)findViewById(R.id.b2);
//        vf = (ViewFlipper)findViewById(R.id.ViewFlipper);
//
////      <-버튼 정의
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                vf.setFlipInterval(250);
////                vf.startFlipping();
//                vf.showPrevious();
//            }
//        });
//
////      ->버튼 정의
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                vf.showNext();
////                vf.stopFlipping();
//            }
//        });
//
//
//    }
//}

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
















