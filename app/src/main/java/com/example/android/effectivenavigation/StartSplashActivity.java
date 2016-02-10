package com.example.android.effectivenavigation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class StartSplashActivity extends Activity {

    @Override
    protected void onResume() {
        super.onResume();




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
        Animation pulse;
        imageView = (ImageView) findViewById(R.id.imageView);
        pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        imageView.startAnimation(pulse);
    }

}
