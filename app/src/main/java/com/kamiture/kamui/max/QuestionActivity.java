package com.kamiture.kamui.max;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
    Random random = new Random();
    int maxNumber;
    int[] maxCount;
    TextView question;
    ImageView maxButton;
    ImageView maxButton2;
    ImageView maxButton3;
    ImageView maxButton4;
    Button button;
    int collectAnswer;
    int score;
    boolean exist;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maxCount = new int[4];
        question = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        maxButton = (ImageView) findViewById(R.id.maxButton);
        maxButton.setOnClickListener(this);
        maxButton2 = (ImageView) findViewById(R.id.maxButton2);
        maxButton2.setOnClickListener(this);
        maxButton3 = (ImageView) findViewById(R.id.maxButton3);
        maxButton3.setOnClickListener(this);
        maxButton4 = (ImageView) findViewById(R.id.maxButton4);
        maxButton4.setOnClickListener(this);
        this.progressBar = (ProgressBar)findViewById(R.id.progressBar);
        getRandom();
        make();
        score = 0;
        progress();
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.maxButton:
                if (maxCount[0] == 8){
                    countDownTimer.cancel();
                    score = score + 1;
                    getRandom();
                    make();
                    progress();
                } else {
                    countDownTimer.cancel();
                    intent();
                }
            case R.id.maxButton2:
                if (maxCount[0] == 8){
                    countDownTimer.cancel();
                    score = score + 1;
                    getRandom();
                    make();
                    progress();
                } else {
                    countDownTimer.cancel();
                    intent();
                }
            case R.id.maxButton3:
                if (maxCount[0] == 8){
                    countDownTimer.cancel();
                    score = score + 1;
                    getRandom();
                    make();
                    progress();
                } else {
                    countDownTimer.cancel();
                    intent();
                }
            case R.id.maxButton4:
                if (maxCount[0] == 8){
                    countDownTimer.cancel();
                    score = score + 1;
                    getRandom();
                    make();
                    progress();
                } else {
                    countDownTimer.cancel();
                   intent();
                }
            case R.id.button:
                if (exist){
                    countDownTimer.cancel();
                    score = score + 1;
                    getRandom();
                    make();
                    progress();
                } else {
                    countDownTimer.cancel();
                    intent();
                }
        }

    }

    private void make (){
        Drawable drawable = getImage(0);
        maxButton.setImageDrawable(drawable);
        Drawable drawable2 = getImage(1);
        maxButton2.setImageDrawable(drawable2);
        Drawable drawable3 = getImage(2);
        maxButton3.setImageDrawable(drawable3);
        Drawable drawable4 = getImage(3);
        maxButton4.setImageDrawable(drawable4);
    }

    private void getRandom (){
        exist = false;
        //return random.nextInt(9);
        for (int i = 0; i < maxCount.length; i++) {
            Loop:
            while (true) {
                maxCount[i] = random.nextInt(9);
                for (int j = 0; j < i; j++) {
                    if (maxCount[j] == maxCount[i]) continue Loop;
                }
                if(maxCount[i] == 8) {
                    exist = true;
                }
                break;
            }
            Log.d("maxCount" + "[" + i + "]", maxCount[i]+"");
        }
    }
    private Drawable getImage(int index){
        TypedArray imageArrbtainTay = this.getResources().obtainTypedArray(R.array.MaxCoffee);
        Drawable drawable = imageArrbtainTay.getDrawable(maxCount[index]);
        return drawable;
    }
    private void intent (){
        countDownTimer.cancel();
        Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
        intent.putExtra("keyword",score);
        startActivity(intent);
    }
    private void progress (){
        countDownTimer = new CountDownTimer(5000, 5){
            public void onFinish() {
                intent();
            }
            public void onTick(long amount) {
                progressBar.setProgress((int) amount);
            }
        };
        countDownTimer.start();
    }


}
