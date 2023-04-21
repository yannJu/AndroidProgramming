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
        - ``