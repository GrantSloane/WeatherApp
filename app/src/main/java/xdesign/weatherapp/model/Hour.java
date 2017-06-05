package xdesign.weatherapp.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Hour {

    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("data")
    private List<HourData> data;

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
    public void setData(List<HourData> data){
        this.data = data;
    }
    public List<HourData> getData(){
        return this.data;
    }

}
