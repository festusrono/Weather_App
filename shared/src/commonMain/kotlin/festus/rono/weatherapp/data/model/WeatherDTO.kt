package festus.rono.weatherapp.data.model

data class WeatherDTO(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)