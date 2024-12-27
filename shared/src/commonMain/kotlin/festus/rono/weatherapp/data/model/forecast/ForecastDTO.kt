package festus.rono.weatherapp.data.model.forecast

import festus.rono.weatherapp.data.model.MainDTO
import festus.rono.weatherapp.data.model.SysDTO
import festus.rono.weatherapp.data.model.WeatherDTO

data class ForecastDTO(
    val dt: Int,
    val main: MainDTO,
    val sys: SysDTO,
    val weather: List<WeatherDTO>,
)