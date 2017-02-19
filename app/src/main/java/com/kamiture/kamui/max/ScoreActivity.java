package com.kamiture.kamui.max;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView textView;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.textView);
        result = (TextView)findViewById(R.id.score);
        int data = getIntent().getIntExtra("keyword",0);
        result.setText(String.valueOf(data));
    }
    public void onemore (View v){
        Intent intent = new Intent(ScoreActivity.this,TitleActivity.class);
        startActivity(intent);


    }
}
