package ru.happybracket.moretest.main

import com.airbnb.epoxy.EpoxyController
import ru.happybracket.moretest.ModelData
import ru.happybracket.moretest.NavigationConfigHolder

class MainController(
    private val openScreen: (Any) -> Unit
) : EpoxyController() {

    private var items: List<Any> = emptyList()

    fun setItems(items: List<Any>) {
        this.items = items
        requestModelBuild()
    }

    override fun buildModels() {
        items.mapNotNull {
            NavigationConfigHolder.dispatcher.dispatchModel(ModelData(it, openScreen))
        }.forEach(::add)
    }

}