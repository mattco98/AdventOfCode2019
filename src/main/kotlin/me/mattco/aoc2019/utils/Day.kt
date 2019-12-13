package me.mattco.aoc2019.utils

abstract class Day(val dayNum: Int) {
    fun getInput(): String {
        return this.javaClass.classLoader.getResource("day$dayNum.txt").readText()
    }
}
