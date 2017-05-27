package com.example.nathanaelneria.areyougenius;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameOver extends AppCompatActivity {
    private TextView scoreText;
    private Database db;
    private int Currscore;
    private int finalScore;
    Button Share;
    Button Menu;
    Button quit;


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
        scoreText.setText(Integer.toString(finalScore));
        db.close();
    }

    public void onClick(View view){

    }
}
