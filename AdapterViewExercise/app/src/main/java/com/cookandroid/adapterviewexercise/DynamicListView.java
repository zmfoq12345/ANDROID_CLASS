package com.cookandroid.adapterviewexercise;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DynamicListView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_listview);
        setTitle("동적 리스트 뷰 테스트");

        // ( 자료구조에서 배운) ArrayList를 사용하여 add, remove
        // 하여 리스트뷰를 동적으로 사용 가능
        // 사용자가 수정 불가능한 딱 정해진 정적 리스트뷰를
        // 만들고 싶다면 Arrat=yList 대신 String[] 배열 사용하면 됨,
        final ArrayList<String> list = new ArrayList<String>();

        ListView lv =(ListView)findViewById(R.id.listView);

        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        list);

        lv.setAdapter(adapter);

        final EditText et = (EditText)findViewById(R.id.addItemText);
        Button btn = (Button)findViewById(R.id.addListViewBtn);

        // 리스트뷰를 동적으로 구성, ArrayList의 add() 메서드를 사용
        // 그리고 어댑터의 notifyDataSetChange() 메서드로 갱신
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(et.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        // 인자가 무려 4개!
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "리스트뷰의 "+(position+1)+"번째 클릭함", Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "리스트뷰의 "+(position+1)+"번째 제거함", Toast.LENGTH_SHORT).show();
                list.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
