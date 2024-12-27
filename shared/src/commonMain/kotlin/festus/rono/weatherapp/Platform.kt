package festus.rono.weatherapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform