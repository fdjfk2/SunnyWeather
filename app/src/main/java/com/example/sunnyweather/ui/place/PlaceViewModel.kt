package com.example.sunnyweather.ui.place

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place
import com.google.android.gms.common.api.Result
//import kotlinx.coroutines.flow.Result

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    // 使用MediatorLiveData来替代原来基于Transformations.switchMap的placeLiveData
    val placeLiveData = MediatorLiveData<List<Place>>()

    init {
        // 监听searchLiveData的变化
        placeLiveData.addSource(searchLiveData) { query ->
            // 当searchLiveData的值改变时，发起新的查询
            val placesLiveData = Repository.searchPlaces(query)
            // 再监听查询结果LiveData的变化
            placeLiveData.addSource(placesLiveData) { result ->
                // 尝试获取成功结果并设置给placeLiveData.value
                try {
                    val places = result.getOrThrow()
                    placeLiveData.value = places
                } catch (e: Exception) {
                    // 这里处理获取失败的情况，比如打印错误信息等
                    e.printStackTrace()
                }
            }
        }
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}