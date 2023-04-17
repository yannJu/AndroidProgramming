package chapter12;

class Player(_name: String,
             var healthPoints: Int = 100,
             var isBlessed: Boolean,
             private val isImmortal: Boolean) {
    var name = _name
        get() = field.capitalize()
        set(value) {field = value.trim()}

//    val healthPoints = _healthPoints
//    val isBlessed = _isBlessed
//    private val isImmortal = _isImmortal
    
    // 보조생성자
    constructor(name: String) : this(name,
        healthPoints = 100,
        isBlessed = true,
        isImmortal = false) {
        println("[[Constructor Block]] ======")
        if (name.toLowerCase() == "kar") healthPoints = 45
    }

    // 초기화 블록
    init {
        println("[[Init Block]] ======")
        require(healthPoints > 0, {"healthPoints 는 0 보다 큰 값이어야 합니다."})
        require(name.isNotBlank(), {"플레이어의 이름을 입력해 주세요!"})
    }

    // 늦은 초기화
    val hometown by lazy {
        println("[[By lazy]] ======")
        "downtown"
    }
    fun castFireball(numFireballs: Int = 2) = println("한 덩어리의 파이어볼이 나타난다 . . (x$numFireballs) ")
}
