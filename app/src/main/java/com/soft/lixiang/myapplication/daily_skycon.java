package com.soft.lixiang.myapplication;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class daily_skycon {
    private String date;
    private String value;
    public daily_skycon(JSONObject object){
//        try {
//            date = object.getString("date");
//            value = object.getString("value");
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

    public String getValue() {
        return value;
    }
}
