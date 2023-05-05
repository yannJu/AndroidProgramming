## Android Programming _ Retrofit2

1. ### Drawer 사용
    - 앱을 실행시키면 아래와 같이 **Drawer** 들이 있다.

        ![img1]()
    - 각각 아이템을 클릭할 때 마다 `Fragment` 교체
    - *[mobile_navigation.xml](./app/src/main/res/navigation/mobile_navigation.xml)* 에 각각의 `Fragment` 를 확인할 수 있다.
        - **Drawer** 에 의해 독립적으로 실행되므로 각 `Fragment` 의 연관성은 없다.
2. ### Drawer ToolBar Control
    - *[MainActivity.kt](./app/src/main/java/com/example/retrofit2/MainActivity.kt)* 를 보면 **ToolBar** 관리를 한다는 것을 볼 수 있다.

        ```Kotlin
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow // 빠뜨리면 안된다 . . .!
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        }
        ```
3. ### Drawer 방식의 ViewModel
    - 세로 / 가로 모드의 경우도 각각 설정할 수 있다.
    - 다음과 같이 `ViewModel` 을 직접 지정해 줄 수 있다.

        ```Kotlin
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        ```
    - 위의 코드를 사용하면 회전하더라도 이전의 데이터를 계속 가지고 있는다.
4. ### Drawer 의 observer
    - `observer` 에 의하여 값이 변경되는 것을 확인 할 수 있다.
    - 변경된 데이터를 바로 화면에 적용할 수 있다.
5. ### IoT 보안 카메라 연동하기
    - *[activity_main_drawer.xml](./app/src/main/res/menu/activity_main_drawer.xml)* 에서 **Drawer** 의 아이콘과 ID 변경
    - *[mobile_navigation.xml](./app/src/main/res/navigation/mobile_navigation.xml)* 에서 `Fragment` 의 내부를 조정
    - 보안 카메라 영상들의 **리스트** 를 받아오기 위해 `Recycler View` 사용
        - *[fragment_security_cam.xml](./app/src/main/res/layout/fragment_security_cam.xml)* 에 `Recycler View` 를 추가한다.
        - *[item_sec_file.xml](./app/src/main/res/layout/item_sec_file.xml)* 을 생성하여 *[fragment_security_cam.xml](./app/src/main/res/layout/fragment_security_cam.xml)* 에 들어갈 **Item** 레이아웃 작성
    - *[SecurityCam.kt](./app/src/main/java/com/example/retrofit2/ui/securitycam/SecurityCam.kt)* 에 `val secFileList = mutableListOf<SecFile>()` 를 추가하여 받아올 **SecFile List** 를 만들어준다.
    - `Adapter` 를 내부클래스로 생성
    - `Retrofit` 작업 진행하기
6. ### Retrofit 작업
    - *[securitycam](./app/src/main/java/com/example/retrofit2/ui/securitycam)* 에 패키지 하나 추가 > *[service](./app/src/main/java/com/example/retrofit2/ui/securitycam/service)*
        - 해당 패키지에 *[IoTService.kt](./app/src/main/java/com/example/retrofit2/ui/securitycam/service/IoTService.kt)* 추가 : **Interface** 로 생성
    - 이때 `url` 하나당 메소드 하나 !

        ```Kotlin
        interface IoTService {
            @GET("/api/sec_file/")
            fun requestSecFileList(@Query("page") page: Int)
        }
        ```
        - **페이지네이션** 까지 구분할 수 있다.
    - 또한 `Singleton` 객체를 생성하여 **url** 과 구현할 **Interface** 클래스 정보를 수정한다.

        ```Kotlin
        // singleton 객체
        object IoT {
            private val retrofit = Retrofit.Builder()
                .baseUrl("http://172.20.10.11:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service get() = retrofit.create(IoTService::class.java)
        }
        ```
    - 인터넷 사용 권한 주기
        - `<uses-permission android:name="android.permission.INTERNET"/>`
            - 위험 권한이 아니므로 따로 추가할 내용 없다.
        - `android:usesCleartextTraffic="true"`
            - `http` 설정
7. ### API 연동하기
    - `onViewCreated` 에서 **Adapter** 연결 및 **Api** 호출
    - `api` 호출시 성공 / 실패 골격을 필수적으로 작성
        - 성공 시 어떻게 **body** 를 출력할 것인가 ?
        - `SecFileList` 에 전부 추가해 준다. .

    ![img2]()
8. ### URL 클릭 후 링크 연결하기
    - 새로운 `Fragment` 를 추가하여 연결된 **url** 로 이동
        - *[VideoFragment.kt](./app/src/main/java/com/example/retrofit2/ui/securitycam/VideoFragment.kt)*
    - *secFileList* 에서 원하는 **Item** 을 선택하면 다른 `Fragment` 로 이동하기 위해 **nav** 설정
    - *[SecurityCam.kt](./app/src/main/java/com/example/retrofit2/ui/securitycam/SecurityCam.kt)* 에서 `Fragment` 이동을 설정한다.
    - 이후 이동한 `Fragment` 에 **url** 을 함께 전달해 주어야 한다!!!!
    - `Bundle` 에 **url** 을 함께 전달
        - `putString` 을 이용하여 전달하면 된다.
9. ### Video 띄우기
    - `videoView` 에 연결한다. (`apply` 사용)
    - `setVideoPath` 를 이용하여 **url** 연결 후 `start()` 를 하면 동영상이 재생된다.
    - `setMediaController(MediaController(requireContext()))` 를 이용하여 비디오 재생 컨트롤러를 추가할 수 있다.
10. ### MJpeg View 를 이용하여 실시간 스트리밍 하기
    - *[settings.gradle](./settings.gradle)* > `maven { url 'https://jitpack.io'}` 추가
    - *[build.gradle](./app/build.gradle)* > `implementation 'com.github.niqdev:ipcam-view:2.3.4'` 추가
    - `Fragment` 추가 후 기본 세팅 하기 > **Drawer** 에 **Item** 추가 . . , Nav 에 **fragment** 추가 . . 등
    - *[fragment_stream.xml](./app/src/main/res/layout/fragment_stream.xml)* 에 stream 추가
    - `Stream` 을 쓰는 곳의 **Main** 에 `초기화, Clean Up` 과정을 추가하자 . .