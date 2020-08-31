package ru.happybracket.moretest.utils

import kotlin.random.Random

private val charset = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun Random.nextString(): String {
    val length = Random.nextInt(1, 25)
    val builder = StringBuilder()
    for (i in 0..length) {
        val charIndex = Random.nextInt(0, charset.length)
        builder.append(charset[charIndex])
    }
    return builder.toString()
}