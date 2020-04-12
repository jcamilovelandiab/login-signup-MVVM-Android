package com.trackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.trackingapp.data.localstorage.Storage;
import com.trackingapp.ui.auth.login.LoginActivity;
import com.trackingapp.ui.main.MainActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Storage storage = new Storage( this );
        if ( storage.containsToken() ){
            startActivity( new Intent( this, MainActivity.class ) );
        }else{
            startActivity( new Intent( this, LoginActivity.class ) );
        }
        finish();
    }
}
