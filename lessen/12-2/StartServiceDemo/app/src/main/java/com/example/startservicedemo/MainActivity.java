package com.example.startservicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startMusic = (Button) findViewById(R.id.startMusic);
        Button stopMusic = (Button) findViewById(R.id.stopMusic);
        startMusic.setOnClickListener(this);
        stopMusic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MusicService.class);
        switch (v.getId()) {
            case R.id.startMusic:
                startService(intent);
                break;
            case R.id.stopMusic:
                stopService(intent);
                break;
        }
    }
}
