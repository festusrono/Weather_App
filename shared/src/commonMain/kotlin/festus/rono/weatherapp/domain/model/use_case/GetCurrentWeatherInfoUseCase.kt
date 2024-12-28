package festus.rono.weatherapp.domain.model.use_case

import festus.rono.weatherapp.domain.model.respository.WeatherRepository

class GetCurrentWeatherInfoUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(lat)
}