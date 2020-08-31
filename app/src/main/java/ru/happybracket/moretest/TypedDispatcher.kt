package ru.happybracket.moretest

import androidx.fragment.app.Fragment
import com.airbnb.epoxy.EpoxyModel

data class TypedDispatcher<T>(
    val type: Class<T>,
    val dispatchModel: (ModelData<T>) -> EpoxyModel<*>,
    val dispatchScreen: (T) -> Fragment
)

class ModelData<T>(
    val value: T,
    rawOnClick: (T) -> Unit // little trick: passing `value` as Any is absolutely safe, because the only place `rawOnClick` is called from is its constructor
) {

    val onClick: () -> Unit = { rawOnClick(value) }

    companion object

}

fun <T> ModelData.Companion.Create() {

}



fun <T> TypedDispatcher<T>.erase(): TypedDispatcher<Any> = this as TypedDispatcher<Any>