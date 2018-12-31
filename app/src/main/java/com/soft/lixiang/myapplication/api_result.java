package com.soft.lixiang.myapplication;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class api_result {
    private Date date;
    private String keypoint;
    private realtime realtime;
    private daily daily_result;
    private hourly hourly_result;
    private minutely minutely_result;

    public api_result(String mResult,Date mDate) {
        try {
            date = mDate;
            JSONObject result = new JSONObject(new JSONObject(mResult).getJSONObject("result").toString());
            Log.v("测试","获取到result"+result);
            realtime = new realtime(result.getJSONObject("realtime"));
            keypoint = result.getString("forecast_keypoint");
            daily_result = new Gson().fromJson(result.getJSONObject("daily").toString(),daily.class);
            hourly_result = new Gson().fromJson(result.getJSONObject("hourly").toString(),hourly.class);
            minutely_result = new Gson().fromJson(result.getJSONObject("minutely").toString(),minutely.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Date getDate() {
        return date;
    }


    public String getKeypoint() {
        return keypoint;
    }

    public com.soft.lixiang.myapplication.realtime getRealtime() {
        return realtime;
    }

    public ArrayList<daily_skycon> getDailySkyconList(){
        return daily_result.getSkycon();
    }

    public ArrayList<temperature> getDailyTemperatureList(){
        return daily_result.getTemperature();
    }

    public ArrayList<astro> getDailyAstroList(){
        return daily_result.getAstro();
    }

    public String getHourlyDescription() {
        return hourly_result.getDescription();
    }

    public ArrayList<hourly_skycon> getHourlySkyconList(){
        return hourly_result.getSkyconList();
    }

    public ArrayList<hourly_temperature>  getHourlyTemperatureList() {
        return hourly_result.getTemperatureList();
    }

    public String getMinutelyDescription() {
        return minutely_result.getDescription();
    }

    public ArrayList getMinutelyPrecipitation_2h_list() {
        return minutely_result.getPrecipitation_2h_list();
    }

}
