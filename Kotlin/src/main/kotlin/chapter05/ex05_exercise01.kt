package chapter05

fun main(args: Array<String>) {
//    val greetingFunction = { playerName : String, numBuildings : Int ->
//        val currentYear = 2021
//        println("$numBuildings 채의 건물이 추가됨 . .")
//        "$playerName 님 , , SimVillage 방문을 환영합니다 !"
//    }
//
//    runSimulation(" 얀조쓰", greetingFunction)

    // 아래와 같이 단축 문법으로 구현 가능
    runSimulation("김선달") { playerName, numBuildings ->
        val currentYear = 2021
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다. $playerName!(copyright $currentYear)"
    }
}

fun runSimulation(playerName : String, greetingFuntion : (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last() // 1, 2, 3 중 무작위 선택
    println(greetingFuntion(playerName, numBuildings))
}