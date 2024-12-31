package festus.rono.weatherapp.ui.utils

import kotlinx.coroutines.flow.StateFlow

internal fun <T : Any> StateFlow<T>.common(): CommonStateFlow<T> = CommonStateFlow<T>(underlyingStateFlow = this)

class CommonCancelable(val cancel: () -> Unit)
class CommonStateFlow<T>(
    private val underlyingStateFlow: StateFlow<T>
) : StateFlow<T> {
    override val replayCache: List<T>
        get() = underlyingStateFlow.replayCache
    override val value: T
        get() = underlyingStateFlow.value

    override suspend fun collect(collector: suspend (T) -> Unit): Nothing {
        underlyingStateFlow.collect(collector)
    }

}