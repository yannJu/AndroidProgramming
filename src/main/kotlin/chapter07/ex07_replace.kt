package chapter07

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun placeOrder(menuData: String) {
    // TAVERN NAME 에서 `'` 앞의 글자까지 추출하여 NAME 을 알아내야 한다.
    val indexofApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexofApostrophe) // indexofApostrophe 가 포함되지 않음
//    val tavernMaster = TAVERN_NAME.substring(0..indexofApostrophe - 1) // indexofApostrophe 가 포함됨

    println("뫄뫄는 $tavernMaster 에게 주문했다. . !")

    //무엇을 주문했는지 설명
    val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    val price = data[2]
//    val (type, name, price) = menuData.split(',') // 파이썬의 unpack기능과 유사
    val message = "뫄뫄는 금화 $price 로 $name($type) 을 구입했다 !"
    println(message)

    val phrase = "$name 진짜 좋다 !"
    println("뫄뫄가 감탄했ㄷ ㅏ. . : ${toDragonSpeak(phrase)}")
}

private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[aeiou]")) {
    when (it.value) {
        "a" -> "4"
        "e" -> "3"
        "i" -> "1"
        "o" -> "0"
        "u" -> "|_|"
        else -> it.value
    }
}