package chapter05

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("건축 비용 : ${cost * numBuildings}")
}

inline fun runSimulation(playerName: String, costPrinter: (Int) -> Unit, greetingFunction : (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun main(args: Array<String>) {
    // runSimulation 이라는 함수 내에 기존함수 . . 를 인자로 받음 + 익명함수도 인자로 받는다
    runSimulation("얀조쓰", ::printConstructionCost) {
        playerName, numBuildings ->
        val currentYear = 2021
        println("$numBuildings 채의 건물이 추가되었다 . .")
        "$playerName 님, , SimVillage 에 방문을 환영합니다 ^ . .^"
    }
}