package chapter09


val mutablePatronLst = mutableListOf<String>("Teri", "Eli", "Mcdonald")

fun main(args: Array<String>) {
    println(mutablePatronLst)
    // ========Mutable
    mutablePatronLst.remove("Teri")
    mutablePatronLst.add("Yanjo")
    mutablePatronLst.add(0, "zeroYanjo")

    println(mutablePatronLst)
    // ================
}