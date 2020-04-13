package com.trackingapp.ui.auth.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.trackingapp.R;
import com.trackingapp.data.entities.User;
import com.trackingapp.data.model.LoggedInUser;
import com.trackingapp.data.repositories.UserRepository;
import com.trackingapp.ui.auth.login.LoggedInUserView;
import com.trackingapp.utils.Result;
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
            signUpFormState.setValue(new SignUpFormState(null, R.string.invalid_email, null, null));
        }else if(!Validator.isPasswordValid(password)){
            signUpFormState.setValue(new SignUpFormState(null, null, R.string.invalid_password, null));
        }else if(!Validator.isConfirmPasswordValid(password, confirm_password)){
            signUpFormState.setValue(new SignUpFormState(null, null, null, R.string.invalid_confirmation_password));
        }else{
            signUpFormState.setValue(new SignUpFormState(true));
        }
    }

    public void signup(String full_name, String email, String password){
        User user = new User(full_name, email, password);
        Result<LoggedInUser> result = userRepository.signup(user);
        if(result instanceof Result.Success){
            LoggedInUser loggedInUser = ((Result.Success<LoggedInUser>) result).getData();
            signUpResult.setValue(new SignUpResult(new LoggedInUserView(loggedInUser.getDisplayName())));
        }else{
            signUpResult.setValue(new SignUpResult(R.string.sign_up_failed));
        }
    }

}
