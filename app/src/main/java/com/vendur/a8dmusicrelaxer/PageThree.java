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

public class PageThree extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_page);

        Button btnNext = (Button)findViewById(R.id.btn_next3);
        Button btnBefore = (Button)findViewById(R.id.btn_before2);

        ImageView imageView9 = (ImageView)findViewById(R.id.picture9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageThree.this, PictureNine.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView10 = (ImageView)findViewById(R.id.picture10);
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageThree.this, PictureTen.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView11 = (ImageView)findViewById(R.id.picture11);
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageThree.this, PictureEleven.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView12 = (ImageView)findViewById(R.id.picture12);
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageThree.this, PictureTwelve.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageThree.this, PageFour.class);
                    startActivity(intent);
                    mediaPlayer.start();
                    finish();
                }catch (Exception e){

                } //конец конструкции
            }
        });

        btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageThree.this, PageTwo.class);
                    startActivity(intent);
                    mediaPlayer.start();
                    finish();
                }catch (Exception e){

                } //конец конструкции
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.btn_click_sound);

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
