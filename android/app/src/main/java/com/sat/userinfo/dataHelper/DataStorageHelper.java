package com.sat.userinfo.dataHelper;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sat.userinfo.UserApplication;
import com.sat.userinfo.model.ModelUser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataStorageHelper {

    public static String SP_USER_INFO = "SP_USER_INFO";

    public static void setStringValue(String key, String data) {
        try {
            SharedPreferences.Editor editor = UserApplication.getInstance().getSharedPrefs().edit();
            editor.putString(key, data);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStringValue(String key) {
        try {
            return UserApplication.getInstance().getSharedPrefs().getString(key, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void clearData() {
        if (UserApplication.getInstance() != null
                && UserApplication.getInstance().getSharedPrefs() != null) {
            SharedPreferences.Editor editor = UserApplication.getInstance().getSharedPrefs().edit();
            editor.remove(SP_USER_INFO);
            editor.commit();
        }
    }

    public static void addUserInfo(ModelUser modelUser) {
        if (modelUser != null) {
            Type listType = new TypeToken<List<ModelUser>>() {
            }.getType();

            Gson gson = new Gson();
            List<ModelUser> userList = new ArrayList<>();
            String userData = DataStorageHelper.getStringValue(DataStorageHelper.SP_USER_INFO);
            if (!userData.isEmpty()) {
                userList = gson.fromJson(userData, listType);
            }
            userList.add(modelUser);
            String jsonString = gson.toJson(userList, listType);
            setStringValue(SP_USER_INFO, jsonString);
        }
    }

    public static List getUserInfo() {
        List<ModelUser> userList = new ArrayList<>();
        Type listType = new TypeToken<List<ModelUser>>() {
        }.getType();

        String userData = DataStorageHelper.getStringValue(DataStorageHelper.SP_USER_INFO);
        if (!userData.isEmpty()) {
            userList = new Gson().fromJson(userData, listType);
        }
        return userList;
    }

}
