package com.example.kotlinbaseboilerplate.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinbaseboilerplate.data.db.entity.WEATHER_LOCATION_ID
import com.example.kotlinbaseboilerplate.data.db.entity.WeatherLocation

@Dao
interface CurrentWeatherLocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherLocation: WeatherLocation)

    @Query("select * from weather_location where id = $WEATHER_LOCATION_ID")
    fun getCurrentLocation() : LiveData<WeatherLocation>

}