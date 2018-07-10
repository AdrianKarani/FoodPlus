package com.foodplus.foodplus.data.model;

public class LoginResponse {

    public String token;
    public User user;

    public LoginResponse(String token) {
        this.token = token;
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
