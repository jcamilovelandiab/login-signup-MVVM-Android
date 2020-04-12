package com.trackingapp.data.datasources;

import com.trackingapp.utils.Result;
import com.trackingapp.data.model.LoggedInUser;
import com.trackingapp.data.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class DataSourceCache {

    Map<String, User> users = new HashMap<>();

    public Result<LoggedInUser> login(String email, String password) {
        try {
            // TODO: handle loggedInUser authentication
            if(users.containsKey(email) && users.get(email).getPassword().equals(password)){
                LoggedInUser loggedInUser = new LoggedInUser(users.get(email).getUserId(), email);
                return new Result.Success<>(loggedInUser);
            }
            return new Result.Error(new IOException("Invalid login"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public Result<String> signUp(User user){
        if(users.containsKey(user.getEmail())){
            return new Result.Error(new IOException("Email has been already taken!"));
        }
        user.setUserId(java.util.UUID.randomUUID().toString());
        users.put(user.getEmail(), user);
        return new Result.Success<>("Signed up successfully!");
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
