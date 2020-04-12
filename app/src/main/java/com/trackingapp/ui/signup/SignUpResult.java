package com.trackingapp.ui.signup;

import androidx.annotation.Nullable;


/**
 * This class was made to track the outcome of the registration
 */
public class SignUpResult {

    @Nullable
    private String success;

    @Nullable
    private Integer error;

    public SignUpResult(@Nullable String success) {
        this.success = success;
    }

    public SignUpResult(@Nullable Integer error) {
        this.error = error;
    }

    @Nullable
    public String getSuccess() {
        return success;
    }

    public void setSuccess(@Nullable String success) {
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
