package festus.rono.weatherapp.data.model.di

import festus.rono.weatherapp.data.model.remote.ApiService
import festus.rono.weatherapp.data.model.remote.KtorClient
import festus.rono.weatherapp.data.model.repository.WeatherRepositoryImpl
import festus.rono.weatherapp.domain.model.respository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {
    factory { KtorClient.client}
    factory <ApiService> {ApiService(get())}
    factory<WeatherRepository> { WeatherRepositoryImpl(get()) }

}