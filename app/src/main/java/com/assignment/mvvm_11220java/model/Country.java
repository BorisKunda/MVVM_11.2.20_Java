package com.assignment.mvvm_11220java.model;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName ("name")
    private String mCountryName;

    public String getCountryName () {
        return mCountryName;
    }

}
