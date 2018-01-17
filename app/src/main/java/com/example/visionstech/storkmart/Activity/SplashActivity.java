package com.example.visionstech.storkmart.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.visionstech.storkmart.R;
import com.jaeger.library.StatusBarUtil;

public class SplashActivity extends AppCompatActivity {
    final int SPLASH_DISPLAY_lENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        StatusBarUtil.setTransparent(SplashActivity.this);
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {startActivity(new Intent(SplashActivity.this, LanguageActivity.class));
                                          finish();
                                      }
                                  }
                , SPLASH_DISPLAY_lENGTH);
    }


}
