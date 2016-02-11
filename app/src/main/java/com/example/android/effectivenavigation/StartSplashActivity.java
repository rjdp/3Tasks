package com.example.android.effectivenavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        }, 3000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start_splach);
        ImageView imageView;
        Animation pulse;
        Animation alpha;
        Animation translate;
        imageView = (ImageView) findViewById(R.id.imageView3);
        pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        imageView.startAnimation(pulse);

        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        RelativeLayout relativeLayout=(RelativeLayout) findViewById(R.id.rel_lay2);
        relativeLayout.clearAnimation();
        relativeLayout.startAnimation(alpha);

        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.lin_lay);
        linearLayout.clearAnimation();
        linearLayout.startAnimation(translate);
    }

}
