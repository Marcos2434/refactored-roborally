package dtu.controller;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicController {

    /*
    We have an extra controller to handle all the music in one single source of truth.
    */

    private MediaPlayer mediaPlayer;
    AudioClip hitSound = new AudioClip((getClass().getResource("/damageSound.mp3").toString()));
    AudioClip gameBeginSound = new AudioClip((getClass().getResource("/LetTheGameBegin.mp3").toString()));
    AudioClip ActionCard = new AudioClip((getClass().getResource("/specialCardsMusic.mp3").toString()));
    Media bgMusic = new Media((getClass().getResource("/bgmusic.mp3").toString()));

    
    public MusicController() {
        playBGMusic();
    }

    public void playBGMusic() {
        mediaPlayer = new MediaPlayer(bgMusic);  
        mediaPlayer.setAutoPlay(true); 
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void playHitSound() {  
        hitSound.play();
    }

    
    public void letGameBeginSound() {
        gameBeginSound.play();
    }

    public void playActionCardSound() {
        ActionCard.play();
    }

}
