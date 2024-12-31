package festus.rono.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val main: MainDTO,
    val name: String,
    val sys: SysDTO,
    val weather: List<WeatherDTO>
)