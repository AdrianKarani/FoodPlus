package com.foodplus.foodplus.data;

import android.content.SharedPreferences;
import com.foodplus.foodplus.data.model.User;

public class SharedPrefsImpl implements SharedPrefs{

    private static final String KEY_LOGGED_IN = "logged_in";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_EMAIL = "user_email";
    private static final String KEY_FIRST_NAME = "user_first_name";
    private static final String KEY_LAST_NAME = "user_last_name";
    private static final String KEY_PASSWORD = "user_password";
    private static final String KEY_USER_TYPE = "user_type";

    private SharedPreferences sharedPreferences;

    public SharedPrefsImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void setLoggedInStatus(Boolean loggedIn) {
        sharedPreferences.edit()
                .putBoolean(KEY_LOGGED_IN,loggedIn)
                .apply();
    }

    @Override
    public Boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_LOGGED_IN, false);
    }

    @Override
    public void saveUser(User user) {
        sharedPreferences.edit()
                .putString(KEY_USER_ID, user.userId)
                .putString(KEY_EMAIL, user.email)
                .putString(KEY_FIRST_NAME, user.firstName)
                .putString(KEY_LAST_NAME, user.lastName)
                .putString(KEY_PASSWORD, user.password)
                .putString(KEY_USER_TYPE, user.userType)
                .apply();
    }


    }



