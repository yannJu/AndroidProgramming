## Android Programming _ Activity 🌺

### 구조 정리

*[LifeCycleActivity.kt](./app/src/main/java/com/example/activity/LifeCycleActivity.kt)* & *[life_cycle_activity_main.xml](./app/src/main/res/layout/life_cycle_activity_main.xml)*
    → `Android Life Cycle` 를 확인하기 위해 각종 **override** 확인 가능

*[MainActivity.kt](./app/src/main/java/com/example/activity/MainActivity.kt)* & *[activity_main.xml](./app/src/main/res/layout/activity_main.xml)*
    → `Intent` 실습 : Uri 예제 (메시지, 인터넷, Map, Market . .)
    → 다른 `Activity`로 전환하는 예제의 Main (암시적/명시적호출)

*[MainActivity2.kt](./app/src/main/java/com/example/activity/MainActivity2.kt)* & *[activity_main2.xml](./app/src/main/res/layout/activity_main2.xml)*
    → *[MainActivity.kt](./app/src/main/java/com/example/activity/MainActivity.kt)* 에서 `Intent`를 넘겨주는 실습 진행

*[MainActivity3.kt](./app/src/main/java/com/example/activity/MainActivity3.kt)* & *[activity_main3.xml](./app/src/main/res/layout/activity_main3.xml)*
    → *[MainActivity.kt](./app/src/main/java/com/example/activity/MainActivity.kt)* 에서 `Intent`를 넘겨주는 실습 진행 및 값 반환 . .

---
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
    - 회전시킨 후 **onCreate** 로 화면을 새로 만드는 것이 훨씬 쉽다 !?
        - 데이터를 가공해 두었는데, 회전시켰더니 데이터가 날라가게 되는 경우 발생 . . . → **가로모드** 의 layout 생성으로 유지하자 . .
        - *[layout-land/activity_main.xml](./app/src/main/res/layout-land/activity_main.xml)* 로 덮어씌워진ㄷ ㅏ. .
2. ### [Intent의 이해]
    - **컴포넌트** 간 정보 전달을 위해 사용
        - Q. 컴포넌트란 ? ▶ Activity, Services, BroadCast Receiver, Content Provider
    - 예를 들면 두개의 `Activity` 를 가질때, 다른 `Activity` 를 참조할 수 없다
    - 따라서 `Activity`가 하려고자 하는 내용을 **Intent**에 기술하여 Android에 전달하면 분석 후 다른 `Activity`에 동작 수행을 진행
3. ### [Intent 와 Activity 실습(MainActivity.kt)](./app/src/main/java/com/example/activity/MainActivity.kt)
    - `Uri.parse` : **Uri** 지정
    - `ACTION_SENDTO` : 지정한 Uri로 보내겠다 . .!
    - 추가 정보를 작성하기 위해서는 `putExtra` 작성
    -`intent` 의 수신자를 지정하지 않고 **행위** 만 지정 ▶ 암시적 인텐트 호출
        - 누가 이 `intent`를 받을지에 대한 선택은 안드로이드가 지정
    - 수신자를 지정하여 호출 ▶ 명시적 인텐트 호출
4. ### [명시적 인텐트 호출(MainActivity1.kt)](./app/src/main/java/com/example/activity/MainActivity.kt)
    - 여러개의 Activity를 가질때 직접 다른 `Activity`로 Intent를 넘겨준다.
    - `Intent(this, [가고자하는 Activity]::class.java)` 를 이용하여 `this` 호출자가 Activity를 직접 호출
    - 값을 전달 하고 반환 받아보자 . .
        - Activity 1 → Activity 3 (매개변수에 해당) : `startActivityForResult`로 호출
        - Activity 1 ← Activity 3 (리턴값에 해당)
    - `startActivityForResult(intent, requestNum)` 을 통해 다른 Activity 로부터 반환값 요청
        - 이때 **requestNum** 은 개발자가 직접 정하는 것 !
    - `onActivityResult` 를 통해 requestCode, resultCode, data 를 받아오고 이때 **data** 는 `Null`을 허용한다.
        - 따라서 `let`을 통해, **data**가 Null 이 아니면 `txtResult`에 **data**를 대입해준다.
5. ### [명시적 인텐트 호출에 대한 result(MainActivity3.kt)](./app/src/main/java/com/example/activity/MainActivity3.kt)
    - 반환을 위해 `onStart` 상태일 때, 값을 리턴하도록 한다.
    - 이때 **intent** 는 `null`이 허용된다. → 따라서 `?:`를 통해 처리를 해준다.
    - `MainActivity`가 아니기 때문에 클래스 명 전체를 작성해 주어야 한다.
    - `setResult` 는 이번 Activity의 **result** 값을 설정하고, 복귀값을 지정하는 것 뿐이다. ▶ 바로 복귀하는 것은 아니다. **resultActivity** 가 닫힐때 복귀
        - `setResult`의 두번째 인자가 `MainActivity`의 **data** 에 대한 **result** 이다.
    - +) 추가
        - `onStart` 에서 `setResult` 해주던 부분을 **버튼 클릭시** 로 변경
        - 따라서 `OK` 버튼을 클릭했을 때에 **Result_OK** 에 의해 복귀하도록 . . → `Cancel` 버튼시에는 **setResult** 가 없으므로 돌아오면 빈 값