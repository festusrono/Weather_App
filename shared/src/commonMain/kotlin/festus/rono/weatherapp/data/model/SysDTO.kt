package festus.rono.weatherapp.data.model

import kotlinx.serialization.Serializable


@Serializable
data class SysDTO(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)