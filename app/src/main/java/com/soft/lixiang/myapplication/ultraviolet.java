package com.soft.lixiang.myapplication;

public class ultraviolet {
    private float index;
    private String desc;
    public ultraviolet(String mIndex,String mDesc){
        index = Float.valueOf(mIndex);
        desc = mDesc;
    }

    public float getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }
}
