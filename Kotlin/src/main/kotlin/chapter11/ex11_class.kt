package chapter11
//
//class Player {
//    var name = "Yanjo"
//        get() = field.capitalize()
//        set(value) {field = value.trim()}
//    fun castFireball(numFireballs: Int = 2) = println("한 덩어리의 파이어볼이 나타난ㄷ아 . .(x$numFireballs)")
//}

fun main(args: Array<String>) {
    val player = Player()

//    print(player.name)
//    player.castFireball()
//
    player.name = "yiyan   " // set 연산 호출 -> 임의로 공백 추가
    print(player.name + "jo") // get 연산 호출
}