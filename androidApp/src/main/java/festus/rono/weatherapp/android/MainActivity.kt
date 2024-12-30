package festus.rono.weatherapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import festus.rono.weatherapp.ui.WeatherViewModel
import festus.rono.weatherapp.ui.permission.AndroidLocationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun WeatherApp(modifier: Modifier = Modifier, viewModel: WeatherViewModel) {
    var locationService by remember {mutableStateOf<AndroidLocationService?>(null)}

    val scope = rememberCoroutineScope()
    val permission = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()){
        if (bool) {
            scope.launch(Dispatchers.IO) {
                val location = locationService?.getLocation()
                location?.let {
                    viewModel.getCurrentWeatherInfo(it.latitude, it.longitude)
                    viewModel.getForecastInfo(it.latitude, it.longitude)
                }
            }
        }
    }

    val context = LocalContext.current
    LaunchedEffect (Unit) {
        locationService = AndroidLocationService(context, permission)
        locationService?.requestLocationPermission{ }
    }

}