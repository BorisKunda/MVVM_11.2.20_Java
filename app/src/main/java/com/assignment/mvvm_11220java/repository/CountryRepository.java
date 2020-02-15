package com.assignment.mvvm_11220java.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.assignment.mvvm_11220java.model.Country;
import com.assignment.mvvm_11220java.network.CountryApi;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class CountryRepository {

    private MutableLiveData<List<Country>> countryListMLD;
    private CountryApi countryApi;
    private Application application;

    public CountryRepository(Application application) {
        countryApi = new CountryApi(application);
        this.application = application;
    }

    public MutableLiveData<List<Country>> getCountryListMLD() {

        if (countryListMLD == null) {
            countryListMLD = new MutableLiveData<>();
        }

        return countryListMLD;
    }

    public void loadCountriesListFromApi() {
        countryApi.getCountryList((isSuccess, response) -> {

            Gson gson = new Gson();
            Country[] countries = gson.fromJson(String.valueOf(response), Country[].class);
            countryListMLD.setValue(Arrays.asList(countries));

        });
    }

}
