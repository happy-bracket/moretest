package ru.happybracket.moretest.main

import com.airbnb.epoxy.EpoxyController
import ru.happybracket.moretest.models.Event
import ru.happybracket.moretest.models.Move
import ru.happybracket.moretest.models.Notice
import ru.happybracket.moretest.modelviews.eventView
import ru.happybracket.moretest.modelviews.moveView
import ru.happybracket.moretest.modelviews.noticeView

class MainController(
    private val openScreen: (Any) -> Unit
) : EpoxyController() {

    private var items: List<Any> = emptyList()

    fun setItems(items: List<Any>) {
        this.items = items
        requestModelBuild()
    }

    override fun buildModels() {
        items.forEach { model ->
            when (model) {
                is Move -> moveView {
                    id(model.hashCode())
                    bind(model)
                    onClick { openScreen(model) }
                }
                is Event -> eventView {
                    id(model.hashCode())
                    bind(model)
                    onClick { openScreen(model) }
                }
                is Notice -> noticeView {
                    id(model.hashCode())
                    bind(model)
                    onClick { openScreen(model) }
                }
            }
        }
    }

}