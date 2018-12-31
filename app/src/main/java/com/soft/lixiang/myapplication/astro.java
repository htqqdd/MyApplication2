package com.soft.lixiang.myapplication;

import android.util.Log;

import org.json.JSONObject;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class astro {
    private String date;
    private astro_time sunset;
    private astro_time sunrise;
    public astro(JSONObject object){
//        try {
//            date = object.getString("date");
//            sunset = object.getJSONObject("sunset").toString();
//            sunrise = object.getJSONObject("sunrise").toString();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    public Date getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Date getSunset() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            return formatter.parse(sunset.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Date getSunrise() {
        Log.v("测试","此时SUNRISE是"+sunrise.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            return formatter.parse(sunrise.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public class astro_time{
        private String time;

        public String getTime() {
            return time;
        }
    }
}

