package com.bignerdranch.android.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by madandan on 2017/5/10.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{

        @SerializedName("txt")
        public String info;
    }
}
