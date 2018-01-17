package com.example.visionstech.storkmart.Fragment;


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
public class RegisterFragment extends android.app.Fragment implements View.OnClickListener {

//    @BindView(R.id.appBarTitle)
//    TextView tv_appBarTitle;


    @BindView(R.id.layoutEdtRegisterUserName)
    TextInputLayout containerUserName;


    @BindView(R.id.edtRegisterUserName)
    TextInputEditText RegisterUserName;


    @BindView(R.id.layoutEdtRegisterPassword)
    TextInputLayout containerEdtPassword;

    @BindView(R.id.edtRegisterPassword)
    TextInputEditText RegisterUserPassword;


    @BindView(R.id.RegisterConfirmPassword)
    TextInputLayout containerConfirmPassword;


    @BindView(R.id.edtRegisterConfirmPassword)
    TextInputEditText RegisterUserConfirmPassword;


    @BindView(R.id.layoutEdtRegisterEmail)
    TextInputLayout containerUserEmail;


    @BindView(R.id.edtRegisterEmail)
    TextInputEditText RegisterUserEmail;


    @BindView(R.id.layoutRegisterAddress)
    TextInputLayout containerUserAddress;

    @BindView(R.id.edtRegisterAddress)
    TextInputEditText RegisterUserAddress;


    @BindView(R.id.layoutRegisterPhone)
    TextInputLayout containerUserPhone;


    @BindView(R.id.edtRegisterPhone)
    TextInputEditText RegisteruserPhone;


    @BindView(R.id.btn_signUp)
    Button SignUp;


    public String userName;
    public String userPassword;
    public String userConfirmPassword;
    public String userEmail;
    public String userPhone;
    public String userAddress;


    public static String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public String MY_PREFS_NAME;
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this,view);




        SignUp.setOnClickListener(this);





        return view;
    }


    public void validation() {

        userName = RegisterUserName.getText().toString();
        userPassword = RegisterUserPassword.getText().toString();
        userConfirmPassword = RegisterUserConfirmPassword.getText().toString();
        userEmail = RegisterUserEmail.getText().toString();
        userPhone = RegisteruserPhone.getText().toString();
        userAddress = RegisterUserAddress.getText().toString();


        if ( TextUtils.isEmpty(userName)) {
            containerUserName.setError("Enter The Name");
            containerUserName.requestFocus();

        }else if (userName.length() < 3){
            containerUserName.setError("The Name is Short ");
            containerUserName.requestFocus();

        }else if (TextUtils.isEmpty(userPhone)) {
            containerUserPhone.setError("Enter Th Phone number");
            containerUserPhone.requestFocus();

        } else if (TextUtils.isEmpty(userPhone)) {
            containerUserPhone.setError("Invalid Phone number");
            containerUserPhone.requestFocus();

        }  else if ( TextUtils.isEmpty(userEmail)) {
            containerUserEmail.setError("Enter The Email Address");
            containerUserEmail.requestFocus();

        } else if (!userEmail.matches(emailPattern)) {
            containerUserEmail.setError("Invalid Email");
            containerUserEmail.requestFocus();


        } else if ( TextUtils.isEmpty(userAddress)) {
            containerUserAddress.setError("Enter The Address");
            containerUserAddress.requestFocus();

        }


        else if (userAddress.length() < 3 ) {
            containerUserAddress.setError("Invalid Address");
            containerUserAddress.requestFocus();

        }  else if ( TextUtils.isEmpty(userPassword)) {
            containerEdtPassword.setError("Enter The Password");
            containerEdtPassword.requestFocus();

        }

        else if (userPassword.length() < 6 ) {
            containerEdtPassword.setError("Invalid password");
            containerEdtPassword.requestFocus();

        } else if ( TextUtils.isEmpty(userConfirmPassword)) {
            containerConfirmPassword.setError("Enter ConfirmPassword");
            containerConfirmPassword.requestFocus();

        }

        else if (!userPassword.equals(userConfirmPassword) ) {
            containerConfirmPassword.setError("Password Not matching");
            containerConfirmPassword.requestFocus();

        } else {

//            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show();
//            startActivity(new Intent(SignUp_Activity.this, Login_group_Activity.class));
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            Call<RegisterModel> call = apiService.Register(userName,userPhone ,userEmail, userPassword, "device_type", "device_type", 1,1,2);
            call.enqueue(new Callback<RegisterModel>() {
                @Override
                public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {

//

                    String x = response.body().getMessageAr().toString();
                    Toast.makeText(getActivity(), x, Toast.LENGTH_LONG).show();

//                    startActivity(new Intent(RegisterActivity.this,Home_Activity.class));

                }

                @Override
                public void onFailure(Call<RegisterModel> call, Throwable t) {
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
