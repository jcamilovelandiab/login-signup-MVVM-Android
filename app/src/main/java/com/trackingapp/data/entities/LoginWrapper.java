package com.trackingapp.data.entities;

public class LoginWrapper {
    final String email;
    final String password;

    public LoginWrapper( String email, String password ){
        this.email = email;
        this.password = password;
    }
}
