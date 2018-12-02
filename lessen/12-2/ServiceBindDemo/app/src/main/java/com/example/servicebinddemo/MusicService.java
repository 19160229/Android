package com.example.servicebinddemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

public class MusicService extends Service {

    private MyBinder iBinder;
    private MediaPlayer musicPlayer;

    public class MyBinder extends Binder{
        public void playMusic() throws IOException{
            musicPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music);
            musicPlayer.setLooping(true);
            musicPlayer.start();
        }

        public void stopMusic(){
            if(musicPlayer.isPlaying()){
                musicPlayer.stop();
            }
        }

        public void pauseMusic(){
            if(musicPlayer.isPlaying()){
                musicPlayer.pause();
            }
        }

        public void restartMusic(){
            if(!musicPlayer.isPlaying()){
                musicPlayer.start();
            }
        }
    }

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        iBinder=new MyBinder();
        Toast.makeText(this, "MusicService onBind", Toast.LENGTH_SHORT).show();
        return iBinder;
    }
}
