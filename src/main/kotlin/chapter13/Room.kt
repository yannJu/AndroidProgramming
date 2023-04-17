package chapter13

open class Room(val name: String){
    protected open val dangerLevel = 5

    fun description() = "Room : $name \r\n" + "위험 수준 : $dangerLevel"

    open fun load() = "아무도 여기에 오지 않았습니다 . ."
}
