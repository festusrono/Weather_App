package festus.rono.weatherapp.data.model.repository

import festus.rono.weatherapp.data.model.mapper.toDomain
import festus.rono.weatherapp.data.model.remote.ApiService
import festus.rono.weatherapp.domain.model.ForeCast
import festus.rono.weatherapp.domain.model.Weather
import festus.rono.weatherapp.domain.model.respository.WeatherRepository

abstract class WeatherRepositoryImpl(private val apiService: ApiService) : WeatherRepository {
    override suspend fun getCurrentWeatherInfo(lat: Double, long: Double): Weather {
        return apiService.currentWeatherInfo(lat, long).toDomain()
    }

    override suspend fun getForecastInfo(lat: Double, long: Double): List<ForeCast> {
        return apiService.forecastInfo(lat, long).toDomain()

    }

}



