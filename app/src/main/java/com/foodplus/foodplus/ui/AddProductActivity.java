package com.foodplus.foodplus.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.foodplus.foodplus.App;
import com.foodplus.foodplus.R;
import com.foodplus.foodplus.data.SharedPrefs;
import com.foodplus.foodplus.data.remote.NetworkProvider;


public class AddProductActivity extends AppCompatActivity {

    private NetworkProvider networkProvider;
    private SharedPrefs sharedPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


        networkProvider = ((App) getApplication()).networkProvider;
        sharedPrefs = ((App) getApplication()).sharedPrefs;


        // Check if user is logged in
        if(!sharedPrefs.isLoggedIn()){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }
}
