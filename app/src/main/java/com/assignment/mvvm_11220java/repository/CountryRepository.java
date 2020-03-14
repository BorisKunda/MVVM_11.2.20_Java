package com.assignment.mvvm_11220java.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.assignment.mvvm_11220java.model.Country;
import com.assignment.mvvm_11220java.network.CountryApi;
import com.assignment.mvvm_11220java.network.OnServerResponseListener;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.Arrays;
import java.util.List;

public class CountryRepository {

    private MutableLiveData<List<Country>> mCountryListMLD;
    private static CountryRepository mCountryRepository = null;
    private CountryApi mCountryApi;
    private Application mApplication;

    private CountryRepository (Application iApplication) {
        mCountryApi = CountryApi.getCountryApi(iApplication);
    }

    synchronized public static CountryRepository getCountryRepository (Application iApplication) {

        if (mCountryRepository == null) {
            mCountryRepository = new CountryRepository(iApplication);
        }

        return mCountryRepository;
    }

    public MutableLiveData<List<Country>> getCountryListMLD () {

        if (mCountryListMLD == null) {
            mCountryListMLD = new MutableLiveData<>();
        }

        return mCountryListMLD;
    }

    public void loadCountriesListFromApi () {

        mCountryApi.getCountryList((isSuccess, response) -> {

            if (isSuccess) {
                Gson gson = new Gson();
                Country[] countries = gson.fromJson(String.valueOf(response), Country[].class);
                mCountryListMLD.setValue(Arrays.asList(countries));
            }

        });
    }

}
