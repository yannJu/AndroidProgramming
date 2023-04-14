package chapter10

fun main(args: Array<String>) {
    val map1 = mapOf<String, Double>(
        "Eli" to 0.5,
        "Sophie" to 5.5
    )

    val map2 = mapOf<String, Double>(
        Pair("Eli", 1.5),
        Pair("Sophie", 6.5)
    )

    println(map1)
    println(map2)
    println("===========")

//    map2 += "Eli" to 10.5
//    print(map2)

    // loop Test
    map2.forEach {name, score -> println("Name : $name, Score : $score")}
}