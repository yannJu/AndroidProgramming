package chapter13

fun printRoomInfo(room: Room) {
    println(room.description())
    println(room.load())
}
fun main(args: Array<String>) {
    var currentRooom = Room("Foyer")

//    println(currentRooom.description())
//    println(currentRooom.load())
    printRoomInfo(currentRooom)

    println("===========")

    var townsquare = TownSquare()

//    println(townsquare.description())
//    println(townsquare.load())
    printRoomInfo(townsquare)
}