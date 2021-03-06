package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Oluwatimilehin on 04/05/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter
        .ForecastAdapterViewHolder> {

    private String mWeatherData[];

    public void setWeatherData(String weatherData[]){
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    public ForecastAdapter(){

    }


    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{

        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view){
            super(view);

            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.forecast_list_item, parent, false);

        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {
        if(mWeatherData == null){
            return  0;
        }
        return mWeatherData.length;
    }
}
