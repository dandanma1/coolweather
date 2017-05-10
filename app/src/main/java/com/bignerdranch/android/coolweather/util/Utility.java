package com.bignerdranch.android.coolweather.util;

import android.text.TextUtils;

import com.bignerdranch.android.coolweather.db.City;
import com.bignerdranch.android.coolweather.db.County;
import com.bignerdranch.android.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by madandan on 2017/5/5.
 */

public class Utility {
    /*
    * 解析和处理服务器返回的省级数据
    * */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
   * 解析和处理服务器返回的市级数据
   * */
    public static boolean handleCityResponse(String response,int provinceId) {
        try {
            JSONArray allCities = new JSONArray(response);
            for (int i = 0; i < allCities.length(); i++){
                JSONObject cityObject = allCities.getJSONObject(i);
                City city = new City();
                city.setCityCode(cityObject.getInt("id"));
                city.setCityName(cityObject.getString("name"));
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;

    }
     /*
   * 解析和处理服务器返回的市级数据
   * */
     public static boolean handleCountyResponse(String response, int cityId){
         try {
             JSONArray allCounties = new JSONArray(response);
             for (int i = 0; i < allCounties.length(); i++){
                JSONObject countyObject = allCounties.getJSONObject(i);
                 County county = new County();
                 county.setCountyName(countyObject.getString("name"));
                 county.setWeatherId(countyObject.getString("weather_id"));
                 county.setCityId(cityId);
                 county.save();
             }
             return true;
         } catch (JSONException e) {
             e.printStackTrace();
         }
         return false;
     }


}
