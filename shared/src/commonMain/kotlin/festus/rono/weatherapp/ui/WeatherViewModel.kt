package festus.rono.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import festus.rono.weatherapp.domain.model.ForeCast
import festus.rono.weatherapp.domain.model.Weather
import festus.rono.weatherapp.domain.model.use_case.GetCurrentWeatherInfoUseCase
import festus.rono.weatherapp.domain.model.use_case.GetForecastInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getCurrentWeatherInfoUseCase: GetCurrentWeatherInfoUseCase,
    private val getForecastInfoUseCase: GetForecastInfoUseCase

) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()
    fun getCurrentWeatherInfo(lat: Double, long: Double) = viewModelScope.launch {
        val response = getCurrentWeatherInfoUseCase.invoke(lat, long)
        if(response.isSuccess) {
            _uiState.update {it.copy(currentWeather = response.getOrNull())}

        }else{

         _uiState.update {it.copy(error = response.exceptionOrNull().toString())}
        }
    }
    fun getForecastInfo(lat: Double, long: Double) = viewModelScope.launch {
        val response = getForecastInfoUseCase.invoke(lat, long)
        if(response.isSuccess) {
            _uiState.update {it.copy(forecastInfo = response.getOrNull())}
        }else{
            _uiState.update {it.copy(error = response.exceptionOrNull().toString())}
        }
    }
}

data class UiState(
    val error: String = "",
    val currentWeather: Weather? = null,
    val forecastInfo: List<ForeCast>? = null
)