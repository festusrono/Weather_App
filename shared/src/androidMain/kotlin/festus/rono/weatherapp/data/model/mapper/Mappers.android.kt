package festus.rono.weatherapp.data.model.mapper

import android.icu.text.SimpleDateFormat

actual fun formatDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd MM hh:mm a")
    return formatter.format(millis.times(100).toDouble())
}