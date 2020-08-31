package ru.happybracket.moretest.notice

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Notice(
    val flightDate: Date? = null,
    val gate: String? = null
) : Parcelable {

    companion object

}