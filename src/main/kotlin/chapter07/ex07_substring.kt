package chapter07

const val TAVERN_NAME = "Yanjo's FollY"

fun main(args: Array<String>) {
    placeOrder()
}

private fun placeOrder() {
    // TAVERN NAME 에서 `'` 앞의 글자까지 추출하여 NAME 을 알아내야 한다.
    val indexofApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexofApostrophe) // indexofApostrophe 가 포함되지 않음
//    val tavernMaster = TAVERN_NAME.substring(0..indexofApostrophe - 1) // indexofApostrophe 가 포함됨

    println("뫄뫄는 $tavernMaster 에게 주문했다. . !")
}