package com.example.servicebinddemo;

public interface MusicListener {

    void play();
    void pause();
    void continuePlay();
    void seekTo(int progress);
    void stop();

}
