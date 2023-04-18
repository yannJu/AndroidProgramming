## Android Programming _ Activity 🌺

0. ### Activity
    - 화면 하나를 관리하는 요소
    - 서비스(Background 작업), Content Provider(DB 작업), Broadcast Receiver(Event 수신기) : 화면요소는 아니다 . .
    - **Activity LifeCycle**
        - 프로그램이 시작하면 생성자(**Activity Launched**) 실행
        - 이후 **onCreate()** 되다가 **Activity Running** 상태가 되면 화면에 내보낸다.
        - 만약 새로운 `Activity`가 화면에 뜬다면 이전의 `Activity`는 가려지게 된다.
            - 뒤의 `Activity`는 상호작용하지 않기 때문에 **onPause**가 호출된다.(일부 영역 가려짐, 대화상자 띄우기 등 . .)
            - 이후 **onStop** 으로 전체 영역이 가려지게 될 수 있다.
                - **onRestart** 로 복원될 수 있다.
                - **[비정상적 실행]** : **kill** 로 프로그램이 꺼질 수 있다 . . .→ 메모리 부족 등 . . (보통 맨위의 Activity는 죽지 않고 가려진 Activity들이 죽게 된다.)
            - 혹은 화면이 복원되어 **onResume**으로 돌아갈 수 있다.
1. ### [Life Cycle 추적(MainActivity.kt)](./app/src/main/java/com/example/activity/MainActivity.kt)
    - `onCreate`, `onPause`, `onStop`, `onRestart`, `onResume` 이 언제 실행되는지 **override** 를 통해 확인.
    - ctrl + o 를 통해 부모로 부터 상속받은 메소드들이 나열되는 것을 확인할 수 있다.
