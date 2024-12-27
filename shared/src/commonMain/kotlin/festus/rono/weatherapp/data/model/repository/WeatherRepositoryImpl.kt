package festus.rono.weatherapp.data.model.repository

import festus.rono.weatherapp.data.model.remote.ApiService
import festus.rono.weatherapp.domain.model.Weather
import festus.rono.weatherapp.domain.model.respository.WeatherRepository

class WeatherRepositoryImpl(private val apiService: ApiService) : WeatherRepository {
    override suspend fun getCurrentWeatherInfo(lat: Double, long: Double): Weather {
        return apiService.currentWeatherInfo(lat, long)
    }

    override suspend fun getForecastInfo(lat: Double, long: Double): List<Forecast> {

    }
