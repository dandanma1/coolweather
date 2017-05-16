package com.bignerdranch.android.coolweather.gson;

/**
 * Created by madandan on 2017/5/10.
 */

public class AQI {
    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
