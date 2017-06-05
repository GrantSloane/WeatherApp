package xdesign.weatherapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import xdesign.weatherapp.R;
import xdesign.weatherapp.model.HourData;
import xdesign.weatherapp.utilities.Utilities;

public class AdditionalInfoActivity extends AppCompatActivity {

    private Utilities utils = new Utilities() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_information);

        String jsonHourObject;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jsonHourObject = extras.getString("myObject");
            HourData hour = new Gson().fromJson(jsonHourObject, HourData.class);

            ImageView icon = (ImageView) findViewById(R.id.icon);
            icon.setImageResource(utils.getWeatherIcon(hour.getIcon()));

            TextView date = (TextView) findViewById(R.id.date) ;
            date.setText(utils.convertSecondstoDate(hour.getTime()));

            TextView time = (TextView) findViewById(R.id.time) ;
            time.setText(utils.convertSecondstoTime(hour.getTime()));

            TextView temperature = (TextView) findViewById(R.id.temperature) ;
            temperature.setText(String.format("%.2f", utils.convertTemperature(hour.getTemperature())) + " \u2103");

            TextView summary = (TextView) findViewById(R.id.summary) ;
            summary.setText(hour.getSummary());

            //If there is no rain there is no precipitation type so do not show it
            LinearLayout lyt_precipitation = (LinearLayout) findViewById(R.id.lyt_precipitation) ;
            String precipitationType =  hour.getPrecipType() ;
            if(precipitationType != null) {
                TextView precipitation = (TextView) findViewById(R.id.precipitation);
                precipitation.setText(String.format("%.0f", hour.getPrecipProbability() * 100) + "% chance of " + precipitationType);
            }
            else lyt_precipitation.setVisibility(View.GONE);

            TextView feelsLike = (TextView) findViewById(R.id.feels_like) ;
            feelsLike.setText(String.format("%.2f", utils.convertTemperature(hour.getApparentTemperature())) + " \u2103");

            Double hourWindSpeed= hour.getWindSpeed() ;
            TextView windSpeed = (TextView) findViewById(R.id.wind_speed) ;
            windSpeed.setText(String.format("%.2f", hourWindSpeed) + " mph");

            //If there is no wind there is no wind bearing type so do not show it
            LinearLayout lyt_wind_bearing = (LinearLayout) findViewById(R.id.lyt_wind_bearing) ;
            if(hourWindSpeed > 0) {
                TextView windBearing = (TextView) findViewById(R.id.wind_bearing);
                windBearing.setText(Integer.toString(hour.getWindBearing()) + " \u00B0");
            }
            else lyt_wind_bearing.setVisibility(View.GONE);

        }



    }
}
