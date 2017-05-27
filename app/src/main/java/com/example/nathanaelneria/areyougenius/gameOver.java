package com.example.nathanaelneria.areyougenius;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class gameOver extends AppCompatActivity {
    private TextView scoreText;
    private Database db;
    private int Currscore;
    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        scoreText = (TextView) findViewById(R.id.score);
        db = new Database(this);
        Currscore = db.getScoreCount();
        Cursor current = db.getPerson(Currscore);

        if(!(current==null)){
            current.moveToFirst();
            finalScore = current.getInt(current.getColumnIndex("score"));
        }
        
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
