package festus.rono.weatherapp.domain.model.use_case

import festus.rono.weatherapp.domain.model.Weather
import festus.rono.weatherapp.domain.model.respository.WeatherRepository

class GetCurrentWeatherInfoUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(lat: Double, long: Double) : Result<Weather> {
        return try {
            val response = weatherRepository.getCurrentWeatherInfo(lat, long)
            Result.success(response)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }
}