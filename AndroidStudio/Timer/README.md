## Android Programming _ Timer 🍁

1. ### [타이머 스레드 연동(MainActivity.kt)](./app/src/main/java/com/example/timer/MainActivity.kt)
    - **파이썬** 에서의 스레드
        - 1. 단순 함수실행 (상태 없음)
        - 2. 상속(run 메소드 재정의)
        - 3. Timer 스레드 : `Time out` 기능
        - 스레드 기동을 위해 `start` 를 호출해야한다.
    - **안드로이드** 에서의 스레드
        - 파이썬과 동일하다 !
    - `ANR(Android Not Response)` : 응답이 없다 . .
        - 안드로이드가 앱을 실행할 때 앱에게 주기적으로 물어본다. ▶ watch dog mechanism
        - 즉 안드로이드가 응답에 대한 요청을 했을때 답이 없는 경우를 **ANR** 이라고 한다.
        - **ANR** 상태일 경우 프로그램이 종료된다.
    - 안드로이드는 `Main Thread` 가 아닌 `UI Thread` 라고 부른다.
    - 여러 **Thread** 가 하나의 자원에 동시에 공유하게 될 경우
        - Python : `lock`을 건다.
        - 안드로이드 : 화면 업데이트를 `UI Thread` 만 할 수 있도록 한다.
               - 작업스레드는 화면업데이트를 하기 위해 `UI Thread` 에 요청을 보낸다.
    - `UI Thread` 는 언제 끝날 지 모르는 작업은 하지 않는다.
        - 특히 **네트워크 수신작업** → 전송작업은 할 수 있다. 수신은 수신될 때 까지 `block` 상태이므로 . .
        - DB작업
2. ### [화면 변환 시 초기화 되는 문제 해결(MainActivity.kt)](./app/src/main/java/com/example/timer/MainActivity.kt)
    - 회전시 `Activity`는 **Destroy** 되고 다시 생성되어서 기존 운영되던 데이터는 사라지게 되기 떄문 . .
    - prference 를 통해 저장해두어야 한다!
    - `Bundle` 에 데이터를 넣어주고, , 다시 복원하자 , ,
    - 혹은 회전을 막자 !
        - *[AndroidManifest.xml](./app/src/main/AndroidManifest.xml)* 에서 **MainActivity** 에 속성을 추가.
        - `android:screenOrientation="landscape"` 와 같이 작성하면 **가로모드**로 고정된다.
        - 세로모드는 `portrait`
3. ### [뒤로가기 버튼 이벤트 작용(MainActivity.kt)](./app/src/main/java/com/example/timer/MainActivity.kt)
    - `onBackPressed` : 뒤로가기 버튼을 눌렀을때 작동하는 이벤트 핸들러
    - 만약 부모 클래스 호출을 지우면 뒤로가기 버튼을 눌러도 동작하지 않는다.
        - 상위클래스가 담당하고 있다.
    - 뒤로가기 버튼이 한번 클릭된 후 3초 이내에 **다시** 클릭 되었을 경우 프로그램 종료 기능 추가