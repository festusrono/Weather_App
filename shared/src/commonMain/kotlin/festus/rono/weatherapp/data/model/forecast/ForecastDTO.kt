package festus.rono.weatherapp.data.model.forecast

import festus.rono.weatherapp.data.model.MainDTO
import festus.rono.weatherapp.data.model.SysDTO
import festus.rono.weatherapp.data.model.WeatherDTO
import kotlinx.serialization.Serializable

@Serializable
data class ForecastDTO(
    val dt: Int,
    val main: MainDTO,
    val weather: List<WeatherDTO>,
)