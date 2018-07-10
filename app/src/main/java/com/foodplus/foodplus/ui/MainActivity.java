package com.foodplus.foodplus.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.foodplus.foodplus.App;
import com.foodplus.foodplus.R;
import com.foodplus.foodplus.data.remote.NetworkProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkProvider networkProvider = ((App) getApplication()).networkProvider;


    }
}
