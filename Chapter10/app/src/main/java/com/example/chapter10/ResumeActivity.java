package com.example.chapter10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResumeActivity extends Activity {
    int QuestionLEN = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        setTitle("집계 결과를 보여주는 액티비티");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("CountInfo");

        TextView tv[] = new TextView[voteResult.length];
        Integer tvId[] = {R.id.choice1, R.id.choice2, R.id.choice3, R.id.choice4, R.id.choice5};
        Log.d("1", "check");
        for (int i = 0; i < QuestionLEN; i++) {
            tv[i] = (TextView) findViewById(tvId[i]);
            tv[i].setText(String.valueOf(voteResult[i]));
        }
    }
}
