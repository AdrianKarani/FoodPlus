package com.foodplus.foodplus.data.remote;

import com.foodplus.foodplus.data.model.ApiResponse;
import com.foodplus.foodplus.data.model.LoginResponse;
import com.foodplus.foodplus.data.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthService {

    @POST("auth/register")
    Call<User> register(@Body User user);

    @POST("auth/login")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("auth/logout")
    @FormUrlEncoded
    Call<ApiResponse> logout(@Field("token") String token);

    @POST("auth/change-password")
    @FormUrlEncoded
    Call<ApiResponse> changePassword(@Field("email") String email, @Field("currentPassword") String currentPassword, @Field("newPassword") String newPassword);

}
