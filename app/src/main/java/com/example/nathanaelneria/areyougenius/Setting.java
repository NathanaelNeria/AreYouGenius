package com.example.nathanaelneria.areyougenius;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Setting extends AppCompatActivity {
    private Button confirmButton;
    private Switch statusSwitch;
    private SharedPreferences preferences;
    int SoundOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        preferences = getSharedPreferences("value", MODE_PRIVATE);

        confirmButton = (Button) findViewById(R.id.confirmButton);
        statusSwitch = (Switch) findViewById(R.id.statusSwitch);

        statusSwitch.setChecked(preferences.getBoolean("your_key", false));

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String statusSwitchFormula;
                if (statusSwitch.isChecked()) {
                    statusSwitchFormula = statusSwitch.getTextOn().toString();
                    SoundOnOff = 1;
                    preferences.edit().putInt("soundonoff", SoundOnOff).apply();
                } else {
                    SoundOnOff = 0;
                    preferences.edit().putInt("soundonoff", SoundOnOff).apply();
                    statusSwitchFormula = statusSwitch.getTextOff().toString();
                }
                finish();

            }
        });

        statusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences.edit().putBoolean("your_key", isChecked).apply();
            }
        });
    }
}
