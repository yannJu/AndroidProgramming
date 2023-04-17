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
    - *[MainActivity.kt](./app/src/main/java/com/example/uidesign_basic/MainActivity.kt)* 에서 `viewBinding` 을 **지연초기화** 를 통해 호출
        - **뷰 바인딩** 이 호출되어야 사용할 수 있는 객체이기 때문이다.
        - `ActivityMainBinding` 클래스 명은 `layout.xml` 에서 자동으로 만들어준다. → 따라서 그냥 정해진 것이 아닌 *[activity_main.xml](./app/res/layout/activity_main.xml)*을 따서 `ActivityMainBinding` 으로 저장된다.
        - 따라서 `R.layout.activity_main` 이 아닌 **binding.root** 가 들어가게 된다.
        - 이후에는 `binding.ID.text` 와 같이 접근하게 된다.