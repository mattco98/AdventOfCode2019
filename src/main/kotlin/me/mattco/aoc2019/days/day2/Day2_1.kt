package me.mattco.aoc2019.days.day2

import me.mattco.aoc2019.utils.Day
import me.mattco.aoc2019.utils.println

fun main() {
    Day2_1.start()
}

object Day2_1 : Day(2) {
    private val arr = getInput().split(',').map { it.toInt() }.toMutableList()

    fun start() {
        var cursor = 0

        loop@ while (true) {
            val opcode = arr[cursor]

            when (opcode) {
                99 -> {
                    arr[0].println()
                    break@loop
                }
                1 -> arr[arr[cursor + 3]] = arr[arr[cursor + 1]] + arr[arr[cursor + 2]]
                2 -> arr[arr[cursor + 3]] = arr[arr[cursor + 1]] * arr[arr[cursor + 2]]
            }

            cursor += 4
        }
    }
}