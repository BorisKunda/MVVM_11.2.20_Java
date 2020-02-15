package com.assignment.mvvm_11220java.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.assignment.mvvm_11220java.model.Country;
import com.assignment.mvvm_11220java.repository.CountryRepository;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {

    private CountryRepository countryRepository;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        countryRepository = new CountryRepository(application);
    }

    public LiveData<List<Country>> getCountryListLD() {
        return countryRepository.getCountryListMLD();
    }

    public void loadCountriesList() {
        countryRepository.loadCountriesListFromApi();
    }

}
