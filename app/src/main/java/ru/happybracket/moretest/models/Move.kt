package ru.happybracket.moretest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Move(
    val fromPlace: String? = null,
    val toPLace: String? = null,
    val estimateTime: Double? = null
) : Parcelable