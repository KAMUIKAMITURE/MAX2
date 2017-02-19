package com.kamiture.kamui.max;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TitleActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView = (TextView)findViewById(R.id.textView);
    }
    public void start (View v){
        Intent intent = new Intent(this,QuestionActivity.class);
        startActivity(intent);
    }
}
