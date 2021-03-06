package com.mongo.stormy.adapters;


import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mongo.stormy.R;
import com.mongo.stormy.weather.Day;

public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;// we aren't going to use this. Tag items for easy reference
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            // brand new
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);

            holder = new ViewHolder();
            holder.iconImageView = convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = convertView.findViewById(R.id.dayNameLabel);
            holder.circleImageView = convertView.findViewById(R.id.circleImageView);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];

        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax() + "");

        if (position == 0) {
            holder.dayLabel.setText("Today");
        }
        else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }

        holder.circleImageView.setImageResource(day.getCircleImageView());

        return convertView;
    }

    private static class ViewHolder {
        ImageView iconImageView; // public by default
        ImageView circleImageView;
        TextView temperatureLabel;
        TextView dayLabel;
    }
}
