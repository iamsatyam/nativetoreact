package com.sat.userinfo.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.sat.userinfo.dataHelper.DataStorageHelper;
import com.sat.userinfo.model.ModelUser;

import org.jetbrains.annotations.NotNull;

public class UserInfoRNBridge extends ReactContextBaseJavaModule {
    public UserInfoRNBridge(ReactApplicationContext context) {
        super(context);
    }

    @NotNull
    @Override
    public String getName() {
        return "UserInfoBridge";
    }

    @ReactMethod
    public void getUserInfoData(Promise promise) {
        try{
            String userData = DataStorageHelper.getStringValue(DataStorageHelper.SP_USER_INFO);
            promise.resolve(userData);
        } catch (Exception e){
            promise.reject("Error", e);
        }
    }

    @ReactMethod
    public void setUserInfoData(String name, String phone, String city) {
        ModelUser modelUser = new ModelUser(name, phone, city);
        DataStorageHelper.addUserInfo(modelUser);
    }
}
