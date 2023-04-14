package chapter08

fun main(args: Array<String>) {
    val menuFile = File("menu-file.txt").apply {
        menuFile.setReadable(true)
        menuFile.setWriteable(true)
        menuFile.setExecutable(false)
    }

    val firstItemSquared = listOf(1, 2, 3).first().let {it * it}
}