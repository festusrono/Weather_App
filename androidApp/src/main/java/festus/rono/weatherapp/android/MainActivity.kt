package festus.rono.weatherapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import festus.rono.weatherapp.domain.model.Weather
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

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(modifier = Modifier.fillMaxSize().background(color = SkyBlueColor), horizontalAlignment = Alignment.CenterHorizontally) {
        if (uiState.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = uiState.error)
            }
        }

        uiState.currentWeather?.let {weather: Weather ->
            Spacer(modifier = Modifier.height(64.dp))
            com.skydoves.landscapist.glide.GlideImage(
                imageModel = weather.iconUrl,
                modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = weather.temperature.plus("°C"),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 40.sp)
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(text = weather.name, style = MaterialTheme.typography.headlineSmall.copy(fontSize = 20.sp))
        }
    }

}