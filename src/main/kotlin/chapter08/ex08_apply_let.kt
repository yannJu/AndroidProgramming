package chapter08

import java.io.File

fun main(args: Array<String>) {
    val menuFile = File("menu-file.txt").apply {
        this.setReadable(true)
        this.setWritable(true)
        this.setExecutable(false)
    }

    val firstItemSquared = listOf(1, 2, 3).first().let {it * it}
}