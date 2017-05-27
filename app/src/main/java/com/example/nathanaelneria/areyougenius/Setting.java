package com.example.nathanaelneria.areyougenius;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Setting extends AppCompatActivity {
    private Switch statusSwitch;
    private SharedPreferences preferences;
    int SoundOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        preferences = getSharedPreferences("Sound", MODE_PRIVATE);

        statusSwitch = (Switch) findViewById(R.id.statusSwitch);

        statusSwitch.setChecked(preferences.getBoolean("your_key", false));


        statusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences.edit().putBoolean("your_key", isChecked).apply();
            }
        });
    }

    public void playSound(View view){
        //used for play music setting
        if (statusSwitch.isChecked()) {
            SoundOnOff = 1;
            preferences.edit().putInt("Sound", SoundOnOff).apply();
        } else {
            SoundOnOff = 0;
            preferences.edit().putInt("Sound", SoundOnOff).apply();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


    }
}
