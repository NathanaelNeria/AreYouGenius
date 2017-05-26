package com.example.nathanaelneria.areyougenius;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class playGame extends AppCompatActivity {
    TextView question;
    TextView wrong;
    TextView right;
    ArrayList<String> stringArray = new ArrayList<>();
    ArrayList<String> arrayLeft = new ArrayList<>();
    ArrayList<String> arrayRight = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Random random = new Random();

        int a = random.nextInt(19)+1;
        int b = random.nextInt(19)+1;
        int c = random.nextInt(19)+1;
        int d = random.nextInt(20);

        int w = a + b * c - d;

        int r = a + b * c;

        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);
        stringArray.add(a+" + "+b+" x "+c);

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

        TextView question = (TextView) findViewById(R.id.question);
        TextView wrong = (TextView) findViewById(R.id.wrong);
        TextView right = (TextView) findViewById(R.id.right);

        //question.setText(stringArray.get(0));
        //wrong.setText(arrayLeft.get(0));
        //right.setText(arrayRight.get(0));

        question.setText(stringArray.get(1));
        wrong.setText(arrayLeft.get(1));
        right.setText(arrayRight.get(1));

        question.setText(stringArray.get(2));
        wrong.setText(arrayLeft.get(2));
        right.setText(arrayRight.get(2));

        question.setText(stringArray.get(3));
        wrong.setText(arrayLeft.get(3));
        right.setText(arrayRight.get(3));

        question.setText(stringArray.get(4));
        wrong.setText(arrayLeft.get(4));
        right.setText(arrayRight.get(4));

        question.setText(stringArray.get(5));
        wrong.setText(arrayLeft.get(5));
        right.setText(arrayRight.get(5));

        question.setText(stringArray.get(6));
        wrong.setText(arrayLeft.get(6));
        right.setText(arrayRight.get(6));

        question.setText(stringArray.get(7));
        wrong.setText(arrayLeft.get(7));
        right.setText(arrayRight.get(7));

        question.setText(stringArray.get(8));
        wrong.setText(arrayLeft.get(8));
        right.setText(arrayRight.get(8));

        question.setText(stringArray.get(9));
        wrong.setText(arrayLeft.get(9));
        right.setText(arrayRight.get(9));

    }


}
