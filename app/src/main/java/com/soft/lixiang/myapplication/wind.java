package com.soft.lixiang.myapplication;

public class wind {
    private String direction = "北风";
    private String speed = "无风";
    public wind(String mDirection,String mSpeed){
        double dir = Double.valueOf(mDirection);
        double sp = Double.valueOf(mSpeed);
        if (dir > 11.25 & dir<=78.75){
            direction = "东北";
        }else if (dir > 78.75 & dir<=101.25){
            direction = "东";
        }else if (dir > 101.25 & dir <=168.75){
            direction = "东南";
        }else if (dir > 168.75 & dir <=191.25){
            direction = "南";
        }else if (dir > 191.25 & dir <= 258.75){
            direction = "西南";
        }else if (dir > 258.75 & dir <= 281.75){
            direction = "西";
        }else if (dir > 281.75 & dir<= 348.75){
            direction = "西北";
        }else if (dir > 348.75 || dir <=11.25){
            direction = "北";
        }
        //风速
        if (sp <1){
            speed = "无风 青烟直上";
        }else if (sp >=1 & sp <6){
            speed = "软风 轻烟袅袅";
        }else if (sp >=6 & sp <12){
            speed = "轻风 和煦拂面";
        }else if (sp >=12 & sp <20){
            speed = "微风 旌旗展开";
        }else if (sp >=20 & sp <29){
            speed = "和风 吹起尘土";
        }else if (sp >=29 & sp <39){
            speed = "清风 小树摇摆";
        }else if (sp >=39 & sp <50){
            speed = "强风 电线有声";
        }else if (sp >=50 & sp <62){
            speed = "疾风 步行困难";
        }else if (sp >=62 & sp <75){
            speed = "大风 折毁树枝";
        }else if (sp >=75 & sp <89){
            speed = "烈风 小损房屋";
        }else if (sp >=89 & sp <103){
            speed = "狂风 拔起树木";
        }else if (sp >=103 & sp <117){
            speed = "暴风 损毁重大";
        }else{
            speed = "台风 海浪滔天";
        }

    }

    public String getDirection() {
        return direction;
    }

    public String getSpeed() {
        return speed;
    }
}
