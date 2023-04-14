package chapter12;

class Player(_name: String,
             var healthPoints: Int,
             var isBlessed: Boolean,
             private val isImmortal: Boolean) {
    var name = _name
        get() = field.capitalize()
        set(value) {field = value.trim()}

//    val healthPoints = _healthPoints
//    val isBlessed = _isBlessed
//    private val isImmortal = _isImmortal

    fun castFireball(numFireballs: Int = 2) = println("한 덩어리의 파이어볼이 나타난다 . . (x$numFireballs) ")
}
