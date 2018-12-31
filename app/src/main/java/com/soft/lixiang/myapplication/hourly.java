package com.soft.lixiang.myapplication;


import org.json.JSONObject;

import java.util.ArrayList;

public class hourly {
    private String status;
    private String description;
    private ArrayList<hourly_skycon> skycon;
    private ArrayList<hourly_temperature> temperature;

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<hourly_skycon>  getSkyconList() {
        return skycon;
    }

    public ArrayList<hourly_temperature>  getTemperatureList() {
        return temperature;
    }
}
