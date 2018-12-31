package com.soft.lixiang.myapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class temperature {//DailyTemperature
    private String date;
    private String max;
    private String avg;
    private String min;
    public temperature(JSONObject object){
        Log.v("测试","此时温度源数据"+object.toString());
        try{
            date = object.getString("date");
            max = object.getString("max");
            avg = object.getString("avg");
            min = object.getString("min");
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public int getMax() {
        return (int) (Double.valueOf(max)+0.5);
//        if (max.contains(".")){
//            return Integer.valueOf(max.substring(0,max.indexOf(".")));
//        }else {
//            return Integer.valueOf(max);
//        }
    }

    public int getAvg() {
        return (int) (Double.valueOf(avg)+0.5);
//        if (avg.contains(".")){
//            return Integer.valueOf(avg.substring(0,avg.indexOf(".")));
//        }else {
//            return Integer.valueOf(avg);
//        }
    }

    public int getMin() {
        return (int) (Double.valueOf(min)+0.5);
//        if (min.contains(".")){
//            return Integer.valueOf(min.substring(0,min.indexOf(".")));
//        }else {
//            return Integer.valueOf(min);
//        }
    }

    public Date getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
