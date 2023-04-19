## Android Programming _ BmiCalculator 🥃

0. 이전의 것들을 활용하여 **비만도 계산기** 만들기
1. ### [이미지 불러오기](./app/src/main/res/drawable)
    - *[drawable](./app/src/main/res/drawable)* 에서 **New** > vectorAsset 으로 이미지를 불러온다.
        - imageAsset : 비트맵 이라서 깍두기 현상 발생 가능
        - vectorAsset : 이미지파일로 가져오므로 화면깨짐이 없다.
    - vectorAsset 은 이후 이미지 크기 변환, 색 변경 등에 문제가 없다.
2. ### [Intent에서 데이터 값 꺼내기(ResultActivity.kt)](./app/src/main/java/com/example/bmicalculator/ResultActivity.kt)
    - `get[타입]Extra` 를 이용하여 **Intent** 로 넘어온 값 꺼내기
        - 첫번째 인자에 값이 없다면 두번째 인자 값으로 전달
3. ### [BMI 계산 후 적절한 이미지를 화면에 띄워줌(ResultActivity.kt)](./app/src/main/java/com/example/bmicalculator/ResultActivity.kt)
    -`when` 절을 이용하여 조건문 작성
    - `binding.imageView.setImageResource` 을 통해 *[drawable](./app/src/main/res/drawable)* 내의 이미지를 **ImageView** 로 표시
4. ### [종료 후 이전의 값 복원하기(MainActivity.kt)](./app/src/main/java/com/example/bmicalculator/MainActivity.kt)
    - 앱을 다시 실행한 경우 마지막으로 입력했던 값이 사라지게 된다.
        - 이를 복원하기 위해 **데이터 저장/읽기** 기능을 사용
    - `sharedPreference` 를 통해 키/값 의 쌍으로 저장된다.
    - *[build.gradle](./app/build.gradle)* 의 `dependencies` 에 **preference** 라이브러리(패키지) 를 추가
        - 안드로이드는 라이브러리가 **패키지** 단위로 구성되어있다.

        ```kotlin
        dependencies {
            ...
            implementation 'androidx.preference:preference-ktx:1.2.0'
        }
        ```
    - 이후 데이터 관리를 위한 **편집기** 호출
        - `androidx` 의 PreferenceManager를 호출 해야 한다!

        ```kotlin
            val pref = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = pref.edit()
        ```
    - **편집기** 를 이용하여 `putExtra` 를 통해 데이터 저장
        - apply를 통해 저장
    - 결과 버튼이 클릭되면 `saveData` 실행
    - 복원은 `onCreate` 될때 `loadData` 실행
    - 내부 규칙에 의해 **파일** 처리가 진행
        - 안드로이드 스튜디오 우측 하단 > `Device File Explorer`
        - 안드로이드 기기의 파일시스템 확인 가능
        - data > data > com.example.[프로젝트명] > shared_prefs 에 `xml` 파일로 저장되어있다.

        ![](https://github.com/yannJu/AndroidProgramming/blob/master/img/a3_img.PNG)