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

public class ThreeActivity extends Activity {

    EditText text3;
    Button sendBtn2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3rd);

        text3 = (EditText)findViewById(R.id.text3);
        sendBtn2 = (Button)findViewById(R.id.sendBtn2);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String data = String.valueOf(intent.getStringExtra("sendData2"));
        textView.setText("2번한테 받은 값은 " + data);

        sendBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = text3.getText().toString();

                Intent send = new Intent(getApplicationContext(),SecondActivity.class);
                send.putExtra("sendData3", str);

                setResult(RESULT_OK, send);
                finish();
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
