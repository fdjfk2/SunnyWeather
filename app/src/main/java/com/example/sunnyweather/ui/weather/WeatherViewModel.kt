package com.example.sunnyweather.ui.weather

import androidx.constraintlayout.widget.ConstraintSet.Transform
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Location
import com.example.sunnyweather.logic.model.Weather

class WeatherViewModel:ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = MediatorLiveData<Weather>()


    init{
        // 监听locationLiveData的变化
        weatherLiveData.addSource(locationLiveData) {location ->
            // 当locationLiveData的值改变时，发起新的查询
            val weathersLiveData = Repository.refreshWeather(location.lng, location.lat)
            // 再监听查询结果LiveData的变化
            weatherLiveData.addSource(weathersLiveData) { result ->
                // 尝试获取成功结果并设置给weatherLiveData.value
                try{
                    val weathers = result.getOrThrow()
                    weatherLiveData.value = weathers
                }catch (e:Exception){
                    // 这里处理获取失败的情况，比如打印错误信息等
                    e.printStackTrace()
                }
            }
        }
    }


//    val weatherLiveData1 = Transformations.switchMap(locationLiveData){location ->
//        Repository.refreshWeather(location.lng, location.lat)
//    }

    fun refreshWeather(lng: String, lat: String){
        locationLiveData.value = Location(lng,lat)
    }
}