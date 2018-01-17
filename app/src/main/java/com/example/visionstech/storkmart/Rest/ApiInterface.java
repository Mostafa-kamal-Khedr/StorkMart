package com.example.visionstech.storkmart.Rest;



import com.example.visionstech.storkmart.Model.ForgetPasswordResponse;
import com.example.visionstech.storkmart.Model.LoginResponse;
import com.example.visionstech.storkmart.Model.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiInterface {

   @FormUrlEncoded
    @POST("Register")
    Call<RegisterModel> Register(@Field("name") String name,
                                 @Field("phone") String phone,
                                 @Field("email") String email,
                                 @Field("password") String password,
                                 @Field("device_type") String device_type,
                                 @Field("device_token") String device_token,
                                 @Field("lng") int lang,
                                 @Field("lat") int lat,
                                 @Field("user_type_id") int userId);




    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> Login(
                                 @Field("email") String email,
                                 @Field("password") String password,
                                 @Field("device_type") String device_type,
                                 @Field("device_token") String device_token,
                                 @Field("lat") int lat,
                                 @Field("lng") int lang


    );




    @FormUrlEncoded
    @POST("forget_password")
    Call<ForgetPasswordResponse> forgetPassword(
            @Field("email") String email
    );



}











