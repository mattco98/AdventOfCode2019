package me.mattco.aoc2019.days.day3

import me.mattco.aoc2019.utils.Day
import me.mattco.aoc2019.utils.println
import java.lang.IllegalStateException
import java.lang.Math.*
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    Day3_1.start()
}

enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

data class Move(val direction: Direction, val moves: Int)

object Day3_1 : Day(3) {
    fun start() {
        // Use cantor pairing to map coordinate to
        // one number
        val (wire1, wire2) = getInput()
            .split('\n')
            .map {
                it.split(',').map { instr ->
                    val dir = when (instr[0]) {
                        'R' -> Direction.RIGHT
                        'L' -> Direction.LEFT
                        'U' -> Direction.UP
                        'D' -> Direction.DOWN
                        else -> throw IllegalStateException()
                    }

                    Move(dir, instr.slice(1 until instr.length).toInt())
                }
            }

        val seen = mutableSetOf<Int>()
        val crosses = mutableSetOf<Int>()

        var x = 0
        var y = 0

        for (move in wire1) {
            val px = x
            val py = y

            when (move.direction) {
                Direction.UP -> y += move.moves
                Direction.DOWN -> y -= move.moves
                Direction.LEFT -> x -= move.moves
                Direction.RIGHT -> x += move.moves
            }

            for (i in min(x, px)..max(x, px))
                for (j in min(y, py)..max(y, py))
                    if (i != 0 && j != 0)
                        seen.add(cantor(i, j))
        }

        println(seen.size)

        x = 0
        y = 0

        for (move in wire2) {
            val px = x
            val py = y

            when (move.direction) {
                Direction.UP -> y += move.moves
                Direction.DOWN -> y -= move.moves
                Direction.LEFT -> x -= move.moves
                Direction.RIGHT -> x += move.moves
            }

            for (i in min(x, px)..max(x, px)) {
                for (j in min(y, py)..max(y, py)) {
                    val c = cantor(i, j)
                    if (seen.contains(c)) {
                        crosses.add(c)
                    }
                }
            }
        }

        crosses
            .map { inverseCantor(it) }
            .map { it.first + it.second }
            .min()
            ?.println()
    }

    fun cantor(a: Int, b: Int): Int {
        return (a + b) * (a + b + 1) / 2 + b
    }

    fun inverseCantor(z: Int): Pair<Int, Int> {
        val w = floor((sqrt((8 * z + 1).toDouble()) - 1) / 2)
        val t = (pow(w, 2.0) + w) / 2
        val y = (z - t).toInt()
        return (w - y).toInt() to y
    }
}