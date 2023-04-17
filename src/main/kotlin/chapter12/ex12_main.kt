package chapter12

fun main(args: Array<String>) {
    // 다음과 같이 입력시 `require`에 의해 에러 발생
    // val player = Player("", 64, true, false)
    val player1 = Player("yanjo", 64, true, false)
    val player2 = Player("yanjoLee")

    println(player1.hometown)
    println("================")
    println(player1.hometown)
}