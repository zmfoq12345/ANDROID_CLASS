package com.example.a2108testintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    TextView tv, textView;
    EditText et;
    Button btn1, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2nd);

        tv = (TextView)findViewById(R.id.tv);
        et = (EditText)findViewById(R.id.text2);
        btn1 = (Button)findViewById(R.id.sendBtn1);
        btn3 = (Button)findViewById(R.id.sendBtn3);
        textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String data = String.valueOf(intent.getStringExtra("sendData1"));
        textView.setText("1번한테 받은 값은 " + data);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(getApplicationContext(),MainActivity.class);
                String str = et.getText().toString();
                send.putExtra("sendData2", str);

                setResult(RESULT_OK, send);
                finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(getApplicationContext(),ThreeActivity.class);
                String str = et.getText().toString();
                send.putExtra("sendData2", str);

                setResult(RESULT_OK, send);
                startActivityForResult(send,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            String str = "";
            String s = "";
            if (data.getStringExtra("sendData1") != null){
                str = data.getStringExtra("sendData1");
                s = "1";
            }else if (data.getStringExtra("sendData3") != null){
                str = data.getStringExtra("sendData3");
                s="3";
            }
            textView.setText(s+"번에서 돌아온 값은"+str+"야!");
        }
    }
}
