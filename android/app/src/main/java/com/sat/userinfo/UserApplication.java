package com.sat.userinfo;

import android.app.Application;
import android.content.SharedPreferences;

public class UserApplication extends Application {

    private static UserApplication mInstance;
    private SharedPreferences sharedPrefs;
    private static final String SHARED_PREF_NAME = "userInfo";

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        init();
    }

    private void init() {
        sharedPrefs = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
    }

    public static synchronized UserApplication getInstance() {
        return mInstance;
    }

    public SharedPreferences getSharedPrefs() {
        return sharedPrefs;
    }
}
