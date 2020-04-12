package com.trackingapp.ui.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.trackingapp.R;

public class SignUpActivity extends AppCompatActivity {

    Button btn_login, btn_sign_up;
    EditText et_full_name, et_email, et_password, et_confirm_password;
    ProgressBar pg_loading;
    SignUpViewModel signUpViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        connectViewWithModel();
        configureTextWatchers();
    }

    private void connectViewWithModel(){
        btn_login = findViewById(R.id.signup_btn_sign_in);
        btn_sign_up = findViewById(R.id.signup_btn_sign_up);
        et_full_name = findViewById(R.id.signup_et_full_name);
        et_email = findViewById(R.id.signup_et_email);
        et_password = findViewById(R.id.signup_et_password);
        et_confirm_password = findViewById(R.id.signup_et_confirm_password);
        pg_loading = findViewById(R.id.signup_pg_loading);
    }

    private void configureTextWatchers() {
        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
    }

    private void configureLoginButton(){

    }



}
