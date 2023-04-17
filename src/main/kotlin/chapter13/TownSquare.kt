package chapter13

class TownSquare : Room("TownSquare") {
    override val dangerLevel = super.dangerLevel - 3
    private val bellSound =  "딩동"
    final override fun load() = "당신의 방문을 주민들이 다 함께 환영합니다 . . .! \r\n" + ringBell()

    private fun ringBell() = "종탑에서 당신의 도착을 알립니다 - ! $bellSound"
}