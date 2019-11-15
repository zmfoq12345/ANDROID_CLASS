package com.example.dualintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        sendBtn = (Button)findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());

                Intent send = new Intent(getApplicationContext(),SecondActivity.class);
                send.putExtra("numHap",n1+n2);

                // 양방향 액티비티 메소드
                startActivityForResult(send,0);
            }
        });
    }
    //SecondActivity 에서 내용을 받기위해 메서드 오버라이딩

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            String str = data.getStringExtra("sendData");
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        }
    }
}
