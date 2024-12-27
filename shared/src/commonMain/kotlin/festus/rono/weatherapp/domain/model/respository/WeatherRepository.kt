package festus.rono.weatherapp.domain.model.respository

import festus.rono.weatherapp.domain.model.ForeCast
import festus.rono.weatherapp.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeatherInfo(lat: Double, long: Double): Weather
    suspend fun getForecastInfo(lat: Double, long: Double): List<ForeCast>


    suspend fun getCurrentWeatherInfo(lat: Double, long: Double): Weather
}