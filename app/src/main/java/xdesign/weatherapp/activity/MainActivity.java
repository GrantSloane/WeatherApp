package xdesign.weatherapp.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;
import android.app.ProgressDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xdesign.weatherapp.BuildConfig;
import xdesign.weatherapp.R;
import xdesign.weatherapp.adapter.WeatherAdapter;
import xdesign.weatherapp.model.HourData;
import xdesign.weatherapp.model.WeatherResponse;
import xdesign.weatherapp.api.DarkSkyClient;
import xdesign.weatherapp.api.DarkSkyInterface;
import xdesign.weatherapp.utilities.Utilities;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = BuildConfig.DARK_SKY_API_KEY;
    private Utilities utils = new Utilities() ;
    private ProgressDialog mProgressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DarkSkyInterface apiService = DarkSkyClient.getClient().create(DarkSkyInterface.class);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.weather_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        retrieveData(apiService,recyclerView);
    }

    private void retrieveData(final DarkSkyInterface api,final RecyclerView recyclerView)
    {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        Call<WeatherResponse> call = api.getWeatherDetails(API_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse>call, Response<WeatherResponse> response) {

                mProgressDialog.dismiss();
                List<HourData> hours = response.body().getHourly().getData();
                recyclerView.setAdapter(new WeatherAdapter(hours, R.layout.list_item_hour, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<WeatherResponse>call, Throwable t) {

                mProgressDialog.dismiss();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("There was an issue retrieving the weather data. Please check your network");

                builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        retrieveData(api,recyclerView);
                    }
                });
                builder.setNeutralButton("Close", new DialogInterface.OnClickListener()     {
                    public void onClick(DialogInterface dialog, int id) {
                        finish() ;
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

                Log.e(TAG, t.toString());
            }
        });
    }


}
