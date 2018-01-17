package com.example.visionstech.storkmart.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.visionstech.storkmart.R;
import com.jaeger.library.StatusBarUtil;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        StatusBarUtil.setTransparent(LanguageActivity.this);
    }


    public void selec_ara(View v){
        setLocale("ar");

        startActivity(new Intent(this,AfterSplashActivity.class));
    }
    public void selec_en(View v){
       setLocale("en");

        startActivity(new Intent(this,AfterSplashActivity.class));
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        Locale.setDefault(myLocale);
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }


}
