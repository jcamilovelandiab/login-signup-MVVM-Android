package com.trackingapp.data.repositories;

import com.trackingapp.data.localstorage.DataSourceCache;
import com.trackingapp.data.entities.User;
import com.trackingapp.data.model.LoggedInUser;
import com.trackingapp.utils.Result;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class UserRepository {

    private static volatile UserRepository instance;
    private DataSourceCache dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;

    // private constructor : singleton access
    private UserRepository(DataSourceCache dataSource) {
        this.dataSource = dataSource;
    }

    public static UserRepository getInstance(DataSourceCache dataSource) {
        if (instance == null) {
            instance = new UserRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<LoggedInUser> login(String username, String password) {
        // handle login
        Result<LoggedInUser> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<LoggedInUser>) result).getData());
        }
        return result;
    }

    public Result<LoggedInUser> signup(User user){
        Result<LoggedInUser> result = dataSource.signUp(user);
        if(result instanceof Result.Success){
            setLoggedInUser(((Result.Success<LoggedInUser>) result).getData());
        }
        return result;
    }

}