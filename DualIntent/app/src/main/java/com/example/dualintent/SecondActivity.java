package com.example.dualintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView tv;
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2nd);

        tv = (TextView)findViewById(R.id.data);
        et = (EditText)findViewById(R.id.intent2nd);
        btn = (Button)findViewById(R.id.returnBtn);

        Intent intent = getIntent();
        String hap = String.valueOf(intent.getIntExtra("numHap", 0));
        tv.setText("MainActivity로부터 넘겨받은 값은 " + hap);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(getApplicationContext(),MainActivity.class);
                String str = et.getText().toString();
                send.putExtra("sendData", str);

                setResult(RESULT_OK, send);
                finish();
            }
        });
    }
}
