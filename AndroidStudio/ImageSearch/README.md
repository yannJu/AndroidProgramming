## Android Programming _ ImageSearch(_Retrofit)🌺

0. Kakao 에 이미지 검색 후 ListView 를 띄우기 위한 프로젝트
1. ### 라이브러리 추가
    - *[build.gradle](./app/build.gradle)* 에 다음과 같이 라이브러리 추가 : `glide`, 'retrofit'

        ```
        // glide
        implementation 'com.github.bumptech.glide:glide:4.13.0'
        annotationProcessor 'com.github.bumptech.glide:compiler:4.13.0'
        // retrofit
        implementation 'com.google.code.gson:gson:2.8.5'
        implementation 'com.squareup.retrofit2:retrofit:2.6.0'
        implementation 'com.squareup.retrofit2:converter-gson:2.6.0'
        ```
2. ### 인터넷 사용권한 설정
    - *[AndroidManifest.xml](./app/src/main/AndroidManifest.xml)* 에서 인터넷 연결 권한을 설정한다.

        ```
        <uses-permission android:name="android.permission.INTERNET"/>
        ```
3. ### 카카오 이미지 검색 API
    - `query` 는 필수로 들어가야 한다.
    - 그 외의 키들은 필요시 사용
    - `Authorization` 에 이전에 받은 API 키를 이용하면 된다.

    ![kakao Api](https://github.com/yannJu/AndroidProgramming/blob/master/img/a4_img.PNG)
    - `Kakao` 에서 응답받은 결과는 **Json** 문자열로 들어온다.
    - `Python`, `JS` 의 경우는 **사전** 으로 가능하지만 `Kotlin` 의 경우는 **객체(Data)** 타입을 정의해야한다. .
    - **Json** 을 `deserialize` 하는 역할이 필요하다. → `gson` : retrofit 시 같이 **implementation**
    - 하지만 수작업으로 하기에  번거롭다 . . . 자동화 `Plug-in` 을 이용하자!
        - File > Settings > Plug-in > Json to Kotlin Class
4. ### 객체 타입 정의
    - *[data](./app/src/main/java/com/example/imagesearch/data)* : 데이터를 보관할 **Package**
        - new > Kotlin data class file from Json

            ![img2](https://github.com/yannJu/AndroidProgramming/blob/master/img/a4_img2.PNG)
        - meta, document(List<document>) 객체 타입이 있음을 알 수 있다!
        - advance > gson 으로 설정
        - *[Document](./app/src/main/java/com/example/imagesearch/data/Document)*, *[Images](./app/src/main/java/com/example/imagesearch/data/Images)*, *[Meta](./app/src/main/java/com/example/imagesearch/data/Meta)* 생성된다 : `Images` 가 최상위
5. ### 정보 전달을 위한 객체 생성
    - *[service](./app/src/main/java/service)* : 패키지 생성 > interface 생성
        - [KakaoImageSeachService.kt](./app/src/main/java/service/KakaoImageSeachService.kt) : 인터페이스 생성
    - 정보들을 모아서 `웹서버` 에게 보낼 **request** 객체를 구성
    - `@Header` : 이전에 발급받은 API Key
    - `@GET` : `GET` 요청을 받는 것을 알 수 있다.
    - `@Query` : `Query` 파라미터로 들어가는 것을 정의
    - `Call` : **return** 타입
        - `<images>` : 응답을 받았을 때 json 문자열에서 변환할 객체 타입
6. ### 정보를 위한 interface 생성
    - [KakaoImageSeachService.kt](./app/src/main/java/service/KakaoImageSeachService.kt) : object 생성
        - `object` : **singleton** 객체
            - 오직 1개의 인스턴스만 존재
            - **직접** 생성자를 호출할 수 ***없다***.
            - 시스템에서 자동으로 1개만 생성해준다.
    - 이후 `retrofit.create` 를 이용하여 **interface** 자동 생성 . .
7. ### Layout 생성
    - `Main Layout` 생성 → 이때 `Recycler View` 추가
        - *[item_image.xml](./app/src/main/res/layout/item_image.xml)* : `RecyclerView` 를 위한 Item Layout 생성
8. ### Adapter 생성
    - `RecyclerView` 가 생성되었기 때문에 `Adapter` 추가
    - *[ImageListAdapter.kt](./app/src/main/java/com/example/imagesearch/ImageListAdapter.kt)* : Adapter 설정
    - 생성자를 통해 `ImageList` 를 받아온다.
9. ### 검색 후 응답 받아오기
    - `MainActivity` 에서 **ImageList** 불러온다.
    - *검색* 버튼 이벤트 처리
    - UI Thread : UI 작업전담 스레드 -> ANR 주의
        - 시간이 많이 걸리는 작업 : 특히 `Network`, `DB`, `데이터 수신`. . .
        - 작업 스레드가 해야한다. . !
        - `Retrofit` 이 내부 스레드를 운영
        - 따라서 네트워크 처리를 전담 → `Queue` 에 넣어준다. (`Call` 객체가 작업을 한다.)
    - `Call` 에 응답이 온다.
        - 응답 = `CallBack`, `onFail`, `onResponse` 가 있다.
        - `onFail` : 응답 실패
        - `onResponse` : 응답 성공
    - `body` 의 타입이 이미 `json` 에서 `Images` 객체로 변환되어있다.