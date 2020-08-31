package ru.happybracket.moretest

import androidx.fragment.app.Fragment
import com.airbnb.epoxy.EpoxyModel
import ru.happybracket.moretest.event.Dispatcher
import ru.happybracket.moretest.event.Event
import ru.happybracket.moretest.move.Dispatcher
import ru.happybracket.moretest.move.Move
import ru.happybracket.moretest.notice.Dispatcher
import ru.happybracket.moretest.notice.Notice

object NavigationConfigHolder {

    private var _config: NavigationConfig = NavigationConfig.Default()
    val dispatcher: NavigationDispatcher
        get() = _config

    fun setConfig(config: NavigationConfig) {
        _config = config
    }

}

interface NavigationDispatcher {

    fun dispatchModel(value: ModelData<Any>): EpoxyModel<*>?
    fun requireModel(value: ModelData<Any>): EpoxyModel<*>
    fun dispatchFragment(value: Any): Fragment?
    fun requireFragment(value: Any): Fragment

}

class NavigationConfig : NavigationDispatcher {

    private val dispatchers: MutableMap<Class<*>, TypedDispatcher<Any>> = HashMap()

    fun <T> register(dispatcher: TypedDispatcher<T>) {
        dispatchers[dispatcher.type] = dispatcher.erase()
    }

    override fun dispatchModel(value: ModelData<Any>): EpoxyModel<*>? {
        return dispatchers[value.value::class.java]?.dispatchModel?.invoke(value)
    }

    override fun requireModel(value: ModelData<Any>): EpoxyModel<*> {
        return dispatchModel(value) ?: throw fabricateError(value)
    }

    override fun dispatchFragment(value: Any): Fragment? {
        return dispatchers[value::class.java]?.dispatchScreen?.invoke(value)
    }

    override fun requireFragment(value: Any): Fragment {
        return dispatchFragment(value) ?: throw fabricateError(value)
    }

    private fun fabricateError(value: Any): Exception =
        IllegalStateException("dispatcher for $value was not registered")

    companion object

}

fun NavigationConfig.Companion.Default(): NavigationConfig =
    NavigationConfig().apply {
        register(Event.Dispatcher())
        register(Move.Dispatcher())
        register(Notice.Dispatcher())
    }