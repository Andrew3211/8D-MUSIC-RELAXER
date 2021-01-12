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

public class PageEight extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eight_page);

        Button btnNext = (Button)findViewById(R.id.btn_next8);
        Button btnBefore = (Button)findViewById(R.id.btn_before7);

        ImageView imageView29 = (ImageView)findViewById(R.id.picture29);
        imageView29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageEight.this, PictureTwentyNine.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView30 = (ImageView)findViewById(R.id.picture30);
        imageView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageEight.this, PictureThirty.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView31 = (ImageView)findViewById(R.id.picture31);
        imageView31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageEight.this, PictureThirtyOne.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView32 = (ImageView)findViewById(R.id.picture32);
        imageView32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageEight.this, PictureThirtyTwo.class);
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
                    Intent intent = new Intent(PageEight.this, PageNine.class);
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
                    Intent intent = new Intent(PageEight.this, PageSeven.class);
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
