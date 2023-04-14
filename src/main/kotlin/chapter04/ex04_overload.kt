package chapter04

//fun performCombat() {
//    println("적이 없다..")
//}
fun performCombat() = println("적이 없다..")

//fun performCombat(enemyName: String) {
//    println("$enemyName 과 전투 시작 . .")
//}
fun performCombat(enemyName: String) = println("$enemyName 과 전투 시작 . .")

//fun performCombat(enemyName: String, isBlessed: Boolean) {
//    if (isBlessed) println("$enemyName 와 전투 시작 . . . 축복  받기 ?")
//    else println("$enemyName 과 전투 시작 . .")
//}
fun performCombat(enemyName: String, isBlessed: Boolean) =
    if (isBlessed) println("$enemyName 와 전투 시작 . . . 축복  받기 ?")
    else println("$enemyName 과 전투 시작 . .")

fun main(args:Array<String>) {
    performCombat()
    performCombat("얀조")
    performCombat(isBlessed = true, enemyName = "얀조")
}