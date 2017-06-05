package xdesign.weatherapp.api;

/**
 * Created by gcslo on 6/3/2017.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DarkSkyClient
{

    //API KEY f0307727ac52126cd7fa087e80f102cf
    public static final String BASE_URL = "https://api.darksky.net/forecast/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
