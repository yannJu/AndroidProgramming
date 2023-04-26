## Android Programming _ Gallery2

### 프로젝트 구조 정리
* `MainActivity` 에서 **Fragment** 를 연결한다.
* `PhotoList` 와 `PhotoDetail` 을 생성, ,
* 이때 `Photo List` 는 **Recycler View**와 연결한다.
---

1. ### Fragment 사용하기
    - [PhotoDetailFragment.kt](./app/src/main/java/com/example/gallery2/PhotoDetailFragment.kt) & [fragment_photo_detail.xml](./app/src/main/res/layout/fragment_photo_detail.xml) 와 [PhotoListFragment.kt](./app/src/main/java/com/example/gallery2/PhotoListFragment.kt) & [fragment_photo_list.xml](./app/src/main/res/layout/fragment_photo_list.xml) 를 이용
    - **MainActivity** 에서 미디어에 접근
    - 미디어 목록을 **PhotoListFragment** 에 넘겨준다.
        - 이때 `Adapter` 필요
    - **PhotoListFragment** 에서 사진에 직접 접근 → **PhotoDetailFragment**
2. ### [PhotoAdapter 만들기(PhotoAdapter.kt)](./app/src/main/java/com/example/gallery2/PhotoAdapter.kt)
    - `Adapter` 를 만들기 위해 **레이아웃** 과 연동
    - `Recycler View` 를 상속받고 필요 메소드 **override**
    - Fragment 를 `Recycler View` 와 연결하기 위해 **Adapter** 를 연결하는데, 이때 `Fragment`는 **context** 가 아니므로 레이아웃 지정이 제대로 이루어지지 않는다.
        - `requireContext` 를 이용하여 알맞게 불러온다.
3. ### List Fragment 에서 Uri를 직접 접근하자.
    - `MainAcitivity` 에서 `Fragment` 로 코드를 옮긴다.
        - 권한 요청 처리
        - 권한 접근 허용 후 동작 함수
    - 코드를 옮기는 이유는 다음과 같다.
        - Photo adapter 에 uri 를 넘겨줘야하는데(Photo Adapter 가 Uri 를 인지해야하므로) Photo Adapter 는 List fragment 에서 연결된다.
        - 기존에는 `MainActivity`에서 권한체크, uri 목록 얻어왔으나 해당 목록을 필요로 하는 List fragment 가 아님
        - 따라서 List Fragment 가 Uri를 받아오거나 직접 **권한체크/목록 가져오기** 방법이 있고, 현재는 후자의 방법으로 진행
4. ### 다른 Fragment 로 이동하기 (선택한 이미지 상세보기)
    - Photo Adapter 에 인자로 함수를 넘겨주고, 설정한 **id** 를 이용하여 `navigate` 한다.
    - *[PhotoListFragment.kt](./app/src/main/java/com/example/gallery2/PhotoListFragment.kt)* : `Bundle` 을 이용하여 데이터를 전달한다.
        - 기본 객체가 아니므로 `parcelable` 로 보내야한다.
        - 이후 `get` 을 통해 불러온다.
    - *[PhotoDetailFragment.kt](./app/src/main/java/com/example/gallery2/PhotoDetailFragment.kt)* : `Bundle` 을 통해 전달된 데이터 꺼내기
        - `onCreate` 에서 **getParcelable** 을 이용하여 `key` 로 원하는 데이터 가져오기
5. ### Fragment 에 이미지 연결하기
    - *[fragment_photo_detail.xml](./app/src/main/res/layout/fragment_photo_detail.xml)* 를 `Img View` 로 채운다.
    - 전달받은 `Uri` 를 `Image View` 에 연결한다.

        ```kotlin
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)

                binding.photoView.load(uri)
            }
        ```
    - 위와 같이 연결할 수 있다.
        - 현재 `Image View` 의 **id** 를 "photo_view" 로 설정하였는데, Camel 표기법에 의해 `photoView` 로 접근가능하다.
6. ### 이미지 확대/축소기능 추가하기
    - 라이브러리 설치 사이트를 이용하여 **확대/축소** 기능 추가
        - *[settings.gradle](./settings.gradle)* 에 다음 구문 추가
            ```
            maven { url "https://www.jitpack.io" }
            ```
    - 이후 관련 라이브러리 설치
        - *[build.gradle(app)](./app/build.gradle)* 에 `dependency` 추가
            ```
            // photoView
            implementation 'com.github.chrisbanes:PhotoView:2.3.0'
            ```
    - *[fragment_photo_detail.xml](./app/src/main/res/layout/fragment_photo_detail.xml)* : `ImageView` 를 `PhotoView` 로 변경
        - <ImageView> 에서 <com.github.chrisbanes.photoview.PhotoView> 로 . .
