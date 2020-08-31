package ru.happybracket.moretest.move

import ru.happybracket.moretest.ModelData
import ru.happybracket.moretest.TypedDispatcher

fun Move.Companion.Dispatcher(): TypedDispatcher<Move> =
    TypedDispatcher(Move::class.java, ::model, MoveFragment.Companion::Create)

private fun model(move: ModelData<Move>): MoveViewModel_ =
    MoveViewModel_().apply {
        id(move.value.hashCode())
        bind(move.value)
        onClick(move.onClick)
    }