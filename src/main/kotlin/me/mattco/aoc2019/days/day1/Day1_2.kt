package me.mattco.aoc2019.days.day1

import me.mattco.aoc2019.utils.Day
import me.mattco.aoc2019.utils.println


fun main() {
    Day1_2.start()
}

object Day1_2 : Day(1) {
    fun start() {
        getInput()
            .split("\n")
            .map { getRequiredFuel(it.toInt()) }
            .sum()
            .println()
    }

    fun getRequiredFuel(module: Int): Int {
        var fuel = 0
        var dFuel = (module / 3) - 2

        while (true) {
            if (dFuel < 0) {
                return fuel
            }

            fuel += dFuel
            dFuel = (dFuel / 3) - 2
        }
    }
}