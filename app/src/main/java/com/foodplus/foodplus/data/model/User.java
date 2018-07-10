package com.foodplus.foodplus.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

public class User implements Parcelable{

    public String userId;
    public String email;
    public String firstName;
    public String lastName;
    @Nullable
    public String password;
    public String userType;

    public static int USER_ADMIN = 1;
    public static int USER_MESSENGER = 2;
    public static int USER_SHOPPER = 3;

    public User(String email, String firstName, String lastName, @Nullable String password, int userType) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        if (userType == USER_ADMIN) {
            this.userType = "ADMIN";
        } else if (userType == USER_SHOPPER) {
            this.userType = "SHOPPER";
        } else {
            this.userType = "MESSENGER";
        }
    }

    public User(String userId, String email, String firstName, String lastName, @Nullable String password, String userType) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.email);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.password);
        dest.writeString(this.userType);
    }

    protected User(Parcel in) {
        this.userId = in.readString();
        this.email = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.password = in.readString();
        this.userType = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


}
