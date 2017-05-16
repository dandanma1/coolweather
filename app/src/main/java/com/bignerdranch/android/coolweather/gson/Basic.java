package com.bignerdranch.android.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by madandan on 2017/5/10.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updateTime;
    }

}
