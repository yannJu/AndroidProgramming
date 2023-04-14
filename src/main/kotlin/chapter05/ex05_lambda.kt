package chapter05

//fun check(letter: char) {
//    return letter == 's'
//}
fun main(args: Array<String>) {

// 위, 아래 동일
//    val numLetters1 = "Mississippi".count(check)
//    println(numLetters1)

//    val numLetters2 = "Mississippi".count({letter->letter=='s'})
    val numLetters2 = "Mississippi".count({it == 's'})
    println(numLetters2)

    println({
        val currentYear = 2021
        "SimVillage 방문을 환영합니다 ^ . . ^  (copyright $currentYear)"
    }())
}