package com.assignment.mvvm_11220java;

import android.app.Application;

import com.assignment.mvvm_11220java.repository.CountryRepository;

public class CountryApplication extends Application {

    @Override
    public void onCreate () {
        super.onCreate();
        /**instantiate repository immediately at app instance creation */
        CountryRepository.getCountryRepository(this);
    }

}
