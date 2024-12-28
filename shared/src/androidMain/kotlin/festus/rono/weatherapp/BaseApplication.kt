package festus.rono.weatherapp

import android.app.Application
import festus.rono.weatherapp.data.model.di.dataModule
import festus.rono.weatherapp.domain.model.di.domainModule
import festus.rono.weatherapp.ui.di.sharedViewModule
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication : Application()  {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModule + domainModule + sharedViewModule())
        }
    }

}