package com.example.nathanaelneria.areyougenius;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class playGame extends Activity {
    private TextView question;
    private Button Ba;
    private Button Bb;
    private Button Bc;
    private Button Bd;
    private int questNo = 0;
    Random random = new Random();
    private int a;
    private int b;
    private int c;
    private int d;

    private int qr;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_game);

        score = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();

        /*arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));
        arrayLeft.add(String.valueOf(w));

        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));
        arrayRight.add(String.valueOf(r));

        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));
        arrayBottom.add(String.valueOf(ww));

        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));
        arrayTop.add(String.valueOf(rr));*/
        nextQuestion();


    }

    public void nextQuestion() {
        ArrayList<Integer>randomPutter = new ArrayList<>();
        ArrayList<Integer>randomizedAnswer = new ArrayList<>();
        a = random.nextInt(19) + 1;
        b = random.nextInt(19) + 1;
        c = random.nextInt(19) + 1;
        d = random.nextInt(20) + 1;
        qr = a+b*c;

        question = (TextView) findViewById(R.id.question);
        Ba = (Button) findViewById(R.id.a);
        Bb = (Button) findViewById(R.id.b);
        Bc = (Button) findViewById(R.id.c);
        Bd = (Button) findViewById(R.id.d);

        question.setText(String.format(Locale.getDefault(),"%1$2d + %2$2d * %3$2d",a,b,c));
        int w = a + b * c - d;
        int r = a + b * c;
        int ww = a + c * b + d / a - 10;
        int rr = a * b +c /d * a + 10;

        randomPutter.add(w);
        randomPutter.add(r);
        randomPutter.add(ww);
        randomPutter.add(rr);

        while(randomPutter.size()>0){
            int randomCounter = random.nextInt(randomPutter.size());
            randomizedAnswer.add(randomPutter.get(randomCounter));
            randomPutter.remove(randomCounter);
        }

        Ba.setText(Integer.toString(randomizedAnswer.get(0)));
        Bb.setText(Integer.toString(randomizedAnswer.get(1)));
        Bc.setText(Integer.toString(randomizedAnswer.get(2)));
        Bd.setText(Integer.toString(randomizedAnswer.get(3)));
        questNo++;

    }

    public void handler(View view){
        Bb = (Button) findViewById(R.id.b);

        String ans = Bb.getText().toString();

        int answer = Integer.parseInt(ans);


        if(qr == answer){
            score++;
        }
        if(questNo<10) {
            nextQuestion();
        } else{
            Intent intent = new Intent(this,gameOver.class);
            intent.putExtra("score",score);
            startActivity(intent);
            finish();
        }
    }




}
