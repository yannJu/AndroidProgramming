## Android Programming _ Toast 🍟

1. ### [Toast Basic(MainActivity.kt)](./app/src/main/java/com/example/toast/MainActivity.kt)
    - 버튼을 클릭하면 **Toast** 가 발생하도록 구현
    - `Toast` 는 사용자에게 간단한 문자열을 짧은 시간 동안 보여준다. → 따라서 못보고 지나칠 수 있다.
    - `makeText` 를 통해 생성
        - Context : Activity / String : 출력 내용 / duration : 출력 시간
    - `show` 를 이용하여 만든 `Toast` 출력