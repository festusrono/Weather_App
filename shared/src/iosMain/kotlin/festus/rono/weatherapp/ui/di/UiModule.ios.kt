package festus.rono.weatherapp.ui.di


private val viewModelModule = module {
    single { WeatherViewModel(get(), get()) }
}
actual fun sharedViewModelModule(): Module = viewModelModule

object ProvideViewModel: KoinComponent {
    fun getWeatherViewModel(): WeatherViewModel = get()
}
