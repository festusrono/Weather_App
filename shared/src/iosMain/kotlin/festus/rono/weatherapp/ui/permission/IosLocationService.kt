package festus.rono.weatherapp.ui.permission

class IosLocationService : LocationService  {
    private val locationManager = CLLocationManager()

    override fun isPermissionGranted(): Boolean {
        val status = locationManager.authorizationStatus()
        return status == kCLAuthorizationStatusAuthorizedAlways ||
                status == kCLAuthorizationStatusAuthorizedWhenInUse

    }
    override fun requestLocationPermission(granted: (Boolean) -> Unit) {
        val status = locationManager.authorizationStatus()
        if (status == kCLAuthorizationStatusNotDetermined) {
            locationManager.delegate = LocationDelegate(granted)
            locationManager.requestAlwaysAuthorization()
        }

    }
}

private class LocationDelegate(granted: (Boolean) -> Unit) : NSObject(),
    CLLocationManagerDelegateProtocol {
        override fun locationManager(
            manager: CLLocationManager,
            didChangeAuthorizationStatus: CLAuthorizationStatus
        ) {
            when (didChangeAuthorizationStatus) {
                kCLAuthorizationStatusAuthorizedAlways,
                kCLAuthorizationStatusAuthorizedWhenInUse ->
                    granted.invoke(true)
            }else {
                granted.invoke(false)
            }
        }
    }