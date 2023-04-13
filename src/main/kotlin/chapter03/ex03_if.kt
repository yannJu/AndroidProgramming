package chapter03

fun main(args: Array<String>) {
    val name = "얀조"
    var healthPoints = 89
    var isBlessed = true

    if (healthPoints == 100) {
        println(name + "최상의 상태 . . ")
    }
    else if (healthPoints >= 90) {
        println(name + "약간의 찰과상만 있음 . .")
    }
    else if (healthPoints >= 75) {
        if (isBlessed) println(name + "경미한 상처가 있으나 빨리 치유됨 . . ㅎ ㅎ")
        else println(name + "경미한 상처만 있음 !")
    }
    else if (healthPoints >= 15) {
        println(name + "많이 다친것 같음 - . -")
    }
    else {
        println(name + "최악의 상태 ! _ !")
    }
}