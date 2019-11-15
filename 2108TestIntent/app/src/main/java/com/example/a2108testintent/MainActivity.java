package com.example.a2108testintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText text;
    Button sendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.text);
        sendBtn = (Button)findViewById(R.id.sendBtn);
        textView = (TextView) findViewById(R.id.textView);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = text.getText().toString();

                Intent send = new Intent(getApplicationContext(),SecondActivity.class);
                send.putExtra("sendData1", str);

                startActivityForResult(send,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            String str = data.getStringExtra("sendData2");
            textView.setText("넘어온 값은"+str+"야!");
        }
    }
}
