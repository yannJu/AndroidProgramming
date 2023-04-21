## Android Programming _ Gallery

0. ### 콘텐츠 프로바이더
    - 앱의 **데이터 접근** 을 다른 앱에 허용하는 컴포넌트
        - 미디어 데이터, 전화부 . .
    - 안드로이드의 기본 구성 4가지 중 하나 : Activity(화면 담당), Service(Background 작업), BroadCast Receiver, **Content Provider(DB서버 역할)**
    - 데이터에 접근하여 전달하기 위해서는 `권한` 이 필요 > 사용자에게 `권한 요청` (위험권한)
1. ### 데이터 접근 권한 설정
    - *[AndroidManifest.xml](./app/src/main/AndroidManifest.xml)* 에서 다음 구문 추가

        ```
        <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
        ```
        - `SD카드` 접근 권한 *(READ_EXTERNAL_STORAGE)* 을 허용
    - 이후 실제 실행 시 **사용자** 로부터 권한 허락을 받아야 한다.
    - **한번** 만 권한 설정을 하면 된다.
        - 이전에 권한을 주었는지 확인해야한다. (실행마다)
    - *[MainActivity.kt](./app/src/main/java/com/example/gallery/MainActivity.kt)* 에서 `ContextCompat.checkSelfPermission` 메서드를 추가하여 **권한 여부** 확인
        - **2번** 거부하면 사용자가 완전히 거부하였다고 판단 > 요청을 하지 않는다.
    - `requestPermissionLauncher` 를 이용하여 권한 허용 여부에 따른 동작 실행
        - 해당 함수를 접근할 **데이터** 를 이용하여 호출

            ```
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            ```
    - 권한이 **허용** 된 경우 불러올 함수 정의 → `getAllPhotos` : 갤러리 사진 불러오기
        - `Uri` 를 이용하여 **파일 경로** 불러오기
        - `query` 를 통해 **SELECT** 문 호출
            - MediaStore.**Images**. ~~ > 이미지에 접근한다는 의미 (= 이미지 **테이블** 에 접근)
            - 오디오 접근시 **Audio** ?
        - `null` 을 쓰면 `*` 와 동일한 의미
    - `Cursor` 를 이용하여 불러온 데이터의 **ID** 를 `Uri` 에 결합
        - `cursor.get<데이터타입>` 을 이용하여 컬럼명(MediaStore.Images.Media._ID)을 `getColumnIndexOrThrow` 로 예외처리까지 하여 ID추출
        - 기본 컨텐트 `Uri`에 **ID** 결합 > `withAppendedId`
2. ### Fragment(프래그먼트)
    - 조각, 재사용 가능한 사용자 인터페이스의 모음
    - `Activity` 내에서만 사용 가능 > **단독** 사용 불가. (마치 View 처럼)
    - `Activity` 는 유지하면서 화면을 바꾸고자 할 때 주로 사용 . .
        - 한 `Activity` 의 여러개의 **Fragment** 사용 가능
    - **Fragment Life Cycle**
        - 생성 후 Activity에 **Attach**
        - OnCreate
        - ***가장중요*** OnCreateView : 프래그먼트 View 생성
        - OnActivityCreated
        - 이후 프래그먼트 활성화 . . .
    - *[PhotoFragment.kt](./app/src/main/java/com/example/gallery/PhotoFragment.kt)* > 프래그먼트 클래스 생성
        - 레이아웃도 함께 생성된다. > *[fragment_photo.xml](./app/src/main/res/layout/fragment_photo.xml)*
3. ### 파일에 있는 이미지를 가져와 기존 `ImageView` 변경
    - 이미지처리가 굉장히 **복잡** 하기 때문에 이미지 처리 `라이브러리` 사용 : `coil` 라이브러리 사용
        - [mvnrepository:coil](./https://mvnrepository.com/search?q=coil)
        - maven 레포지토리에서 **gradle(short)** 로 가져온다.
        - *[build.gradle](./app/build.gradle)* 의 `dependencies` 에 추가
    - `onCreate` 로 **key** 로 쓸 상수의 값을 이용해 프래그먼트 생성
    - `onCreateView` 로 설정한 `layout` 에 맞추어 뷰 생성
    - `companion object` 를 상수로 쓰는 것이 아닌 **instance** 를 만들어 사용
        - 들어오는 두개의 매개변수 를 이용하여 전달
        - 이후 전달된 것들 `onCreate` 에서 생성
        - `putParcelable` 을 이용하여 변환 가능하도록 . .
    - 현재 **key** 로 들어오는 상수(**uri**) 는 출력할 이미지의 `uri`
    - `onViewCreated` 에서 작업을 해야 ***화면에 뜨게 된다!***
        - 프래그먼트를 이미지 변경에 사용할 예정
        - `imageView` 를 가져와서, **uri** 로 접근한 컨텐츠를 해석하고 `imageView`에 결합하여 이미지를 변경시킨다.
        - `contentResolver` : 컨텐츠 프로바이더에 의해 해석
        - `openFileDescriptor` : 읽기
        - `use` : 람다가 끝날때 자동으로 **close**
    - `coil.load()` > coil 에서 호출했지만 상속하지 않고 기능을 사용할 수 있도록 하는 특성이 있어서 `imgView` 에서 호출한 것 처럼 사용 가능
4. ### 좌우로 슬라이드 하는 뷰 생성
    - `Adapter` 가 연결되어서 뷰페이저가 보여줄 프래그먼트를 정의
        - `Adapter` 가 다음 프래그먼트와 **결합** 해서 보여주는 형태
    - `createFragment` 를 통해 **position** 위치의 프래그먼트 생성 후 리턴한다.
        - 왜 직접호출하지 않고 `newInstance` 로 전달? →
    - *[MainActivity](./app/src/main/java/com/example/gallery/MainActivity.kt)* 에서 프래그먼트 결합
        - `supportFragmentManager` 와 `lifecycle` 은 **Activity**의 멤버변수
    - 슬라이드시 **반만** 슬라이드해도 **이전, 이후** 이미지가 다 보이게 된다.
        - 프래그먼트는 약 3개의 소스가 만들어진다. > 이전, 현재, 다음
        - 하지만 **회전** 시 모든 소스가 삭제되고 새로 만들어진다 . . .
        - `fragmentManager` 가 회전시 프래그먼트의 **파괴** 및 **복원** 을 담당
            - `Bundle` 이 이를 복원해준다 . .

            ```
            fun newInstance(uri: Uri) =
                        PhotoFragment().apply {
                            arguments = Bundle().apply {
                                putParcelable(ARG_URI, uri)
                            }
                        }
            ```
            - 위를 보아도 `Bundle` 이 쓰이는 것을 볼 수 있다.
5. ### 3초 간격으로 자동 슬라이드 되는 기능 추가
    - `timer` 를 이용하여 **Recycler View** 와 동일하게 구현
---
생성한 프래그먼트를 꼭 메모리에서 제거 해주어야 한다.
`onDestroyView` 에서 **null** 할당 필수 . . .