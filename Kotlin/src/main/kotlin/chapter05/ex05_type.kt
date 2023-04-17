package chapter05

fun main(args: Array<String>) {
    val greetingFunction1: () -> String = {
        val currentYear = 2021
        "SimVillage 방문을 환영합니다 ^ . . ^  (copyright $currentYear)\n"
    }

    print(greetingFunction1())

    val greetingFunction2: (String) -> String = {playerName ->
        val currentYear = 2021
        "$playerName 님, SimVillage 방문을 환영합니다 ^ . . ^  (copyright $currentYear)\n"
    }

    print(greetingFunction2("얀조오"))

    val greetingFunction3: (String) -> String = {
        val currentYear = 2021
        "$it 님, SimVillage 방문을 환영합니다 ^ . . ^  (copyright $currentYear)\n"
    }

    print(greetingFunction3("얀조오"))

//    val greetingFunction4: (String, Int) -> String = { playerName, numBuildings ->
//        val currentYear = 2021
//        println("$numBuildings 채의 건물이 추가됨")
//        "$playerName 님, SimVillage 방문을 환경합ㄴ ㅣ다 . .(copyright $currentYear)\n"
//    }
// 위와 동일 -> 타입 추론
    val greetingFunction4 = { playerName:String, numBuildings:Int ->
        val currentYear = 2021
        println("$numBuildings 채의 건물이 추가됨")
        "$playerName 님, SimVillage 방문을 환경합ㄴ ㅣ다 . .(copyright $currentYear)\n"
    }

    print(greetingFunction4("얀조룽", 100))
}