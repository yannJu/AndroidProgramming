## Android Programming _ Menu 🍀

1. ### [상단바 작업을 위한 사전처리]
    - *[menu](./app/src/main/java/com/example/menu)* 폴더의 `Fragment` 파일 2개 삭제
    - *[layout](./app/src/main/res/layout)* 폴더에서 'activity_main.xml' 제외하고 삭제
    - *[MainActivity.kt](./app/src/main/java/com/example/menu/MainActivity.kt)
        - `29-37` 주석처리
        - `onSupportNavigateUp` 주석처리
        - 이전 `CustomWeb` 에서 작성한 `MainActivity.kt` 내용 부분 가져오기
    - *[activity_main.xml](./app/src/main/res/layout/activity_main.xml)*
        - `floatingactionbutton` 주석처리
    - *[content_main.xml](./app/src/main/res/layout/content_main.xml)*
        - 이전에 지웠던 파일 다시 생성 . . .
        - 이전 `CustomWeb` 에서 작성한 `activity_main` 전체를 복사하여 붙여넣기
2. ### [옵션 메뉴 사용]
    - `onCreateOptionMenu()` : Activity 생성시 한번 호출, `메뉴 생성`시에 호출된다.
    - `onOptionItemSelected()` : `메뉴 선택` 시 호출된다.
    - *[menu/menu_main.xml](./app/src/main/res/menu/menu_main.xml)* 에서 메뉴 View 추가
        - `subMenu`를 만들기 위해 `Menu`를 만들고 하위에 `MenuItem`들을 추가
        - 또한 `Home` 메뉴를 만든 후 **showAsAction** 속성을 `ifRoom` 으로 설정
            - 툴바에 여유가 있으면 노출하도록 설정
    - `onCreateOptionsMenu` 를 재정의 하여 *[menu/menu_main.xml](./app/src/main/res/menu/menu_main.xml)* 자원을 `Inflate`
    - `onOptionsItemSelected` 를 통해 메뉴가 선택된 후의 동작 설정
        - `inflate`를 이용하여 자원 가져오기
3. ### [컨텐스트 메뉴 추가]
    - 특정 뷰를 **길게** 클릭하면 표시되는 메뉴 > 윈도우에서는 **우측클릭**
    - 리소스 작성 후 **특정 뷰** 에 컨텍스트 메뉴 연결

        ```
        registerForContextMenu(binding.contentLayout.webView)
        ```
        - 를 통해 `webView`에 컨텍스트 메뉴 연결
    - `onCreateContextMenu` 를 통해 생성하고 `onContextItemSelected`로 메뉴 선택 이벤트 처리
    - `onCreateContextMenu`
        - `inflate` 를 통해 해당 **xml**의 자원을 `ContextMenu`로 가져온다.
    - `onContextItemSelected`
        - **2번** 에서 했던 것 처럼 선택된 메뉴에 대한 이벤트 처리 구현