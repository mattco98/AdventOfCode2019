package me.mattco.aoc2019.days.day1

import me.mattco.aoc2019.utils.Day
import me.mattco.aoc2019.utils.println

fun main() {
    Day1_1.start()
}

object Day1_1 : Day(1) {
    fun start() {
        getInput()
            .split("\n")
            .map { it.toInt() }
            .map { it / 3 }
            .map { it - 2 }
            .sum()
            .println()
    }
}
