package com.trackingapp.ui.auth.signup;

import androidx.annotation.Nullable;

import com.trackingapp.ui.auth.LoggedInUserView;


/**
 * This class was made to track the outcome of the registration
 */
public class SignUpResult {

    @Nullable
    private LoggedInUserView success;

    @Nullable
    private Integer error;

    public SignUpResult(@Nullable LoggedInUserView success) {
        this.success = success;
    }

    public SignUpResult(@Nullable Integer error) {
        this.error = error;
    }

    @Nullable
    public LoggedInUserView getSuccess() {
        return success;
    }

    public void setSuccess(@Nullable LoggedInUserView success) {
        this.success = success;
    }

    @Nullable
    public Integer getError() {
        return error;
    }

    public void setError(@Nullable Integer error) {
        this.error = error;
    }

}
