package festus.rono.weatherapp.domain.model.use_case

import festus.rono.weatherapp.domain.model.ForeCast
import festus.rono.weatherapp.domain.model.respository.WeatherRepository

class GetForecastInfoUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(lat: Double, long: Double): Result<List<ForeCast>> {
        return try{
            val response = weatherRepository.getForecastInfo(lat, long)
            Result.success(response)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }
}