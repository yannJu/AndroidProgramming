package chapter09

fun main(args: Array<String>) {
    for (patron in patronLst) {
        println("좋은 밤입니다 . . $patron 님!")
    }
    println("====================")

    mutablePatronLst.forEach {
        patron -> println("좋은 밤입니다 . . $patron 님!")
    }
    println("====================")

    mutablePatronLst.forEach {println("좋은 밤입니다 . . $it 님!")}
    println("====================")

    // =========인덱스 접근
    patronLst.forEachIndexed {index, name -> println("$index ) $name") }
    // ===================
}