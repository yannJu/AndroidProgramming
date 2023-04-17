package chapter04

//private fun fromHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
//    val healthStatus = when (healthPoints) {
//        100 -> "최상의 상태  . . !"
//        in 91..99 -> "약간의 찰과상 - . -"
//        in 75..89 -> if (isBlessed) "경미한 상처는 있으나 금방 나을 것 같ㄷ ㅏ . . "
//        else "경미한 상처가 있다 . . "
//        in 15..74 -> "많이 다친것 같다 !"
//        else -> "최악의 상ㅌ ㅐ. . ."
//    }
//
//    return healthStatus
//}
//위와 동일한 의미
private fun fromHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "최상의 상태  . . !"
        in 91..99 -> "약간의 찰과상 - . -"
        in 75..89 -> if (isBlessed) "경미한 상처는 있으나 금방 나을 것 같ㄷ ㅏ . . "
        else "경미한 상처가 있다 . . "
        in 15..74 -> "많이 다친것 같다 !"
        else -> "최악의 상ㅌ ㅐ. . ."
    }

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if(auraVisible) "GREEN" else "NONE"

    return auraColor
}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthStatus: String) {
    println("(Aura : $auraColor)" + "(Blessed : ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

//private fun castFireball(numFireballs: Int=2) {
//    println("한 덩어리의 , , 파이어볼이 나타난다 , , (x$numFireballs)")
//}
// 위의 함수와 동일
private fun castFireball(numFireballs: Int=2) =
    println("한 덩어리의 , , 파이어볼이 나타난다 , , (x$numFireballs)")

fun main(args: Array<String>) {
    val name = "얀조쓰"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    //아우라 함수로 구현)
//    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
//    val auraColor = if(auraVisible) "GREEN" else "NONE"
    var auraColors = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = fromHealthStatus(healthPoints, isBlessed)

    //Print Player status
//    println("(Aura : $auraColors)" + "(Blessed : ${if (isBlessed) "YES" else "NO"})")
//    println("$name $healthStatus")
    printPlayerStatus(auraColors, isBlessed, name, healthStatus)
    castFireball(5)
}