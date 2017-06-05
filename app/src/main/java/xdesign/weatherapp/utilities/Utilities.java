package xdesign.weatherapp.utilities;

import android.graphics.drawable.Drawable;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

import xdesign.weatherapp.R;

//Utilities holds any conversion functions used in multiple classes

public class Utilities
{
    public int getWeatherIcon(String description)
    {
        int drawableID = -1 ;

        switch (description) {

            case "clear-day":
                drawableID = R.drawable.clearday;
                break;

            case "clear-night":
                drawableID = R.drawable.clearnight;
                break;

            case "rain":
                drawableID = R.drawable.rain;
                break;

            case "snow":
                drawableID = R.drawable.snow;
                break;

            case "sleet":
                drawableID = R.drawable.sleet;
                break;

            case "wind":
                drawableID = R.drawable.wind;
                break;

            case "fog":
                drawableID = R.drawable.rain;
                break;

            case "cloudy":
                drawableID = R.drawable.cloudy;
                break;

            case "partly-cloudy-day":
                drawableID =  R.drawable.partlycloudyday;
                break;

            case "partly-cloudy-night":
                drawableID = R.drawable.partlycloudynight;
                break;
        }

        return drawableID;

    }
    public double convertTemperature(double fahrenheit)
    {
        return ((fahrenheit - 32)*5)/9 ;
    }

    public String convertSecondstoTime(long seconds)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateString = formatter.format(new Date(seconds * 1000L));
        return dateString ;
    }

    public String convertSecondstoDate(long seconds)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy");
        String dateString = formatter.format(new Date(seconds * 1000L));
        return dateString ;
    }
}
