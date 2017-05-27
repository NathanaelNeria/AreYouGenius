package com.example.nathanaelneria.areyougenius;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class highScore extends AppCompatActivity {
    ArrayList<String> numArray;
    ArrayList<Integer> scoreArray;
    ListView listView;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        db = new Database(this);
        numArray = new ArrayList<>();
        scoreArray = new ArrayList<>();
        scoreArray = db.getAllScores();

        Collections.sort(scoreArray, Collections.<Integer>reverseOrder());

        int enumerator = 1;
        if(scoreArray.size()<10) {
            for (int points : scoreArray) {
                numArray.add(String.format(Locale.getDefault(), "%1$2s.  %2$3s ", Integer.toString(enumerator), Integer.toString(points)));
                enumerator++;
            }
        } else {
            for(int x = 0 ; x<10 ; x++){
                numArray.add(String.format(Locale.getDefault(), "%1$2s.  %2$3s ", Integer.toString(enumerator), Integer.toString(scoreArray.get(x))));
                enumerator++;
            }
        }
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.,numArray);
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(myAdapter);
        listview.setDivider(null);
    }

}
