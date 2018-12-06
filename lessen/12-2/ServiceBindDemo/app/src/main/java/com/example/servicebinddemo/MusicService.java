package com.example.servicebinddemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service {

    //private MyBinder iBinder;
    private MediaPlayer musicPlayer;
    private Timer timer;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //Toast.makeText(this, "MusicService onBind", Toast.LENGTH_SHORT).show();
        return new MyBinder();
    }

    public class MyBinder extends Binder implements MusicListener{

        @Override
        public void play() {
            MusicService.this.play();
        }

        @Override
        public void pause() {
            MusicService.this.pause();
        }

        @Override
        public void continuePlay() {
            MusicService.this.continuePlay();
        }

        @Override
        public void seekTo(int progress) {
            MusicService.this.seekTo(progress);
        }

        @Override
        public void stop() {
            MusicService.this.stop();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        musicPlayer=new MediaPlayer();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        musicPlayer.stop();
        musicPlayer.release();
        musicPlayer=null;
        if(timer!=null){
            timer.cancel();
            timer=null;
        }
    }

    void play(){
        musicPlayer.reset();
        try{
            musicPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music);
            //musicPlayer.prepareAsync();
            //musicPlayer.prepare();
            musicPlayer.start();
            addTimer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void continuePlay(){
        if (!musicPlayer.isPlaying())
            musicPlayer.start();
    }

    void pause(){
        if (musicPlayer.isPlaying())
            musicPlayer.pause();
    }

    void seekTo(int progress){
        musicPlayer.seekTo(progress);
    }

    void stop(){
        if (musicPlayer.isPlaying())
            musicPlayer.stop();
    }

    public void addTimer(){
        if(timer==null){
            timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    int duration=musicPlayer.getDuration();
                    int currentPosition=musicPlayer.getCurrentPosition();
                    Message message=MainActivity.handler.obtainMessage();
                    Bundle bundle=new Bundle();
                    bundle.putInt("duration",duration);
                    bundle.putInt("currentPosition",currentPosition);
                    Log.d("MusicService", "duration: "+duration+" currentPosition: "+currentPosition);
                    message.setData(bundle);
                    MainActivity.handler.sendMessage(message);
                }
            },5,500);
        }
    }

    public MusicService() {
    }
}
