## Android Studio _ UIDesign_Basic 🥞

1. ### [View 객체 접근하기 _ View Binding](#)
    - `apply` 표준함수를 이용하여 연속 호출을 한다.
            - 객체 호출을 줄일 수 있다.
    - `findViewId` 가 아닌 **View Binding** 을 사용하기 위한 환경설정이 필요하다.
    - *[build.gradle](./app/build.gradle)* 에서 다음과 같이 작성하여 `viewBinding` 실행

        ```gradle
        buildFeatures {
            viewBinding = true
        }
        ```
        - `gradle` 동기화가 제대로 되었다면 *[MainActivity.kt](./app/src/main/java/com/example/uidesign_basic/MainActivity.kt)* 에서 `view Binding` 호출시 다음과 같이 자동으로 호출되게 된다.

        ```
        import com.example.uidesign_basic.databinding.ActivityMainBinding
        ```
    - *[MainActivity.kt](./app/src/main/java/com/example/uidesign_basic/MainActivity.kt)* 에서 `viewBinding` 을 **지연초기화** 를 통해 호출
        - **뷰 바인딩** 이 호출되어야 사용할 수 있는 객체이기 때문이다.
        - `ActivityMainBinding` 클래스 명은 `layout.xml` 에서 자동으로 만들어준다. → 따라서 그냥 정해진 것이 아닌 *[activity_main.xml](./app/res/layout/activity_main.xml)* 을 따서 `ActivityMainBinding` 으로 저장된다.
        - 따라서 `R.layout.activity_main` 이 아닌 **binding.root** 가 들어가게 된다.
        - 이후에는 `binding.ID.text` 와 같이 접근하게 된다.
    - 여러개의 `View`를 **Drag and Drop** 으로 위치하게 둘 경우, 각 `View`들은 다른 `View`에 제약이 걸리도록 할 수 있다.
        - 제약을 두지 않은 경우 **가장 가까운** `View`에 제약이 걸리게 된다.
    - `constraintlayout` 은 기능확장 되면서 추가된 경우 (= 나중에 추가된 기능) 는 `androidx.constraintlayout . . ` 와 같이 앞에 태그가 붙는다.
        - `button`, `text`  . . 등은 단독으로 사용된다. (= 처음부터 만들어져 있던 기능)
2. ### [EventHandling](#)
    - *[activity_main.xml](./app/src/main/res/layout/activity_main.xml)* 에서 띄워둔 `View`들 중 **이벤트 핸들링** 할 `View`에 **ID**를 지정
    - *[MainActivity.kt](./app/src/main/java/com/example/uidesign_basic/MainActivity.kt)* 에서 `View.setOnClickListener` 를 통해 이벤트 처리
        - 특정 상황이 발생할 때 까지 기다리다가 **호출** 되는 이벤트
        - 이후 `Listener` 내부에 동작을 처리하는 `Handler`가 있다. → **람다함수** 로 구성할 수 있다.(`apply` 등. .)
        - 즉 **람다함수** 가 `callback` 함수의 기능을 한다.
    - `setOnClickListener` 는 생략된 매개변수가 있다.
        - 하지만 실제로 `it`, `this` 를 사용하면 오류 발생
        - **type** 으로 인한 오류 → `it` 은 `View` 라는 그래픽 요소의 최상위 타입
            - 최상위 타입에는 `text`, `setTextColor` 등이 없다 . . .
        - 따라서 그 하위의 `Button`, `Text`등의 타입으로 진행해야한다.
        - 혹은 **타입 변환** 을 통해 동작 ▷ `as` 를 통해 `it` 을 `TextView`로 변환
    - 글자 색상 조정 : `Color.parseColor` VS `Color`
        - `Color.parseColor` : 문자열을 분석하여 **색상** 을 정보화 및 지정
    - `Html.fromHtml()` 을 통해 `Html 문자`를 사용할 수 있다.
        - **링크** 까지 적용할 수 있다.
3. ### [Edit Text 활용(EditTextActivity.kt)](./app/src/main/java/com/example/uidesign_basic/EditTextActivity.kt)
    - *[AndroidManifest.xml](./app/src/main/AndroidManifest.xml)* 를 통해 **Main Activity** 를 *[EditTextActivity.Kt](./app/src/main/java/com/example/uidesign_basic/EditTextActivity.kt)* 로 수정하여 실행한다.
        - 더불어 *[edit_text.xml](./app/src/main/res/layout/edit_text.xml)* 에 *[EditTextActivity.Kt](./app/src/main/java/com/example/uidesign_basic/EditTextActivity.kt)* 로 수정한다.
    - 구성화면은 다음과 같이 **로그인** 화면을 구성하였다.

        ![]()
    - 이름을 입력하는 `inputName` 에 **setOnFocusChangeListener** 동작시켜 포커스를 얻었는지의 여부를 확인한다.
        - `hasFocus`가 **true** 인경우 포커스가 발생한 이벤트에 대한 처리를 진행한다.
    - `addTextChangedListener()` : `Text`가 변경되는 것을 확인하는 `Listener`
        - 이전에는 **람다함수** 하나로 이루어져있었다면 `TextWatcher` 라는 인스턴스가 매개변수로 들어간다.
            - 또한 ***여러개*** 의 이벤트가 발생한다.
        - `afterTextChanged`, `beforTextChanged`, `onTextChanged` 등의 함수를 **override** 할 수 있다.
4. ### [LogCat 활용(LogCatActivity.kt)](./app/src/main/java/com/example/uidesign_basic/LogCatActivity.kt)
    - `LogCat`을 이용하여 로그를 확인할 수 있다.
    - 또한 직접 `Log`를 줄 수 있다.
        - `Log.d([로그내용])` 으로 작성.
    - `LogCat` 에서 자신이 작성한 로그 혹은 특정 로그를 볼 때 **필터링** 해서 볼 수 있다.

    ![](.../img/a2_img.PNG)
    - `Tag` 라는 문자열을 씀으로써 반복된 문자 사용 줄이기 → 주로 `Tag`로 쓰는 문자열은 **클래스** 명을 쓴다.