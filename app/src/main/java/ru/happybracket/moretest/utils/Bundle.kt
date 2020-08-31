package ru.happybracket.moretest.utils

import android.os.Bundle

fun bundle(inflate: Bundle.() -> Unit): Bundle {
    val bundle = Bundle()
    bundle.inflate()
    return bundle
}