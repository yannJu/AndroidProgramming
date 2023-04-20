## Android Programming _ CustomWeb🍍

1. ### [인터넷 연결 전 설정(AndroidManifest.xml)](./app/src/main/AndroidManifest.xml)
    - 인터넷을 사용하기 위해서 **AndroidManifest.xml** 파일에 공지를 해 주어야 한다.

        ```
        <uses-permission android:name="android.permission.INTERNET"/>
        ```
    - 위의 문구를 추가하여 **인터넷 연결** 명시
    - 안드로이드9 이후부터 `https` 만 지원된다. 따라서 `http`로 통신하고 싶다면 다음을 추가한다.

        ```
        android:usesCleartextTraffic="true"
        ```
2. ### [WebView 띄우기(MainActivity.kt)](./app/src/main/java/com/example/customweb/MainActivity.kt)
    - `WebView`를 이용하여 웹 브라우저 접근
    - `onPageFinished` 는 웹뷰가 URL 로딩이 완료되면 호출된다.
    - `imeOption` 에서 **Search** 로 설정하여 검색 아이콘으로 엔터가 변경
        - 이후 `Action` 발생 이벤트 처리를 통해 사용 가능
        - 처리한 경우 `true` 아닌경우 `false`를 리턴
    - 현재는 `http://`를 작성하지 않으면 Search 되지 않기 때문에 `startsWith` 를 통해 검사한다.
3. ### [뒤로가기 동작 재정의(MainActivity.kt)](./app/src/main/java/com/example/customweb/MainActivity.kt)
    - 현재는 뒤로가기 버튼을 클릭하면 프로그램이 **닫히게** 된다.
    - **이전 페이지** 로 이동하도록 재정의
    - `onBackPressed()`를 재정의하고 webView의 `goBack()`을 호출한다.
4. ### [화면 전환시 데이터 유지 _ Bundle(MainActivity.kt)](./app/src/main/java/com/example/customweb/MainActivity.kt)
    - `onSaveInstanceState` 를 override 한다.
    - 들어오는 매개변수 `outState: Bundle`에 **putExtra** 처럼 저장한다.

        ```
        outState.putString("URL", url)
        ```
    - 위와 같이 `putString` 한다.
    - 불러올때는 `getString` 과 같이 불러온다.