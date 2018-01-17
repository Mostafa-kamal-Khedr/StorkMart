package com.example.visionstech.storkmart.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.visionstech.storkmart.Fragment.LoginFragment;
import com.example.visionstech.storkmart.Fragment.RegisterFragment;
import com.example.visionstech.storkmart.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {



    @BindView(R.id.login_btn_Login)
    Button btn_loginTab;

    @BindView(R.id.login_btn_RegisterNewAccount)

    Button btn_RegistrTab;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        StatusBarUtil.setTransparent(LoginActivity.this);


        switchpage(new LoginFragment());
        btn_loginTab.setOnClickListener(this);
        btn_RegistrTab.setOnClickListener(this);



    }




    public void switchpage(Fragment fragment) {




        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.activity_Login_frame,fragment);
        transaction.commit();


    }

    @Override
    public void onClick(View v) {

        int viewId = v.getId();
        if (viewId == R.id.login_btn_Login) {


            switchpage(new LoginFragment());



        } else if (viewId == R.id.login_btn_RegisterNewAccount){


            switchpage(new RegisterFragment());


        }





    }
}
