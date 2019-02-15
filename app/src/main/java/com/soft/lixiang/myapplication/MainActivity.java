package com.soft.lixiang.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.soft.lixiang.myapplication.materialWeatherView.MaterialWeatherView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    WeatherView weatherView;
    api_result weather_result;
//    DynamicWeatherView weatherView;
    String token = "Y2FpeXVuIGFuZHJpb2QgYXBp";
    String gps = "117.1848,34.2617";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new getWeatherByToken_GPSTask().execute(token,gps);
        weatherView = findViewById(R.id.weatherView);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        weatherView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        weatherView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        weatherView.onDestroy();
    }

//    private class getWeatherTask extends AsyncTask<String, Integer, String> {
//        @Override
//        protected String doInBackground(String... strings) {
//            try {
//                OkHttpClient client = new OkHttpClient.Builder()
//                        .connectTimeout(10, TimeUnit.SECONDS)
//                        .writeTimeout(10, TimeUnit.SECONDS)
//                        .readTimeout(30, TimeUnit.SECONDS)
//                        .build();
//
//                //获取Token
//                Request token_request = new Request.Builder().url("https://cdn.caiyunapp.com/etc/android_config.json").get().build();
//                Response token_response = client.newCall(token_request).execute();
//                String token_res = token_response.body().string();
//                JSONObject token_api = new JSONObject(token_res);
//                token = token_api.getString("TOKEN");
//                Log.v("测试","获取到TOKEN"+token);
//                return "ok";
//            } catch (Exception e) {
//                if (e instanceof java.net.UnknownHostException) {
//                    return "404";
//                }else if (e instanceof java.net.SocketTimeoutException){
//                    return "timeout";
//                }
//                e.printStackTrace();
//            }
//            return "timeout";
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            Log.v("测试","执行完毕"+s);
//            switch (s) {
//                case "ok":
//                    new getWeatherByToken_GPSTask().execute(token,gps);
//                    break;
//                case "404":
//                    if (!hasNetwork(MainActivity.this)) {
//                        Toast.makeText(MainActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(MainActivity.this, "服务器开小差了，请稍后再试", Toast.LENGTH_SHORT).show();
//                    }
//                    break;
//                case "timeout":
//                    Toast.makeText(MainActivity.this, "服务器连接超时，请稍后再试", Toast.LENGTH_SHORT).show();
//                    break;
//                default:
//            }
//            super.onPostExecute(s);
//        }
//
//    }

    private class getWeatherByToken_GPSTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build();

                //天气
                Request request = new Request.Builder().url("https://api.caiyunapp.com/v2/"+strings[0]+"/"+strings[1]+"/weather").get().build();
                Response response = client.newCall(request).execute();
                weather_result= new api_result(response.body().string(),new Date(System.currentTimeMillis()));
                return "ok";

            } catch (Exception e) {
                if (e instanceof java.net.UnknownHostException) {
                    return "404";
                }else if (e instanceof java.net.SocketTimeoutException){
                    return "timeout";
                }
                e.printStackTrace();
            }
            return "timeout";
        }

        @Override
        protected void onPostExecute(String s) {
            Log.v("测试","执行完毕"+s);
            switch (s) {
                case "ok":
                    display();
                    break;
                case "404":
                    if (!hasNetwork(MainActivity.this)) {
                        Toast.makeText(MainActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "服务器开小差了，请稍后再试", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "timeout":
                    Toast.makeText(MainActivity.this, "服务器连接超时，请稍后再试", Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
            super.onPostExecute(s);
        }

    }

    private void display(){
        try{
            String skycon = weather_result.getRealtime().getSkycon();
            int one = weather_result.getDailyTemperatureList().get(1).getMax();
            int two = weather_result.getDailyTemperatureList().get(1).getMin();
            int three = weather_result.getDailyTemperatureList().get(1).getAvg();
            double preciption = (double) weather_result.getMinutelyPrecipitation_2h_list().get(0);
            Log.v("测试","第一天的日期"+one+two+three+preciption);
            this.weatherView = findViewById(R.id.activity_main_weatherView);
            if (weatherView instanceof MaterialWeatherView) {
                int kind;
                kind = WeatherView.WEATHER_KIND_CLEAR_DAY;
//                if (locationNow.weather == null) {
//                    kind = WeatherView.WEATHER_KIND_CLEAR_DAY;
//                } else {
//                    kind = WeatherViewController.getWeatherViewWeatherKind(
//                            locationNow.weather.realTime.weatherKind,
//                            TimeManager.getInstance(this).isDayTime());
//                }
                weatherView.setWeather(kind);
//                ((MaterialWeatherView) weatherView).setOpenGravitySensor(
//                        PreferenceManager.getDefaultSharedPreferences(this)
//                                .getBoolean(getString(R.string.key_gravity_sensor_switch), true));
            }
            //CLEAR_DAY：晴天;CLEAR_NIGHT：晴夜;PARTLY_CLOUDY_DAY：多云;PARTLY_CLOUDY_NIGHT：多云;CLOUDY：阴;RAIN： 雨;SNOW：雪;WIND：风;HAZE：雾霾沙尘
//            switch (skycon) {
//                case "CLEAR_DAY":
//                    weatherView.setDrawerType(BaseDrawer.Type.CLEAR_D);
//                    break;
//                case "CLEAR_NIGHT":
//                    weatherView.setDrawerType(BaseDrawer.Type.CLEAR_N);
//                    break;
//                case "PARTLY_CLOUDY_DAY":
//                    weatherView.setDrawerType(BaseDrawer.Type.OVERCAST_D);
//                    break;
//                case "PARTLY_CLOUDY_NIGHT":
//                    weatherView.setDrawerType(BaseDrawer.Type.OVERCAST_N);
//                    break;
//                case "CLOUDY":
//                    if (!isNight()){
//                        weatherView.setDrawerType(BaseDrawer.Type.CLOUDY_D);
//                    }else {
//                        weatherView.setDrawerType(BaseDrawer.Type.CLOUDY_N);
//                    }
//                    break;
//                case "RAIN":
//                    if (!isNight()){
//                        weatherView.setDrawerType(BaseDrawer.Type.RAIN_D);
//                    }else {
//                        weatherView.setDrawerType(BaseDrawer.Type.RAIN_N);
//                    }
//                    break;
//                case "SNOW":
//                    if (!isNight()){
//                        weatherView.setDrawerType(BaseDrawer.Type.SNOW_D);
//                    }else {
//                        weatherView.setDrawerType(BaseDrawer.Type.SNOW_N);
//                    }
//                    break;
//                case "WIND":
//                    if (!isNight()){
//                        weatherView.setDrawerType(BaseDrawer.Type.WIND_D);
//                    }else {
//                        weatherView.setDrawerType(BaseDrawer.Type.WIND_N);
//                    }
//                    break;
//                case "HAZE":
//                    if (!isNight()){
//                        weatherView.setDrawerType(BaseDrawer.Type.HAZE_D);
//                    }else {
//                        weatherView.setDrawerType(BaseDrawer.Type.HAZE_N);
//                    }
//                    break;
//                default:
//                    weatherView.setDrawerType(BaseDrawer.Type.DEFAULT);
//            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    private boolean isNight() {
        if (weather_result != null) {
            Date sunset = weather_result.getDailyAstroList().get(0).getSunset();
            Date sunrise = weather_result.getDailyAstroList().get(0).getSunrise();
            Date now = new Date(System.currentTimeMillis());
            if (now.after(sunset) & now.before(sunrise)) {
                Log.v("测试", "当前为夜里");
                return true;
            }


        }
        Log.v("测试", "当前为白天");
        return false;

    }

    private boolean hasNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.getState() == NetworkInfo.State.CONNECTED;
            }
        }
        return false;
    }
}
