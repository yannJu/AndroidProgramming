package chapter06

fun main(args: Array<String>) {
//    var signatureDrink = "맥주"
//    signatureDrink = null 은 에러 . . . .

//    var beverage = readLine()?.capitalize()
//    print(beverage)

    // 안전 호출 연산자 ================
    var beverage1 = readLine()?.let {
        // readLine() 이 null 이 아님을 확신할 수 있기 때문에 `isNotBlank` 사용
        // capitalize 에 취소선 : deprecated 된 함수 . . . !
        if (it.isNotBlank()) it.capitalize()
        else "맥주"
    }
    println(beverage1)
    // ================================

    // not-null 단언 연산자 ============
    var beverage2 = readLine()!!.capitalize()
    println(beverage2)
    // ================================

    // null 복합 연산자 =================
    var beverage3 = readLine()
    if (beverage3 != null) {
        beverage3 = beverage3.capitalize()
    }
    else {
        println("$beverage3 가 null 입니다 . .")
    }

    val beverageServed: String = beverage3 ?: "맥주"
    println(beverageServed)
    // =================================
}