package festus.rono.weatherapp.data.model.remote

import festus.rono.weatherapp.data.model.WeatherResponse
import festus.rono.weatherapp.data.model.forecast.ForecastResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path

private const val APP_ID = "c5078ea0d970f10a9b6d6145539bbf05"

//https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=c5078ea0d970f10a9b6d6145539bbf05
class ApiService(val client:HttpClient)  {
    suspend fun currentWeatherInfo(lat:Double, long:Double): WeatherResponse {
        return client.get {
            url {
                host = "api.openweathermap.org"
                path("/data/2.5/weather")
                parameters.append("lat", lat.toString())
                parameters.append("lon", long.toString())
                parameters.append("appid", APP_ID)
            }
        }.body<WeatherResponse>()
    }

    //https://api.openweathermap.org/data/2.5/forecast?lat=44.34&lon=10.99&appid=c5078ea0d970f10a9b6d6145539bbf05

    suspend fun forecastInfo(lat:Double, long:Double): ForecastResponse {
        return client.get {
            url {
                host = "api.openweathermap.org"
                path("/data/2.5/forecast")
                parameters.append("lat", lat.toString())
                parameters.append("lon", long.toString())
                parameters.append("appid", APP_ID)

            }
        }.body<ForecastResponse>()
    }
}