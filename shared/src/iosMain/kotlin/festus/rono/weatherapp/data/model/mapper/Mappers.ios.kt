package festus.rono.weatherapp.data.model.mapper

actual fun formatDate(millis: Long): String {
    val formatter = NSDateFormatter().apply {
        dateFormat = "dd MM hh:mm a"
        timeZone = NSTimeZone.localTimeZone
    }
    val date = NSDate(millis.times(1000).toDouble())
    return formatter.stringFromDate(date)
}


