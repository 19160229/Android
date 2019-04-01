package com.example.servicebinddemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static Handler handler=new Handler(){
        public void handleMessage(Message msg){
            Bundle bundle=msg.getData();
            int duration=bundle.getInt("duration");
            int currentPosition=bundle.getInt("currentPosition");
            seekBar.setMax(duration);
            seekBar.setProgress(currentPosition);
        }
    };

    MusicListener mi;
    private Intent intent;
    private static SeekBar seekBar;

    private ServiceConnection mServiceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mi=(MusicService.MyBinder)service;
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
        seekBar=(SeekBar)findViewById(R.id.SeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress=seekBar.getProgress();
                mi.seekTo(progress);
            }
        });
        startMusic.setOnClickListener(this);
        pauseMusic.setOnClickListener(this);
        stopMusic.setOnClickListener(this);
        restartMusic.setOnClickListener(this);
        intent=new Intent(this,MusicService.class);
        startService(intent);
        bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                mi.play();
                break;
            case R.id.pause:
                mi.pause();
                break;
            case R.id.stop:
                mi.stop();
                break;
            case R.id.restart:
                mi.continuePlay();
                break;
        }
    }
}
