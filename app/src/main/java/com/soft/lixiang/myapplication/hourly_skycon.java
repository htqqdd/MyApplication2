package com.soft.lixiang.myapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hourly_skycon {
    private String value;
    private String datetime;

    public String getValue() {
        return value;
    }

    public Date getDatetime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return formatter.parse(datetime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
