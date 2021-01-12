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

public class PageFour extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_page);

        Button btnNext = (Button)findViewById(R.id.btn_next4);
        Button btnBefore = (Button)findViewById(R.id.btn_before3);

        ImageView imageView13 = (ImageView)findViewById(R.id.picture13);
        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageFour.this, PictureThirteen.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView14 = (ImageView)findViewById(R.id.picture14);
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageFour.this, PictureFourteen.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView15 = (ImageView)findViewById(R.id.picture15);
        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageFour.this, PictureFiveteen.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        ImageView imageView16 = (ImageView)findViewById(R.id.picture16);
        imageView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(PageFour.this, PictureSixteen.class);
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
                    Intent intent = new Intent(PageFour.this, PageFive.class);
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
                    Intent intent = new Intent(PageFour.this, PageThree.class);
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
