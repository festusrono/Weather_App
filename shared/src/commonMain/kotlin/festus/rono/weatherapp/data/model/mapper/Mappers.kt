package festus.rono.weatherapp.data.model.mapper

import festus.rono.weatherapp.data.model.WeatherResponse
import festus.rono.weatherapp.domain.model.Weather

fun WeatherResponse.toDomain(): Weather {
    return Weather(
        name = name,
        temperature = this.main.temp.minus(273).toString(),
        iconUrl = getImageUrl(this.weather.first().icon)
    )
}

fun getImageUrl(iconId: String) = "https://openweathermap.org/img/wn/$iconId@2x.png"