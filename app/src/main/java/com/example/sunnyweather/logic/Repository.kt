package com.example.sunnyweather.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.network.SunnyweatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query:String) = liveData(Dispatchers.IO){
        val result=try {
            val placeResponse = SunnyweatherNetwork.searchPlaces(query)
            if(placeResponse.status=="ok")
            {
                val places = placeResponse.places
                Log.d("Repository",places[0].location.lng)
                Result.success(places)

            }
            else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }
        catch(e:Exception)
        {
            Result.failure<List<Place>>(e)
        }


        emit(result)
    }
}