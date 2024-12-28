package festus.rono.weatherapp.domain.model.di

import festus.rono.weatherapp.domain.model.use_case.GetCurrentWeatherInfoUseCase
import festus.rono.weatherapp.domain.model.use_case.GetForecastInfoUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetCurrentWeatherInfoUseCase(get()) }
    factory { GetForecastInfoUseCase(get()) }
}