package com.assignment.mvvm_11220java.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.mvvm_11220java.R;
import com.assignment.mvvm_11220java.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countryList;

    public CountryAdapter() {
        countryList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_rv_item_row, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
                Country c = countryList.get(position);
                holder.countryNameTv.setText(c.getCountryName());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView countryNameTv;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryNameTv = itemView.findViewById(R.id.country_name_tv);
        }

    }

    public void setAdapterData(List<Country> countryList) {
        this.countryList = countryList;
        notifyDataSetChanged();
    }

}
