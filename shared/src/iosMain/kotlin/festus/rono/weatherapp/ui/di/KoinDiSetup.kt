package festus.rono.weatherapp.ui.di

import festus.rono.weatherapp.data.model.di.dataModule
import festus.rono.weatherapp.domain.model.di.domainModule
import org.koin.core.context.startKoin
import festus.rono.weatherapp.ui.di.sharedViewModule as sharedViewModelModule

fun initKoin() {
    startKoin {
        modules(dataModule + domainModule + sharedViewModelModule())
    }
}