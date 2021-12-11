package com.sat.userinfo.model;

import com.google.gson.Gson;

public class ModelUser {

    private String name;
    private String phone;
    private String city;

    public ModelUser(String name, String phone, String city) {
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
