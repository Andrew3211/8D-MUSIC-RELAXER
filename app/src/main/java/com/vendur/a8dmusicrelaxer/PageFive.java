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

public class PageFive extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_page);

        Button btnNext = (Button)findViewById(R.id.btn_next5);
        Button btnBefore = (Button)findViewById(R.id.btn_before4);

        ImageView imageView17 = (ImageView)findViewById(R.id.picture17);
        imageView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageFive.this, PictureSeventeen.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView18 = (ImageView)findViewById(R.id.picture18);
        imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageFive.this, PictureEighteen.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView19 = (ImageView)findViewById(R.id.picture19);
        imageView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageFive.this, PictureNineteen.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView20 = (ImageView)findViewById(R.id.picture20);
        imageView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageFive.this, PictureTwenty.class);
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
                    Intent intent = new Intent(PageFive.this, PageSix.class);
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
                    Intent intent = new Intent(PageFive.this, PageFour.class);
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
