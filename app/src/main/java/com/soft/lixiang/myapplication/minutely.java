package com.soft.lixiang.myapplication;

import org.json.JSONObject;

import java.util.ArrayList;

public class minutely {
    private String description;
    private ArrayList precipitation_2h;
    public minutely(JSONObject object){

    }

    public String getDescription() {
        return description;
    }

    public ArrayList getPrecipitation_2h_list() {
        return precipitation_2h;
    }
}
