package com.example.visionstech.storkmart.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.visionstech.storkmart.Fragment.RegisterFragment;
import com.example.visionstech.storkmart.R;

import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {
    //todo:Goback not working
    //todo:Image not complete


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        //todo:action bar is appear

       // StatusBarUtil.setTransparent(RegisterActivity.this);

        Toolbar customToolbar = findViewById(R.id.c_toolbar);
        setSupportActionBar(customToolbar);
        TextView tv_appBarTitl = findViewById(R.id.appBarTitle);
        tv_appBarTitl.setText(R.string.RigisterNewAccount);

        switchpage(new RegisterFragment());




    }

    public void switchpage(Fragment fragment) {




        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.activity_Login_frame,fragment);
        transaction.commit();


    }





}
