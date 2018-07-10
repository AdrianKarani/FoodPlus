package com.foodplus.foodplus.data;

import com.foodplus.foodplus.data.model.User;

public interface SharedPrefs {
    void setLoggedInStatus(Boolean loggedIn);
    Boolean isLoggedIn();

    void saveUser(User user);

}
