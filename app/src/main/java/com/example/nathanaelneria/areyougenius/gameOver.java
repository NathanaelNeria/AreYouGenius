package com.example.nathanaelneria.areyougenius;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class gameOver extends AppCompatActivity {
    SharedPreferences preferences;
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        scoreText = (TextView) findViewById(R.id.score);

        preferences = getSharedPreferences("score", MODE_PRIVATE);


    }

    @Override
    protected void onStart() {
        super.onStart();
        scoreText.setText("" + preferences.getInt("score", 0 ));
    }
}
