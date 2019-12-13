package me.mattco.aoc2019.days.day2

import me.mattco.aoc2019.utils.Day
import me.mattco.aoc2019.utils.println

fun main() {
    Day2_2.start()
}

object Day2_2 : Day(2) {
    fun start() {
        for (noun in 1..99) {
            for (verb in 1..99) {
                if (calculate(noun, verb) == 19690720) {
                    println(100 * noun + verb)
                }
            }
        }
    }

    fun calculate(noun: Int, verb: Int): Int {
        val arr = getInput().split(',').map { it.toInt() }.toMutableList()
        arr[1] = noun
        arr[2] = verb
        var cursor = 0

        loop@ while (true) {
            val opcode = arr[cursor]

            when (opcode) {
                99 -> {
                    return arr[0]
                }
                1 -> arr[arr[cursor + 3]] = arr[arr[cursor + 1]] + arr[arr[cursor + 2]]
                2 -> arr[arr[cursor + 3]] = arr[arr[cursor + 1]] * arr[arr[cursor + 2]]
            }

            cursor += 4
        }
    }
}