package festus.rono.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val main: MainDTO,
    val name: String,
    val weather: List<WeatherDTO>
)