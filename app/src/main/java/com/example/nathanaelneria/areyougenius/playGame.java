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

        stringArray.add("3 x 5 + 7 / 3");
        stringArray.add("5 x 10 / 20 x 2");
        stringArray.add("3 + 2");
        stringArray.add("6 + 2");
        stringArray.add("");
        stringArray.add("5 x 10 / 20 x 2");
        stringArray.add("5 x 10 / 20 x 2");
        stringArray.add("5 x 10 / 20 x 2");
        stringArray.add("5 x 10 / 20 x 2");
        stringArray.add("5 x 10 / 20 x 2");

        TextView question = (TextView) findViewById(R.id.question);

        question.setText(stringArray.get(0));

        /*        Resources res = getResources();
        question = res.getStringArray(ArrayList<stringArray>);

        question.setText();*/
    }


}