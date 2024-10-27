package com.example.sunnyweather.logic.model

import com.example.sunnyweather.R

class Sky (val info: String, val icon: Int, val bg: Int)

private val sky = mapOf(
    "CLEAR_DAY" to Sky("晴", R.drawable.ic_clear_day, R.drawable.bg_000),
    "CLEAR_NIGHT" to Sky("晴", R.drawable.ic_clear_night, R.drawable.bg_000),
    "PARTLY_CLOUDY_DAY" to Sky("多云", R.drawable.ic_partly_cloud_day,
        R.drawable.bg_000),
    "PARTLY_CLOUDY_NIGHT" to Sky("多云", R.drawable.ic_partly_cloud_night,
        R.drawable.bg_000),
    "CLOUDY" to Sky("阴", R.drawable.ic_cloudy, R.drawable.bg_000),
    "WIND" to Sky("大风", R.drawable.ic_cloudy, R.drawable.bg_000),
    "LIGHT_RAIN" to Sky("小雨", R.drawable.ic_light_rain, R.drawable.bg_000),
    "MODERATE_RAIN" to Sky("中雨", R.drawable.ic_light_rain, R.drawable.bg_000),
    "HEAVY_RAIN" to Sky("大雨", R.drawable.ic_light_rain, R.drawable.bg_000),
    "STORM_RAIN" to Sky("暴雨", R.drawable.ic_light_rain, R.drawable.bg_000),
    "THUNDER_SHOWER" to Sky("雷阵雨", R.drawable.ic_light_rain, R.drawable.bg_000),
    "SLEET" to Sky("雨夹雪", R.drawable.ic_light_rain, R.drawable.bg_000),
    "LIGHT_SNOW" to Sky("小雪", R.drawable.ic_light_rain, R.drawable.bg_000),
    "MODERATE_SNOW" to Sky("中雪", R.drawable.ic_light_rain, R.drawable.bg_000),
    "HEAVY_SNOW" to Sky("大雪", R.drawable.ic_light_rain, R.drawable.bg_000),
    "STORM_SNOW" to Sky("暴雪", R.drawable.ic_light_rain, R.drawable.bg_000),
    "HAIL" to Sky("冰雹", R.drawable.ic_light_rain, R.drawable.bg_000),
    "LIGHT_HAZE" to Sky("轻度雾霾", R.drawable.ic_cloudy, R.drawable.bg_000),
    "MODERATE_HAZE" to Sky("中度雾霾", R.drawable.ic_cloudy, R.drawable.bg_000),
    "HEAVY_HAZE" to Sky("重度雾霾", R.drawable.ic_cloudy, R.drawable.bg_000),
    "FOG" to Sky("雾", R.drawable.ic_cloudy, R.drawable.bg_000),
    "DUST" to Sky("浮尘", R.drawable.ic_cloudy, R.drawable.bg_000)
)

fun getSky(skycon: String): Sky {
    return sky[skycon] ?: sky["CLEAR_DAY"]!!
}