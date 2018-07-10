package com.foodplus.foodplus.data.remote;

import android.support.annotation.Nullable;

import com.foodplus.foodplus.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersService {

    @GET("users")
    public Call<List<User>> getUsers(@Nullable @Query("userType") String userType);

}
