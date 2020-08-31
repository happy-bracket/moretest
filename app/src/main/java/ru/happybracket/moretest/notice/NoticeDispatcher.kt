package ru.happybracket.moretest.notice

import ru.happybracket.moretest.ModelData
import ru.happybracket.moretest.TypedDispatcher

fun Notice.Companion.Dispatcher(): TypedDispatcher<Notice> =
    TypedDispatcher(Notice::class.java, ::model, NoticeFragment.Companion::Create)

private fun model(notice: ModelData<Notice>): NoticeViewModel_ =
        NoticeViewModel_().apply {
            id(notice.value.hashCode())
            bind(notice.value)
            onClick(notice.onClick)
        }