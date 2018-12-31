package com.soft.lixiang.myapplication;

import java.util.ArrayList;

public class daily {
    private String status;
    private ArrayList<daily_skycon> skycon;
    private ArrayList<temperature> temperature;
    private ArrayList<astro> astro;

    public String getStatus() {
        return status;
    }

    public ArrayList<daily_skycon> getSkycon() {
        return skycon;
    }

    public ArrayList<com.soft.lixiang.myapplication.temperature> getTemperature() {
        return temperature;
    }

    public ArrayList<com.soft.lixiang.myapplication.astro> getAstro() {
        return astro;
    }
}
