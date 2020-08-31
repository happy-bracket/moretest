package ru.happybracket.moretest.event

import ru.happybracket.moretest.ModelData
import ru.happybracket.moretest.TypedDispatcher

fun Event.Companion.Dispatcher(): TypedDispatcher<Event> =
    TypedDispatcher(Event::class.java, ::model, EventFragment.Companion::Create)

private fun model(event: ModelData<Event>): EventViewModel_ =
    EventViewModel_().apply {
        id(event.value.hashCode())
        bind(event.value)
        onClick(event.onClick)
    }