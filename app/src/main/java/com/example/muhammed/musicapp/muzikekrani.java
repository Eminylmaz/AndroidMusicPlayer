package com.example.muhammed.musicapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class muzikekrani extends AppCompatActivity {

    Button playMusic,stopMusic;
    MediaPlayer mediaPlayer;
    TextView sammyHogerr,elapsedTimeLabel,remainingTimeLabel;
    SeekBar volumeBar,positionBar;
    int totalTime;
    Thread updateSeekbar;
    ImageView likeBtn,favoriBtn;
    int likebtnDegisken= 0;
    int favoribtnDegisken =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muzikekrani);

        favoriBtn = findViewById(R.id.favoriButonu); //favoributonuTanimlama
        likeBtn = findViewById(R.id.begenmeButonu);  //likebutonuTanimlama

        elapsedTimeLabel = findViewById(R.id.elapsedTimeLabel); //sarki suresi yazan textviewleri tanitiyorum.
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel);

        sammyHogerr = (TextView) findViewById(R.id.sammyHogerr);  //Textview saga dogru animasyon verdim.
        Animation animation = new TranslateAnimation(360, 0, 0, 0);
        animation.setDuration(9000);
        animation.setRepeatMode(Animation.RELATIVE_TO_SELF);
        animation.setRepeatCount(Animation.INFINITE);
        sammyHogerr.setAnimation(animation);


        mediaPlayer = MediaPlayer.create(muzikekrani.this,R.raw.umutkayamoryazma); //muzik baslatma,durdurma ve play,pause gorunurluk yaptim
        playMusic = (Button) findViewById(R.id.playMusic);
        playMusic.setVisibility(View.VISIBLE);
        stopMusic = findViewById(R.id.stopMusic);
        stopMusic.setVisibility(View.GONE);


        mediaPlayer.setLooping(true);
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(0.5f,0.5f);
        totalTime = mediaPlayer.getDuration(); 

        positionBar = findViewById(R.id.positionBar); //sarki seekbari tanitiyorum.
        positionBar.setMax(totalTime);


        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser){
                    mediaPlayer.seekTo(progress);
                    positionBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        updateSeekbar = new Thread(new Runnable() {
            @Override
            public void run() {

                int totalDuration = mediaPlayer.getDuration();
                int currentPosition =0;



                while (currentPosition<totalDuration)
                {
                    try {
                        Thread.sleep(1000);
                        currentPosition = mediaPlayer.getCurrentPosition();
                        positionBar.setProgress(currentPosition);


                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });



        updateSeekbar.start();

        //SeekBar ses ayarlama
        volumeBar = (SeekBar) findViewById(R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum = progress / 100f;
                mediaPlayer.setVolume(volumeNum,volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

                playMusic.setVisibility(View.GONE);
                stopMusic.setVisibility(View.VISIBLE);
            }
        });
        stopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                playMusic.setVisibility(View.VISIBLE);
                stopMusic.setVisibility(View.GONE);
            }
        });


        favoriBtn.setOnClickListener(new View.OnClickListener() {  //favori butonuna tiklandiginda;
            @Override
            public void onClick(View v) {
                likebtnDegisken++;   //bu degiskenden alinan degere gore
                if (likebtnDegisken % 2 ==0){ //tekmi cifmi oldugunu kontrol ediyorum eger kalan tekse dolufavori iconu geliyor
                    favoriBtn.setImageResource(R.drawable.bosfavori);
                }else{                          //kalan ciftse bos favori iconu geliyor
                    favoriBtn.setImageResource(R.drawable.dolufavori);
                }

            }
        });
        likeBtn.setOnClickListener(new View.OnClickListener() {  //like butonuna tiklandiginda;
            @Override
            public void onClick(View v) {
                favoribtnDegisken++; //bu degiskenden alinan degere gore;
                if (favoribtnDegisken % 2 == 0){ //kalana bakiyoruz eger tekse basilmis like iconu geliyor
                    likeBtn.setImageResource(R.drawable.likebos);
                }else{                        //kalan ciftse bos like iconu geliyor.
                    likeBtn.setImageResource(R.drawable.dolubegen);
                }

            }
        });



    }//onCreate Metodunu kapatir.

}
