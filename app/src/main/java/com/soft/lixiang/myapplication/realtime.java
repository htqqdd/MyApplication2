package com.soft.lixiang.myapplication;

import android.util.Log;

import org.json.JSONObject;

public class realtime {
    private String status;
    int ox;//o3
    int co;//co
    int so;//so2
    int no;//no2
    int tp;//温度
    int pm;//pm2.5
    int pm_ten;//pm10
    String skycon;//天气
    int aqi;//指数
    int humidity;//湿度
    wind wd;//风
    ultraviolet uv;//紫外线
    public realtime(JSONObject object){
        try {
            Log.v("测试","获取到realtime"+object);
            status = object.getString("status");
            ox = object.getInt("o3");
            co = object.getInt("co");
            so = object.getInt("so2");
            no = object.getInt("no2");
            tp = object.getInt("temperature");
            pm = object.getInt("pm25");
            pm_ten = object.getInt("pm10");
            skycon = object.getString("skycon");
            aqi = Integer.valueOf(object.getString("aqi"));
            wd = new wind(object.getJSONObject("wind").getString("direction"),object.getJSONObject("wind").getString("speed"));
            uv = new ultraviolet(object.getJSONObject("ultraviolet").getString("index"),object.getJSONObject("ultraviolet").getString("desc"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getStatus() {
        return status;
    }

    public int getOx() {
        return ox;
    }

    public int getCo() {
        return co;
    }

    public int getSo() {
        return so;
    }

    public int getNo() {
        return no;
    }

    public int getTp() {
        return tp;
    }

    public int getPm() {
        return pm;
    }

    public int getPm_ten() {
        return pm_ten;
    }

    public String getSkycon() {
        return skycon;
    }

    public int getAqi() {
        return aqi;
    }

    public int getHumidity() {
        return humidity;
    }

    public wind getWd() {
        return wd;
    }

    public ultraviolet getUv() {
        return uv;
    }
}
