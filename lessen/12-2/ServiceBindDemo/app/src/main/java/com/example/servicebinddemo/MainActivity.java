package com.example.servicebinddemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MusicService.MyBinder musicPlayerBinder;

    private ServiceConnection mServiceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            musicPlayerBinder=(MusicService.MyBinder)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startMusic=(Button)findViewById(R.id.start);
        Button pauseMusic=(Button)findViewById(R.id.pause);
        Button stopMusic=(Button)findViewById(R.id.stop);
        Button restartMusic=(Button)findViewById(R.id.restart);
        startMusic.setOnClickListener(this);
        pauseMusic.setOnClickListener(this);
        stopMusic.setOnClickListener(this);
        restartMusic.setOnClickListener(this);
        Intent intent=new Intent(this,MusicService.class);
        bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                try{
                    musicPlayerBinder.playMusic();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.pause:
                musicPlayerBinder.pauseMusic();
                break;
            case R.id.stop:
                musicPlayerBinder.stopMusic();
                break;
            case R.id.restart:
                musicPlayerBinder.restartMusic();
                break;
        }
    }
}
