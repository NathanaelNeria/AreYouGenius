package com.example.nathanaelneria.areyougenius;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class playGame extends AppCompatActivity {
    private ArrayList<String> stringArray = new ArrayList<>();
    private ArrayList<String> arrayLeft = new ArrayList<>();
    private ArrayList<String> arrayRight = new ArrayList<>();
    private ArrayList<String> arrayTop = new ArrayList<>();
    private ArrayList<String> arrayBottom = new ArrayList<>();
    private TextView question;
    private Button Ba;
    private Button Bb;
    private Button Bc;
    private Button Bd;
    private int questNo = 0;
    Random random = new Random();
    private int a = random.nextInt(19) + 1;
    private int b = random.nextInt(19) + 1;
    private int c = random.nextInt(19) + 1;
    private int d = random.nextInt(20) + 1;
    private int w = a + b * c - d;
    private int r = a + b * c;
    private int ww = a + c * b + d / a - 10;
    private int rr = a * b +c /d * a + 10;
    private int qr = a+b*c;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
    }

    @Override
    protected void onStart() {
        super.onStart();


        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);
        stringArray.add(a+" + "+b+" * "+c);

        arrayLeft.add(String.valueOf(w));
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
        arrayTop.add(String.valueOf(rr));
        Question();


    }

    public void Question() {
        question = (TextView) findViewById(R.id.question);
        Ba = (Button) findViewById(R.id.a);
        Bb = (Button) findViewById(R.id.b);
        Bc = (Button) findViewById(R.id.c);
        Bd = (Button) findViewById(R.id.d);

        for(int i = 0; i < 10; i++) {
            question.setText(stringArray.get(questNo));
            Ba.setText(arrayLeft.get(questNo));
            Bb.setText(arrayRight.get(questNo));
            Bc.setText(arrayTop.get(questNo));
            Bd.setText(arrayBottom.get(questNo));
            questNo++;
        }
    }

    public void handler(View view){
        Bb = (Button) findViewById(R.id.b);

        String ansa = Ba.getText().toString();
        String ansb = Bb.getText().toString();
        String ansc = Bc.getText().toString();
        String ansd = Bd.getText().toString();
        int answerd = Integer.parseInt(ansd);
        int answera = Integer.parseInt(ansa);
        int answerb = Integer.parseInt(ansb);
        int answerc = Integer.parseInt(ansc);

        if(ansb.equals(question.getText())){
            Question();
        }

    }




}
