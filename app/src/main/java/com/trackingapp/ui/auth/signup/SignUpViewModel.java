package com.trackingapp.ui.auth.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.trackingapp.R;
import com.trackingapp.data.repositories.UserRepository;
import com.trackingapp.utils.Validator;

public class SignUpViewModel extends ViewModel {

    private MutableLiveData<SignUpFormState> signUpFormState = new MutableLiveData<>();
    private MutableLiveData<SignUpResult> signUpResult = new MutableLiveData<>();
    private UserRepository userRepository;

    public SignUpViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LiveData<SignUpFormState> getSignUpFormState() {
        return signUpFormState;
    }

    public void setSignUpFormState(MutableLiveData<SignUpFormState> signUpFormState) {
        this.signUpFormState = signUpFormState;
    }

    public LiveData<SignUpResult> getSignUpResult() {
        return signUpResult;
    }

    public void setSignUpResult(MutableLiveData<SignUpResult> signUpResult) {
        this.signUpResult = signUpResult;
    }

    public void signUpDataChanged(String full_name, String email, String password,  String confirm_password){
        if(!Validator.isNameValid(full_name)){
            signUpFormState.setValue(new SignUpFormState(R.string.invalid_name, null, null, null));
        }else if(!Validator.isEmailValid(email)){
            signUpFormState.setValue(new SignUpFormState(R.string.invalid_email, null, null, null));
        }else if(!Validator.isPasswordValid(password)){
            signUpFormState.setValue(new SignUpFormState(R.string.invalid_password, null, null, null));
        }else if(!Validator.isConfirmPasswordValid(password, confirm_password)){
            signUpFormState.setValue(new SignUpFormState(R.string.invalid_confirmation_password, null, null, null));
        }else{
            signUpFormState.setValue(new SignUpFormState(true));
        }
    }

}
