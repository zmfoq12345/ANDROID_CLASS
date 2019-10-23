package com.example.Chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chapter08.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText inputArea;
    Button write, read;
    TextView outputArea;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputArea = (EditText)findViewById(R.id.inputArea);
        write = (Button)findViewById(R.id.write);
        read = (Button)findViewById(R.id.read);
        outputArea = (TextView)findViewById(R.id.outputArea);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 파일을 생성하는 내용
                // 파일입출력 FileInput(output)Stream
                // 이라는 클래스를 이용합니다.
                // 파일 저장경로 data/data/패키지명/files 폴더
                try {
                    FileOutputStream outFs = openFileOutput("file.txt", MODE_PRIVATE);
                    str = inputArea.getText().toString();

                    if (str == ""){
                        Toast.makeText(MainActivity.this, "내용을 입력하세요!!", Toast.LENGTH_SHORT).show();
                    }else{
                        outFs.write(str.getBytes());
                        outFs.close();
                    }return;

                } catch (FileNotFoundException e) {
                    // 파일을 찾지 못했을 때의 예외처리 부분
                } catch (IOException e) {
                    // 입출력에 대한 예외 처리
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // 버퍼가 처리하는 방식과 비슷함
                    // 한 번에 최대한 읽어들일 수 있는 최대한의 byte수 지정
                    // 작은 byte 단위로 나워 읽어들일 경우
                    // 예상치 못한 글자 깨짐이 발생할 수 있다. (한글)
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[3000];
                    inFs.read(txt);
                    str = new String(txt);
                    outputArea.setText(str);
                    inFs.close();
                } catch (FileNotFoundException e) {
                    // 파일을 찾지 못했을 때의 예외처리 부분
                }catch (IOException e) {
                    // 입출력에 대한 예외 처리
                }
            }
        });
    }


}
