package com.example.visionstech.storkmart.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.example.visionstech.storkmart.Activity.AfterSplashActivity;
import com.example.visionstech.storkmart.Activity.ForgetPasswordActivity;
import com.example.visionstech.storkmart.Activity.RegisterActivity;
import com.example.visionstech.storkmart.Model.LoginResponse;
import com.example.visionstech.storkmart.Model.RegisterModel;
import com.example.visionstech.storkmart.R;
import com.example.visionstech.storkmart.Rest.ApiClient;
import com.example.visionstech.storkmart.Rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends android.app.Fragment implements View.OnClickListener {

    @BindView(R.id.btn_forgetPassword)
    Button forgetPassword;

    @BindView(R.id.layoutEdtLoginPassword)
    TextInputLayout containerEdtLoginPassword;

    @BindView(R.id.edtLoginPassword)
    TextInputEditText LoginUserPassword;


    @BindView(R.id.layoutEdtLoginEmail)
    TextInputLayout containerLoginUserEmail;


    @BindView(R.id.edtLoginEmail)
    TextInputEditText LoginUserEmail;


    @BindView(R.id.layoutLoginPhone)
    TextInputLayout containerLoginUserPhone;


    @BindView(R.id.edtLoginPhone)
    TextInputEditText LoginuserPhone;




    @BindView(R.id.btn_Login)
    Button userLogin;

    @BindView(R.id.btn_HomeEnterAsAVisitr)
    Button userLoginAsAvisitor;
    private String userPassword;
    private String userEmail;
    private String userPhone;

    public static String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    LoginResponse loginResponse;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this,view);

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), ForgetPasswordActivity.class));}
        });




        userLogin.setOnClickListener(this);





        return view;
    }


    public void validation() {


        userPassword = LoginuserPhone.getText().toString();
        userEmail = LoginUserEmail.getText().toString();
        userPhone = LoginuserPhone.getText().toString();


     if (TextUtils.isEmpty(userPhone)) {
         containerLoginUserPhone.setError("Enter Th Phone number");
         containerLoginUserPhone.requestFocus();

        } else if (userPhone.length()<9) {
         containerLoginUserPhone.setError("Invalid Phone number");
         containerLoginUserPhone.requestFocus();

        }else if (!userPhone.matches(loginResponse.getUser().getPhone())){


         containerLoginUserPhone.setError("Invalid Phone number");
         containerLoginUserPhone.requestFocus();
     }

        else if ( TextUtils.isEmpty(userEmail)) {
            containerLoginUserEmail.setError("Enter The Email Address");
            containerLoginUserEmail.requestFocus();

        } else if (!userEmail.matches(emailPattern)) {
            containerLoginUserEmail.setError("Invalid Email");
            containerLoginUserEmail.requestFocus();


        }  else if (!userEmail.matches(loginResponse.getUser().getEmail())){


         containerLoginUserEmail.setError("Invalid Email");
         containerLoginUserEmail.requestFocus();
    }

     else if ( TextUtils.isEmpty(userPassword)) {
            containerEdtLoginPassword.setError("Enter The Password");
            containerEdtLoginPassword.requestFocus();

        }

        else if (userPassword.length() < 6 ) {
            containerEdtLoginPassword.setError("Invalid password");
            containerEdtLoginPassword.requestFocus();

        }


     else {

//            Toast.makeText(this, "Login Successfull", Toast.LENGTH_LONG).show();


            Call<LoginResponse> call = apiService.Login(userEmail, userPassword, "device_type", "device_token", 1,1);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

//

                    String x = response.body().getMessageEn().toString();
                    Toast.makeText(getActivity(), x, Toast.LENGTH_LONG).show();


                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    String y = t.getMessage().toString();
                    Toast.makeText(getActivity(), y, Toast.LENGTH_LONG).show();

                }
            });
        }


    }










    @Override
    public void onClick(View v) {
        validation();

    }
}
