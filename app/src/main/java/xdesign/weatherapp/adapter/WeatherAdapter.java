package xdesign.weatherapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.Log;
import java.util.List;
import java.lang.String;

import com.google.gson.Gson;

import xdesign.weatherapp.R;
import xdesign.weatherapp.activity.AdditionalInfoActivity;
import xdesign.weatherapp.model.HourData;
import xdesign.weatherapp.utilities.Utilities;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>  {

    private static final String TAG = WeatherAdapter.class.getSimpleName();
    private static List<HourData> hours;
    private int rowLayout;
    private Context context;
    private Utilities utils = new Utilities() ;

    public static class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout weatherLayout;
        TextView time;
        TextView temperature;
        TextView date;
        TextView summary;
        ImageView icon ;
        LinearLayout lyt_date;
        private int itemIndex;

        public WeatherViewHolder(View v) {
            super(v);
            weatherLayout = (LinearLayout) v.findViewById(R.id.weather_layout);
            time = (TextView) v.findViewById(R.id.time);
            temperature = (TextView) v.findViewById(R.id.temperature);
            date = (TextView) v.findViewById(R.id.date);
            summary = (TextView) v.findViewById(R.id.summary);
            icon = (ImageView) v.findViewById(R.id.icon);
            lyt_date = (LinearLayout) v.findViewById(R.id.lyt_date);
            v.setOnClickListener(this);
        }

        public void setItem(int item) {
            itemIndex = item;
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick " + getAdapterPosition() + " >>>>>>>>>>>> " + itemIndex);
            Intent intent = new Intent(view.getContext(), AdditionalInfoActivity.class);
            intent.putExtra("myObject", new Gson().toJson(hours.get(itemIndex)));
            view.getContext(). startActivity(intent);
        }
    }

    public WeatherAdapter(List<HourData> hours, int rowLayout, Context context) {
        this.hours = hours;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, final int position) {

        holder.setItem(position) ;
        holder.time.setText(utils.convertSecondstoTime(hours.get(position).getTime()));
        holder.temperature.setText(String.format("%.2f", utils.convertTemperature(hours.get(position).getTemperature())) + " \u2103");
        holder.summary.setText(hours.get(position).getSummary());
        holder.icon.setImageResource(utils.getWeatherIcon(hours.get(position).getIcon()));

        //Show date if it is the first cell or the start of a new day
        if(position == 0 || utils.convertSecondstoTime(hours.get(position).getTime()).equalsIgnoreCase("00:00"))
        {
            holder.date.setText(utils.convertSecondstoDate(hours.get(position).getTime()));
            holder.lyt_date.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.lyt_date.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return hours.size();
    }
}
