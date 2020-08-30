package ru.happybracket.moretest.event

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Event(
    val startTime: Date? = null,
    val endTime: Date? = null,
    val name: String? = null
) : Parcelable