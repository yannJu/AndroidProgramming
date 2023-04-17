package chapter13

open class Room(val name: String){
    fun description() = "Room : $name"

    open fun load() = "아무도 여기에 오지 않았습니다 . ."
}
