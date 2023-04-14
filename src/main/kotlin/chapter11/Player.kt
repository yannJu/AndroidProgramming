package chapter11

class Player {
    var name = "Yanjo"
        get() = field.capitalize()
        set(value) {field = value.trim()}
    fun castFireball(numFireballs: Int = 2) = println("한 덩어리의 파이어볼이 나타난ㄷ아 . .(x$numFireballs)")
}