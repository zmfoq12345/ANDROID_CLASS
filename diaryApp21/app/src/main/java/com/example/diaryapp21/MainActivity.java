package com.example.diaryapp21;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String str;
    // 위젯의 배치 순서대로 변수 선언
    EditText year, month, day;
    Button writeMode, readMode;
    byte[] txt = new byte[3000];

    // inputDiary, writeOrInsert는 writeView에 속한 위젯들
    LinearLayout writeView;
    EditText inputDiary;
    Button writeOrInsert;

    // outputDiary는 readView에 속한 위젯들
    LinearLayout readView;
    TextView outputDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        year = (EditText) findViewById(R.id.year);
        month = (EditText) findViewById(R.id.month);
        day = (EditText) findViewById(R.id.day);

        writeMode = (Button) findViewById(R.id.writeMode);
        readMode = (Button) findViewById(R.id.readMode);

        writeView = (LinearLayout) findViewById(R.id.writeView);
        inputDiary = (EditText) findViewById(R.id.inputDiary);
        writeOrInsert = (Button) findViewById(R.id.writeOrInsert);

        readView = (LinearLayout) findViewById(R.id.readView);
        outputDiary = (TextView) findViewById(R.id.outputDiary);

        writeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 날짜가 충분하게 채워지지 않은 경우
                if (!isInputDate()) {
                    Toast.makeText(MainActivity.this, "년, 월, 일을 채워주세요", Toast.LENGTH_LONG).show();
                } else {
                    // writeView만 화면에 표시되게 한다.
                    writeView.setVisibility(View.VISIBLE);
                    readView.setVisibility(View.GONE);
                    inputDiary.setText("");
                    try {
                        // 버퍼가 처리하는 방식과 비슷함
                        // 한 번에 최대한 읽어들일 수 있는 최대한의 byte수 지정
                        // 작은 byte 단위로 나워 읽어들일 경우
                        // 예상치 못한 글자 깨짐이 발생할 수 있다. (한글)
                        FileInputStream inFs = openFileInput(
                                year.getText().toString()+
                                        month.getText().toString()+
                                        day.getText().toString() +".txt");
                        byte[] txt = new byte[3000];
                        inFs.read(txt);
                        str = new String(txt);
                        inputDiary.setText(str);
                        inFs.close();
                    } catch (FileNotFoundException e) {
                        // 파일을 찾지 못했을 때의 예외처리 부분
                    }catch (IOException e) {
                        // 입출력에 대한 예외 처리
                    }
                }
            }
        });

        readMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 날짜가 충분하게 채워지지 않은 경우
                if (!isInputDate()) {
                    Toast.makeText(MainActivity.this, "년, 월, 일을 채워주세요", Toast.LENGTH_LONG).show();
                } else {
                    // readView만 화면에 표시되게 한다.
                    writeView.setVisibility(View.GONE);
                    readView.setVisibility(View.VISIBLE);
                    try {
                        // 버퍼가 처리하는 방식과 비슷함
                        // 한 번에 최대한 읽어들일 수 있는 최대한의 byte수 지정
                        // 작은 byte 단위로 나워 읽어들일 경우
                        // 예상치 못한 글자 깨짐이 발생할 수 있다. (한글)
                        outputDiary.setText("");
                        FileInputStream inFs = openFileInput(
                                year.getText().toString()+
                                        month.getText().toString()+
                                        day.getText().toString() +".txt");
                        byte[] txt = new byte[3000];
                        inFs.read(txt);
                        str = new String(txt);
                        outputDiary.setText(str, TextView.BufferType.EDITABLE);
                        inFs.close();
                    } catch (FileNotFoundException e) {
                        // 파일을 찾지 못했을 때의 예외처리 부분
                    }catch (IOException e) {
                        // 입출력에 대한 예외 처리
                    }
                }
            }
        });

        writeOrInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput(
                            year.getText().toString()+
                                    month.getText().toString()+
                                    day.getText().toString() +".txt", MODE_PRIVATE);
                    str = inputDiary.getText().toString();

                    if (str == ""){
                        Toast.makeText(MainActivity.this, "일기를 써주세요!!", Toast.LENGTH_SHORT).show();
                    }else{
                        outFs.write(str.getBytes());
                        outFs.close();
                        Toast.makeText(MainActivity.this, "저장완료!!", Toast.LENGTH_SHORT).show();
                    }return;

                } catch (FileNotFoundException e) {
                    // 파일을 찾지 못했을 때의 예외처리 부분
                } catch (IOException e) {
                    // 입출력에 대한 예외 처리
                }
            }
        });
    }


    boolean isInputDate() {
        // 년, 월, 일 EditText가 모두 작성된 경우에만 true 반환
        boolean a = year.getText().toString().equals("");
        boolean b = month.getText().toString().equals("");
        boolean c = day.getText().toString().equals("");
        return (!a) && (!b) && (!c);
    }
}