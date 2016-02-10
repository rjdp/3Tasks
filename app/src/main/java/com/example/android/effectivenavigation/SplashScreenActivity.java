package com.example.android.effectivenavigation;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {

    private MediaPlayer mediaPlayer;

    @Override
    protected  void onStart(){
        super.onStart();

        mediaPlayer = MediaPlayer.create(this, R.raw.bms);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mediaPlayer.start();


        (new Timer()).schedule(new TimerTask() {
            @Override
            public void run() {

                finish();
            }
        }, 10000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        ImageView imageView;
        ImageView imageView1;
        Animation pulse;
        Animation alpha;
        Animation translate;
        imageView = (ImageView) findViewById(R.id.imageView);
        pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        imageView.startAnimation(pulse);

         alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        RelativeLayout relativeLayout=(RelativeLayout) findViewById(R.id.rel_lay);
        relativeLayout.clearAnimation();
        relativeLayout.startAnimation(alpha);

        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        imageView1 = (ImageView) findViewById(R.id.imageView2);
        imageView1.startAnimation(translate);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

}
