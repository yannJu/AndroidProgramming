package chapter03

fun main(args: Array<String>) {
    val name = "얀조"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false

    // 아우라=======
    var auraVisible = isBlessed && healthPoints > 50 || isImmortal
    var auraColor = if (auraVisible) "GRREN" else "NONE"

    val healthStatus = if (healthPoints == 100) "최상의 상태입니ㄷ ㅏ . ."
    else if (healthPoints in 90..99) "약간의 찰과상 뿐 . ."
    else if (healthPoints in 75..89)
        if (isBlessed) "경미한 상처가 있지만 빨리 치유된ㄷ ㅏ."
        else "경미한 상처뿐 . .!"
    else if (healthPoints in 15..74) "많이 다친것 같음 ㅡ ㅡ "
    else "최악의 상태 !!!!"

    println(name + " " + healthStatus)
}