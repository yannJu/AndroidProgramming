## Android Programming _ Toast 🍟

1. ### [Toast Basic(MainActivity.kt)](./app/src/main/java/com/example/toast/MainActivity.kt)
    - 버튼을 클릭하면 **Toast** 가 발생하도록 구현
    - `Toast` 는 사용자에게 간단한 문자열을 짧은 시간 동안 보여준다. → 따라서 못보고 지나칠 수 있다.
    - `makeText` 를 통해 생성
        - Context : Activity / String : 출력 내용 / duration : 출력 시간
    - `show` 를 이용하여 만든 `Toast` 출력
2. ### [레이아웃 추가 기능]
    - 선의 좌표, 속성값을 이용하여 그림을 그리는 방법이 있다. ▶ *[drawable](./app/src/main/res/drawable)*
    - `drawable` 에서 **XML** 파일 하나 생성 : *[back.xml](./app/src/main/res/drawable/back.xml)*
        - `background`와 관련된 **xml** 을 생성하여 추후에 사용할 수 있다.
3. ### [Activity 를 Toast로 띄우기(MainActivity.kt)](./app/src/main/java/com/example/toast/MainActivity.kt)
    -   **Toast** 를 Custom 해서 띄울 수 있다.
    - `layoutInflater` 는 부모 클래스에 정의되어 있으므로 별도로 정의할 필요가 없다.
    - `layoutInflater` 를 이용하여 **R.layout.[불러올 layout]** 을 통해 레이아웃을 가져온다.
        - `viewBinding` 을 쓸 경우에는 꼭 `root`에서 가져와야 한다.
    - 이후 가져온 레이아웃을 **Toast** 에 대입해주면 커스텀이 완료된다 . . !