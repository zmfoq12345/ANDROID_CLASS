package com.example.jjapkaotalk21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {
    LinearLayout menuLayout;
    TextView friName;
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

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.star:
                if(s=="123")
                    s = friName.getText().toString();
                if (b) {
                    friName.setText(friName.getText().toString()+"★");
                    b = false;
                }else {
                    friName.setText(s);
                    b = true;
                }
                return true;

            case R.id.del:
                fri.setText("친구가 1명도 없는 짭카오톡");
                menuLayout.setVisibility(GONE);
                return true;
        }
        return false;
    }
}
