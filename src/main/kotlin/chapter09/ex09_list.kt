package chapter09

const val TAVERN_NAME = "yanjo's FollY"

var playerGold = 10
var playerSilver = 10
val patronLst: List<String> = listOf("Eli", "Mordoc", "Sophie")
fun main(args: Array<String>) {
    println(patronLst)

    println(patronLst.getOrElse(4) {"UnknownPatron ! "})
    println(patronLst.getOrNull(4) ?: "UnknownPatron ~")
}