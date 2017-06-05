package xdesign.weatherapp.api;


import xdesign.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DarkSkyInterface
{
    //I have manually put the coordinates of Edinburgh, if location based, the location would be retireved and passed here as parameters
    @GET("{api}/55.9533,3.1883?exclude=currently,flags,daily")
    Call<WeatherResponse> getWeatherDetails(@Path("api") String key);

}
