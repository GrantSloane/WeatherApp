package xdesign.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("offset")
    private int offset;
    @SerializedName("hourly")
    private Hour hourly;

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public void setTimezone(String timezone){
        this.timezone = timezone;
    }
    public String getTimezone(){
        return this.timezone;
    }
    public void setOffset(int offset){
        this.offset = offset;
    }
    public int getOffset(){
        return this.offset;
    }
    public void setHourly(Hour hourly){
        this.hourly = hourly;
    }
    public Hour getHourly(){
        return this.hourly;
    }

}
