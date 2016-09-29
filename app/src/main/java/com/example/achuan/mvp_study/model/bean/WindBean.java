package com.example.achuan.mvp_study.model.bean;

/**
 * Created by achuan on 16-9-29.
 * 功能：定义天气相关的数据模型
 */
public class WindBean {
    private String city;//城市
    private String wd;//风向
    private String ws;//风级
    private String time;//发布时间


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
