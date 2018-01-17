package com.example.visionstech.storkmart.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.visionstech.storkmart.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;

public class AfterSplashActivity extends AppCompatActivity {
    //todo:language for arabic
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftersplash);
        ButterKnife.bind(this);
        StatusBarUtil.setTransparent(AfterSplashActivity.this);
    }

    public void goToLoginAvtivity(View view) {
        startActivity(new Intent(this, LoginActivity.class));

    }

    public void goToSignUpAvtivity(View view) {

        startActivity(new Intent(this, RegisterActivity.class));
    }
}
