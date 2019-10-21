package com.example.jjapkaotalk21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {
    LinearLayout menuLayout;
    TextView friName, friCondition;
    boolean b = true;
    String s = "123";
    TextView fri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuLayout = (LinearLayout)findViewById(R.id.friend);
        friName = (TextView)findViewById(R.id.friendName);
        fri = (TextView)findViewById(R.id.title);
        registerForContextMenu(menuLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInf = getMenuInflater();
        mInf.inflate(R.menu.menu1, menu);
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater contextMInf = getMenuInflater();
        if (v == menuLayout) contextMInf.inflate(R.menu.holding, menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//
//        }
//
//        return true;
//    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.star:
                // 커스텀 대화상자 만들기 (xml레이아웃 파일을 팝업 처럼 띄우기
                // condition_message - inflating (뷰에 대한 객체화)
                final View conditionView = (View)View.inflate(
                        MainActivity.this,
                               R.layout.activity_condition_message,//Resource
                        null);
                final AlertDialog.Builder changeDialog = new AlertDialog.Builder(MainActivity.this);

                // AlertDialog의 메서드 중 setView();
                changeDialog.setView(conditionView);
                changeDialog.setNegativeButton("Cancel", null);
                changeDialog.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // To-Do
                        // 보고싶은 위젯 : EditText
                        // 저 EditText는 activity_condition_message에 있음 즉, 다른 activity에 있음
                        EditText et = (EditText)conditionView.findViewById(R.id.conditionBox);
                        friCondition = (TextView)findViewById(R.id.friend_condition);
                        friCondition.setText(et.getText().toString());
                    }
                });
                changeDialog.show();
                return true;

                // 즐겨찾기
//                if(s=="123")
//                    s = friName.getText().toString();
//                if (b) {
//                    friName.setText(friName.getText().toString()+"★");
//                    b = false;
//                }else {
//                    friName.setText(s);
//                    b = true;
//                }
//                return true;

            case R.id.del:
                // 팝업창처럼 사용가능한 "대화상자"를 만들어보자.
                AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
                delDialog.setTitle("대화상자의 이름");
                delDialog.setMessage("진짜 " + s + "님을 손절 하시겠습니까?");

                delDialog.setNegativeButton("Cancel", null);
                delDialog.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //To-do
                        fri.setText("친구가 1명도 없는 짭카오톡");
                        menuLayout.setVisibility(GONE);
                    }
                });
                delDialog.show();
                return true;
        }
        return false;
    }
}
