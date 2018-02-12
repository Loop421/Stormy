package com.mongo.stormy.ui;

import android.app.ListActivity;
import android.os.Bundle;

import com.mongo.stormy.R;
import com.mongo.stormy.adapters.DayAdapter;
import com.mongo.stormy.weather.Day;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        DayAdapter adapter = new DayAdapter(this, mDays);
    }

}
