package com.vendur.a8dmusicrelaxer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class PictureFiveteen extends AppCompatActivity {

    MediaPlayer mediaPlayer, mediaPlayer2;
    ImageView playMusicBtnIcon;
    private long backPressedTime;
    private Toast backToast;
    public InterstitialAd interstitialAd; //реклама

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fiveteen_picture);

        //Реклама - начало
        MobileAds.initialize(this, "ca-app-pub-3168619350789612~3906083709");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3168619350789612/9109157547");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        //Реклама - конец

        //Закрытие рекламы на крестик - начало
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                try{
                    Intent intent = new Intent(PictureFiveteen.this, PageFour.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //Закрытие рекламы на крестик - конец

        Button btnBefore = (Button)findViewById(R.id.btn_before_from_pic15);

        btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isLoaded()){
                    interstitialAd.show();//Показать рекламу
                    mediaPlayer.stop();
                }else {
                    try {
                        Intent intent = new Intent(PictureFiveteen.this, PageFour.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer2.start();
                        finish();
                    } catch (Exception e) {

                    } //конец конструкции
                }
            }
        });

        playMusicBtnIcon = findViewById(R.id.play_music_btn);
        playMusicBtnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    playMusicBtnIcon.setImageResource(R.drawable.btn_pause_music_white);
                }else{
                    mediaPlayer.pause();
                    playMusicBtnIcon.setImageResource(R.drawable.btn_play_music_white);
                }
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.melody_for_pic15);

        mediaPlayer2 = new MediaPlayer();
        mediaPlayer2 = MediaPlayer.create(this, R.raw.btn_click_sound);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    //Системная кнопка "назад" - конец
}
