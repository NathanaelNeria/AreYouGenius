package com.example.nathanaelneria.areyougenius;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Shake mShakeDetector;
    private int soundOnOff;
    Button game;
    Button score;
    Button quit;
    SharedPreferences preferences;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        preferences = getSharedPreferences("Sound", MODE_PRIVATE);

        music = MediaPlayer.create(getApplicationContext(), R.raw.backgroundsong);
        music.setLooping(true);

        soundOnOff = preferences.getInt("Sound",0);

        if(soundOnOff == 1){
            music.start();
        }

        final int [] bgpic = {R.drawable.background, R.drawable.adv, R.drawable.poke};
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new Shake();
        mShakeDetector.setOnShakeListener(new Shake.OnShakeListener() {

            @Override
            public void onShake(int count) { //change background on shake
                Random random = new Random();
                int randbg = random.nextInt(bgpic.length);
                LinearLayout layout = (LinearLayout) findViewById(R.id.display);
                if(layout.getBackground() == ContextCompat.getDrawable(MainActivity.this, bgpic[randbg])) {
                    layout.setBackgroundResource(bgpic[(randbg+1)%bgpic.length]);
                } else {
                    layout.setBackgroundResource(bgpic[randbg]);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Setting.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.stop();
        mSensorManager.unregisterListener(mShakeDetector);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    public void onClick(View view){
        game = (Button) findViewById(R.id.game);
        quit = (Button) findViewById(R.id.quit);
        score = (Button) findViewById(R.id.score);

        if (view == game){
            Intent intent = new Intent(this,playGame.class);
            startActivity(intent);
        }
        else if (view == quit){
            finish();
        }
        else if(view == score){
            Intent intent = new Intent(this,highScore.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onStart() { //play music if the setting is on
        super.onStart();
        soundOnOff = preferences.getInt("Sound",0);
        if(soundOnOff == 1){
            music.start();
        }
    }
}
