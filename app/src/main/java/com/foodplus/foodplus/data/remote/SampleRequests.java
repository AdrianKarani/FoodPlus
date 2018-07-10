package com.foodplus.foodplus.data.remote;

import com.foodplus.foodplus.data.model.ApiResponse;
import com.foodplus.foodplus.data.model.LoginResponse;
import com.foodplus.foodplus.data.model.User;
import com.foodplus.foodplus.data.remote.AuthService;
import com.foodplus.foodplus.data.remote.NetworkProvider;
import com.foodplus.foodplus.data.remote.UsersService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class SampleRequests {
    private NetworkProvider networkProvider = new NetworkProvider();
    private UsersService usersService = networkProvider.usersService;
    private AuthService authService = networkProvider.authService;

    private void register(){
        authService.register(new User("sample@mail.com", "fName", "lName", "abc123", User.USER_ADMIN))
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            Timber.d(response.body().toString());
                        } else {
                            ApiResponse apiResponse = networkProvider.parseError(response);
                            Timber.d(apiResponse.message);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Timber.d(t);
                    }
                });
    }

    private void login(){
        authService.login("sample@mail.com", "abc1232").enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    Timber.d(response.body().toString());
                } else {
                    ApiResponse apiResponse = networkProvider.parseError(response);
                    Timber.d(apiResponse.message);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Timber.d(t);
            }
        });
    }

    private void changePassword(){
        authService.changePassword("sample@mail.com", "abc1232", "abc123").enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    Timber.d(response.body().toString());
                } else {
                    ApiResponse apiResponse = networkProvider.parseError(response);
                    Timber.d(apiResponse.message);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Timber.d(t);
            }
        });
    }

    private void logout(){
        authService.logout("token").enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    Timber.d(response.body().toString());
                } else {
                    ApiResponse apiResponse = networkProvider.parseError(response);
                    Timber.d(apiResponse.message);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Timber.d(t);
            }
        });
    }



    private void getUsers(){
        usersService.getUsers("SHOPPER").enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Timber.d(Integer.toString(response.code()));
                if (response.body() != null) {
                    for (User user : response.body()){
                        Timber.d(user.toString());
                    }
                }else {
                    Timber.d("Users is null");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Timber.e(t);
            }
        });
    }

}

