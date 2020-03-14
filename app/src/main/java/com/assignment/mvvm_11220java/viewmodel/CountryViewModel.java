package com.assignment.mvvm_11220java.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.assignment.mvvm_11220java.model.Country;
import com.assignment.mvvm_11220java.repository.CountryRepository;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {

    private CountryRepository mCountryRepository;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        mCountryRepository = CountryRepository.getCountryRepository(application);
    }

    public LiveData<List<Country>> getCountryListLD() {
        return mCountryRepository.getCountryListMLD();
    }

    public void loadCountriesList() {
        mCountryRepository.loadCountriesListFromApi();
    }

}
