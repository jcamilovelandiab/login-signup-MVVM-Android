package com.trackingapp.ui.auth;

import android.provider.ContactsContract;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.trackingapp.data.localstorage.DataSourceCache;
import com.trackingapp.data.repositories.UserRepository;
import com.trackingapp.ui.auth.login.LoginViewModel;
import com.trackingapp.ui.auth.signup.SignUpViewModel;

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(UserRepository.getInstance(new DataSourceCache()));
        } else if(modelClass.isAssignableFrom(SignUpViewModel.class)) {
            return (T) new SignUpViewModel(UserRepository.getInstance(new DataSourceCache()));
        }else{
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
