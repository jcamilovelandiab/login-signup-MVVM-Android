package com.trackingapp.ui.auth.signup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.trackingapp.data.localstorage.DataSourceCache;
import com.trackingapp.data.repositories.UserRepository;

public class SignUpViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(SignUpViewModel.class)){
            return (T) new SignUpViewModel(UserRepository.getInstance(new DataSourceCache()));
        }else{
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }

}
