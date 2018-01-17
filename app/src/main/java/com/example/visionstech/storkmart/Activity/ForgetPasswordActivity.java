package com.example.visionstech.storkmart.Activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.visionstech.storkmart.Model.ForgetPasswordResponse;
import com.example.visionstech.storkmart.R;
import com.example.visionstech.storkmart.Rest.ApiClient;
import com.example.visionstech.storkmart.Rest.ApiInterface;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    public static String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private String userEmail;
    @BindView(R.id.btn_forgetPassword_btn)
    Button btn_forgetPasswordActivity_btn;



    @BindView(R.id.edt_forgetPassword_emailLayout)
    TextInputLayout containerforgetPasswordUserEmail;


    @BindView(R.id.edt_forgetPassword_email)
    TextInputEditText forgetPasswordEmail;
    ForgetPasswordResponse  forgetPasswordResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
        StatusBarUtil.setTransparent(ForgetPasswordActivity.this);

        btn_forgetPasswordActivity_btn.setOnClickListener(this);

    }













    public void validation() {



        userEmail = forgetPasswordEmail.getText().toString();




   if ( TextUtils.isEmpty(userEmail)) {
       containerforgetPasswordUserEmail.setError("Enter The Email Address");
       containerforgetPasswordUserEmail.requestFocus();

        } else if (!userEmail.matches(emailPattern)) {
       containerforgetPasswordUserEmail.setError("Invalid Email");
       containerforgetPasswordUserEmail.requestFocus();


        }

   else {

//            Toast.makeText(this, "Login Successfull", Toast.LENGTH_LONG).show();

       ApiInterface apiService =
               ApiClient.getClient().create(ApiInterface.class);
            Call<ForgetPasswordResponse> call = apiService.forgetPassword(userEmail);
            call.enqueue(new Callback<ForgetPasswordResponse>() {
                @Override
                public void onResponse(Call<ForgetPasswordResponse> call, Response<ForgetPasswordResponse> response) {

//

                    String x = response.body().getMessageEn().toString();
                    Toast.makeText(ForgetPasswordActivity.this, x, Toast.LENGTH_LONG).show();


                }

                @Override
                public void onFailure(Call<ForgetPasswordResponse> call, Throwable t) {
                    String y = t.getMessage().toString();
                    Toast.makeText(ForgetPasswordActivity.this, y, Toast.LENGTH_LONG).show();

                }
            });
        }


    }


    @Override
    public void onClick(View v) {
        validation();
    }
}
