package com.assignment.mvvm_11220java.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.mvvm_11220java.R;
import com.assignment.mvvm_11220java.viewmodel.CountryViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private CountryViewModel mCountryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();

        mCountryViewModel.loadCountriesList();

        mCountryViewModel.getCountryListLD().observe(this, countries -> {

            mAdapter.setAdapterData(countries);

        });


    }

    private void initUi() {
        setRV();
        setViewModel();
    }

    private void setRV() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new CountryAdapter();
        recyclerView.setAdapter(mAdapter);
    }

    private void setViewModel() {
        mCountryViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(CountryViewModel.class);
    }

}
