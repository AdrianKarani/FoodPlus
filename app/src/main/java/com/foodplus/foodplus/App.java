package com.foodplus.foodplus;

import android.app.Application;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.foodplus.foodplus.data.SharedPrefs;
import com.foodplus.foodplus.data.SharedPrefsImpl;
import com.foodplus.foodplus.data.remote.NetworkProvider;

import timber.log.Timber;

public class App extends Application{

    public SharedPrefs sharedPrefs;
    public NetworkProvider networkProvider;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree() {
            @Override
            protected String createStackElementTag(@NonNull StackTraceElement element) {
                return "Timber/" + element.getFileName() + "." + element.getMethodName() + "(Ln" + element.getLineNumber() + ")";
            }
        });

        networkProvider = new NetworkProvider();
        sharedPrefs = new SharedPrefsImpl(PreferenceManager.getDefaultSharedPreferences(this));
    }


}
