package com.trackingapp.data.repositories;

import com.trackingapp.utils.Result;
import com.trackingapp.data.datasources.DataSourceCache;
import com.trackingapp.data.model.User;

public class SignUpRepository {

    /**
     * Volatile keyword is used to modify the value of a variable by different threads.
     * It is also used to make classes thread safe. It means that multiple threads can
     * use a method and instance of the classes at the same time without any problem.
     */
    private DataSourceCache dataSource;
    private static volatile SignUpRepository instance;

    private SignUpRepository(DataSourceCache dataSource){
        this.dataSource = dataSource;
    }

    public static SignUpRepository getInstance(DataSourceCache dataSource){
        if(instance == null){
            instance = new SignUpRepository(dataSource);
        }
        return instance;
    }

    public Result<String> signUp(User user){
        Result<String> result = dataSource.signUp(user);
        return result;
    }

}
