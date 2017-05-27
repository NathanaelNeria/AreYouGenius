package com.example.nathanaelneria.areyougenius;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class playGame extends Activity {
    private int questNo = 0;
    Random random = new Random();
    Button ButtonB;

    private int qr;
    private int score;
    Database db;


    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new Database(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_game);

        preferences = getSharedPreferences("score",MODE_PRIVATE);

        score = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        
        nextQuestion();
    }

    public void nextQuestion() {
        //code for random question making and random answer text position
        TextView question;
        Button ButtonA;
        Button ButtonC;
        Button ButtonD;
        int a;
        int b;
        int c;
        int d;

        ArrayList<Integer>randomPutter = new ArrayList<>();
        ArrayList<Integer>randomizedAnswer = new ArrayList<>();
        a = random.nextInt(19) + 1;
        b = random.nextInt(19) + 1;
        c = random.nextInt(19) + 1;
        d = random.nextInt(20) + 1;
        qr = a+b*c;

        question = (TextView) findViewById(R.id.question);
        ButtonA = (Button) findViewById(R.id.a);
        ButtonB = (Button) findViewById(R.id.b);
        ButtonC = (Button) findViewById(R.id.c);
        ButtonD = (Button) findViewById(R.id.d);

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

        ButtonA.setText(Integer.toString(randomizedAnswer.get(0)));
        ButtonB.setText(Integer.toString(randomizedAnswer.get(1)));
        ButtonC.setText(Integer.toString(randomizedAnswer.get(2)));
        ButtonD.setText(Integer.toString(randomizedAnswer.get(3)));
        questNo++;

    }

    public void handler(View view){
        ButtonB = (Button) findViewById(R.id.b);

        String ans = ButtonB.getText().toString();

        int answer = Integer.parseInt(ans);


        if(qr == answer){ //increment if the answer is correct
            score++;
        }
        if(questNo<30) { //set question to 30
            nextQuestion();
        }
        else{
            Result();
        }
    }

    public void Result(){ //for adding score to database and move to gameOver activity
        db.addScore(score);
        db.close();
        Intent intent = new Intent(this,gameOver.class);
        startActivity(intent);
        finish();

    }



}
