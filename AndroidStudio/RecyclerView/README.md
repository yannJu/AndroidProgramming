## Android Programming _ RecyclerView

0. ### [Recycler View]
    - 여러개의 `View` 리스트로 이루어진 액티비티가 있는데, 특정 `View`를 클릭해 상세보기 할 수 있다 . .
    - 여러개의 `Data`가 있는 **Data List** 가 있다. → Array, DB, . . 등 데이터 소스는 상관 없다.
    - `Adapter`라는 객체와 연동된다. → 표준에 맞지 않는 어떠한 것을 표준에 맞게 변환해주는 장치.
        - 데이터 소스가 쓸 때 마다 다른데, `Adaptor` 가 `Recycler View` 의 표준에 맞추어 변환해준다.
        - 따라서 데이터와 정보 1개(Recycler View 의 단위) 를 binding
    - `Layout Manager` 를 통해 *Grid*, *계단형* .. 등 형태 를 정의할 수 있다.
1. ### [Kotlin_data클래스]
    - 데이터 보관용 클래스
    - 키워드로 클래스 앞에 `data`를 붙여준다.
    - 일반 클래스 만들 듯 구성
2. ### [RecyclerView App(MainAdapter.kt)](./app/src/main/java/com/example/recyclerview/MainAdapter.kt)
    - RecyclerView 를 위한 `Adapter` > `Adapter<T>` 를 상속받는다
        - `onCreateViewHolder` : `View Holder`를 생성 후 리턴
        - `onBindViewHolder` : `View Holder` 위젯의 데이터 설정
    - `Adapter` 클래스에는 **inflater** 가 없으므로 생성해야 한다. > `LayoutInflater.from(parent.context)`
        - `View Holder` 생성시 매개변수로 들어오는 **parent** 는 `Recycler View`
        - 바로 **parent** 에 넣어줄 건지에 대한 여부로 true/false 설정
3. ### [Adapter와 Recycler View 연결]()
    - 데이터를 어떤식으로 보여줄지에 대한 Layout Manager 설정
    - `MainAdapter` 를 바인딩하여 할당
4. ### [데이터를 어댑터에서 분리(MainActivity.kt)](./app/src/main/java/com/example/recyclerview/MainActivity.kt)

        ```
         var items: MutableList<MainData> = mutableListOf(
                MainData("Title1", "Content1"),
                MainData("Title2", "Content2"),
                MainData("Title3", "Content3")
            )
        ```
    - 위와 같이 정의해 둔 `items` 를 `MainActivity` 에서 정의하고 `Adapter` 의 인자로 넘겨준다.
5. ### [가로모드/세로모드 여부 확인]
    - `windowManager.defaultDisplay.rotation == Surface.ROTATION_90` 와 같이 **0, 90, 180, 270** 을 설정하여 가로/세로모드 구분을 할 수 있다.

        ![]()
6. ### [상세보기 기능 추가하기(MainAdapter.kt)](./app/src/main/java/com/example/recyclerview/MainAdapter.kt)
    - `MainAdapter` 에서 이벤트 핸들러를 동작시킨다.
    - `onBindViewHolder` 에서 기능을 할당해준다.
        - 각 `Holder`의 `ItemView.root` > **CardView** 를 의미
        - 따라서 **CardView** 가 클릭되면 동작되도록 한다. ▶ `setOnClickListener`
    - `MainAdapter` 의 매개변수로 `setOnClickListener`에 반응하는 함수를 넘겨준다.
        - 함수명 : (매개변수) -> [리턴값] 형태로 넘겨준다.
        - 리턴값이 없는경우 `Unit` 작성
    - **Card** 클릭 시 `Toast` 를 띄우도록 설정
7. ### [3초 간격으로 데이터 10개씩 추가하기(MainActivity.kt)](./app/src/main/java/com/example/recyclerview/MainActivity.kt)
    - `timer` 를 이용하여 `items` 에 데이터 추가 > 하지만 **화면** 에는 뜨지 않는다 . .!
        - 최초의 데이터만 화면에 나타나기 때문에 . .
    - `binding.contentLayout.mainList.adapter?.notifyDataSetChanged()` 를 이용하여 **변화** 를 체크
        - 이 때 View를 만든 `original thread` 만이 UI를 건들 수 있다.
        - 따라서 UI 가 작업을 할 수 있도록 `runOnUiThread` 내에서 진행
    -