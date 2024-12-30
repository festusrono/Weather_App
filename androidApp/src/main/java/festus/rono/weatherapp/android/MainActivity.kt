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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import festus.rono.weatherapp.ui.WeatherViewModel
import festus.rono.weatherapp.ui.permission.AndroidLocationService

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
    var locationService by remember{mutableStateOf<AndroidLocationService?>()
    val permission = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()){

    }
    LaunchedEffect (Unit) {
        locationService = AndroidLocationService(this@MainActivity, permission)
    }
    }
}