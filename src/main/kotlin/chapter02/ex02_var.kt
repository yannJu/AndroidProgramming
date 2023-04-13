package chapter02

import kotlin.math.exp

fun main(args: Array<String>) {
//    var experiencePoints: Int = 5
//    experiencePoints += 5
//
//    println(experiencePoints)
    val playerName: String = "얀조쓰"
    var experiencePoints: Int = 5

    // 에러
    // playerName = "이얀조"

    // 에러 안남
    experiencePoints += 5

    println(playerName)
    println(experiencePoints)
}