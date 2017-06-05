package xdesign.weatherapp.model;

import com.google.gson.annotations.SerializedName;

//This class holds all the weather information of each hour

public class HourData
{
    @SerializedName("time")
    private int time;
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("precipIntensity")
    private double precipIntensity;
    @SerializedName("precipProbability")
    private double precipProbability;
    @SerializedName("precipType")
    private String precipType;
    @SerializedName("temperature")
    private double temperature;
    @SerializedName("apparentTemperature")
    private double apparentTemperature;
    @SerializedName("dewPoint")
    private double dewPoint;
    @SerializedName("humidity")
    private double humidity;
    @SerializedName("windSpeed")
    private double windSpeed;
    @SerializedName("windBearing")
    private int windBearing;
    @SerializedName("cloudCover")
    private double cloudCover;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("ozone")
    private double ozone;

    public void setTime(int time){
        this.time = time;
    }
    public int getTime(){
        return this.time;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }
    public String getSummary(){
        return this.summary;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public String getIcon(){
        return this.icon;
    }
    public void setPrecipIntensity(double precipIntensity){
        this.precipIntensity = precipIntensity;
    }
    public double getPrecipIntensity(){
        return this.precipIntensity;
    }
    public void setPrecipProbability(double precipProbability){
        this.precipProbability = precipProbability;
    }
    public double getPrecipProbability(){
        return this.precipProbability;
    }
    public void setPrecipType(String precipType){
        this.precipType = precipType;
    }
    public String getPrecipType(){
        return this.precipType;
    }
    public void setTemperature(double temperature){
        this.temperature = temperature;
    }
    public double getTemperature(){
        return this.temperature;
    }
    public void setApparentTemperature(double apparentTemperature){
        this.apparentTemperature = apparentTemperature;
    }
    public double getApparentTemperature(){
        return this.apparentTemperature;
    }
    public void setDewPoint(double dewPoint){
        this.dewPoint = dewPoint;
    }
    public double getDewPoint(){
        return this.dewPoint;
    }
    public void setHumidity(double humidity){
        this.humidity = humidity;
    }
    public double getHumidity(){
        return this.humidity;
    }
    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }
    public double getWindSpeed(){
        return this.windSpeed;
    }
    public void setWindBearing(int windBearing){
        this.windBearing = windBearing;
    }
    public int getWindBearing(){
        return this.windBearing;
    }
    public void setCloudCover(double cloudCover){
        this.cloudCover = cloudCover;
    }
    public double getCloudCover(){
        return this.cloudCover;
    }
    public void setPressure(double pressure){
        this.pressure = pressure;
    }
    public double getPressure(){
        return this.pressure;
    }
    public void setOzone(double ozone){
        this.ozone = ozone;
    }
    public double getOzone(){
        return this.ozone;
    }
}