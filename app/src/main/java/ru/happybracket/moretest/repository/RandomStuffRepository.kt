package ru.happybracket.moretest.repository

import androidx.core.util.toHalf
import ru.happybracket.moretest.event.Event
import ru.happybracket.moretest.move.Move
import ru.happybracket.moretest.notice.Notice
import ru.happybracket.moretest.utils.nextString
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class RandomStuffRepository : StuffRepository {

    override fun getStuff(): List<Any> {
        val low = 10
        val hi = 101
        val size = Random.nextInt(low, hi)
        val slate = ArrayList<Any>(size)

        val lowRoll = 0
        val highRoll = 3
        for (i in 0 until size) {
            val roll = Random.nextInt(lowRoll, highRoll)
            val next = when (roll) {
                0 -> generateEvent()
                1 -> generateNotice()
                else -> generateMove()
            }
            slate.add(next)
        }
        return slate
    }

    private fun generateEvent(): Event {
        val start = Random.nextLong()
        val end = Random.nextLong(start, Long.MAX_VALUE)
        return Event(
            Date(start),
            Date(end),
            Random.nextString()
        )
    }

    private fun generateNotice(): Notice {
        return Notice(
            Date(Random.nextLong()),
            Random.nextString()
        )
    }

    private fun generateMove(): Move {
        return Move(
            Random.nextString(),
            Random.nextString(),
            Random.nextDouble()
        )
    }

}