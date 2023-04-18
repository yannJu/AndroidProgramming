## Android Studio _ Calculator 🧀

1. ### [인터페이스 구현(activity_main.xml)](./app/src/main/res/layout/activity_main.xml)
    - 상단에 입력 `EditText View` 2개와 **+**, **-** 버튼을 구성하고 그 아래에는 결과값을 나타내는 `TextView` 구성
        - `Number`로 된 `TextView`를 선택하면 입력값을 숫자로만 받을 수 있다.
2. ### [기능 구현(MainActivity.kt)](./app/src/main/java/com/example/calculator/MainActivity.kt)
    - 덧셈, 뺄셈과 관련된 단일 표현식 작성
    - 단일 표현식을 이용할 **계산함수(calculate)** 작성
        - 매개변수로 Int가 두개 들어가는 함수 인자를 받는다.
    - `return@람다함수` 와 같이 작성하면 **람다함수** 를 종료할 수 있다.
        - 그냥 `return` 만으로는 **람다함수** 종료가 되지 않는다.