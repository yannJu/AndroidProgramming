package chapter13

fun main(args: Array<String>) {
    var currentRooom = Room("Foyer")

    println(currentRooom.description())
    println(currentRooom.load())
}