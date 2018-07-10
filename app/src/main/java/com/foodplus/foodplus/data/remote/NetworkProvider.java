package com.foodplus.foodplus.data.remote;

import com.foodplus.foodplus.data.model.ApiResponse;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkProvider {

    //    private String BASE_URL = "https://HEROKU-APP/FOODPLUS";
    private String BASE_URL = "http://12b08d48.ngrok.io";
    public UsersService usersService;
    public AuthService authService;
    private Converter<ResponseBody, ApiResponse> converter;

    public NetworkProvider() {
        usersService = provideRetrofit(BASE_URL).create(UsersService.class);
        authService = provideRetrofit(BASE_URL).create(AuthService.class);

        converter=provideRetrofit(BASE_URL).responseBodyConverter(ApiResponse.class, new Annotation[0]);

    }


    private Retrofit provideRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient())
                .build();
    }

    private OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }


    public ApiResponse parseError(Response<?> response) {
        ApiResponse error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ApiResponse();
        }

        return error;
    }
}


