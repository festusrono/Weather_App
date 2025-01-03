package festus.rono.weatherapp.ui.di

import festus.rono.weatherapp.ui.WeatherViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

private val viewModelModule = module {
    single { WeatherViewModel(get(), get()) }
}
actual fun sharedViewModelModule(): Module = viewModelModule

object ProvideViewModel: KoinComponent {
    fun getWeatherViewModel(): WeatherViewModel = get()
}