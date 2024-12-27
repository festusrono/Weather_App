package festus.rono.weatherapp.domain.model.respository

import festus.rono.weatherapp.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeatherInfo(lat: Double, long: Double): Weather
    suspend fun getForecastInfo(lat: Double, long: Double): List<Forecast>

}