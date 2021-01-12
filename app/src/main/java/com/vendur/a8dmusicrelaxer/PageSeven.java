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

public class PageSeven extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seven_page);

        Button btnNext = (Button)findViewById(R.id.btn_next7);
        Button btnBefore = (Button)findViewById(R.id.btn_before6);

        ImageView imageView25 = (ImageView)findViewById(R.id.picture25);
        imageView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageSeven.this, PictureTwentyFive.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView26 = (ImageView)findViewById(R.id.picture26);
        imageView26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageSeven.this, PictureTwentySix.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView27 = (ImageView)findViewById(R.id.picture27);
        imageView27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageSeven.this, PictureTwentySeven.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView28 = (ImageView)findViewById(R.id.picture28);
        imageView28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageSeven.this, PictureTwentyEight.class);
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
                    Intent intent = new Intent(PageSeven.this, PageEight.class);
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
                    Intent intent = new Intent(PageSeven.this, PageSix.class);
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
