## AndroidProgramming🚕

1. ### [Kotlin사용해보기(./src/main/kotlin/chapter01)](./src/main/kotlin/chapter01)
    - `함수`를 구현하여 **출력** 해보기
2. ### [변수, 상수, 타입(./src/main/kotlin/chapter02)](./src/main/kotlin/chapter02)
    - 코틀린은 `var (변수이름): INT = 5` 와 같이 변수 생성 가능
    - **var** : 변수 선언
      - `val` 을 사용하면 수정 불가/ `var` 을 사용하면 수정 가능
    - **const** : 상수 선언
      - `클래스` 나 **지역변수**로는 선언 불가 ▶ *전역 변수* 로만 가능하다
    - 타입이 **대문자** 로 되어있다. → `클래스`로 정의가 되어있다는 것이 특징
        - **참조형**으로 모든 데이터가 구성되어있다.
    - `타입추론` 을 지원 → 초기화 데이터가 반드시 있어야 한다. 
        - `타입추론`이 권장사항
3. ### [조건문과 조건식(./src/main/kotlin/chapter03)](./src/main/kotlin/chapter03)
   - *[ex03_if.kt](./src/main/kotlin/chapter03/ex03_if.kt)* : `if` 문을 이용하여 **조건문** 생성
   - *[ex03_if2.kt](./src/main/kotlin/chapter03/ex03_if2.kt)* : **대입문** 의 오른쪽에 **값** 을 둠으로 `조건식` 을 구현할 수 있다.
     - `조건식` 으로 쓸 경우 **else** 가 꼭 포함되어야 한다 ! 
     - 또한 `in ..` 을 통해 **범위**를 설정하여 조건을 줄 수 있다.
   - *[ex03_when.kt](./src/main/kotlin/chapter03/ex03_when.kt)* : `when` 과 `->` 을 이용하여 보다 간단하게 조건을 표현할 수 있다.
     - `case` 문 처럼 `when` 을 사용하여 `조건식` 구현
     - **else** 는 역시 꼭 써주어야 한다.
   - *[ex04_templateString.kt](./src/main/kotlin/chapter03/ex03_templateString.kt)*
     - `$변수`를 통해 템플릿 문자열을 사용할 수 있다.
     - `$if{}` 를 이용하여 조건식의 결과를 사용할 수 있다.
4. ### [함수(./src/main/kotlin/chapter04)](./src/main/kotlin/chapter04)
    - *[ex04_func.kt](./src/main/kotlin/chapter04/ex04_func.kt)*
      - `Main`함수에서는 여러가지 **생각**해야하는 문장들은 가급적 피해야 한다.
      - **default** 값 또한 인자가 가질 수 있다.
      - **하나의 문장** 으로 이루어진 함수는 `단일 표현식 함수`로 간소화 시킨다.
        - `return` 문과 `return type` 이 생략되어 있다.
      - `return type` 이 없으면 **Unit(=void)** 로 간주
      - `지명함수인자` 를 이용하면 **인자** 호출 순서가 달라도 된다.
    - *[ex04_overload.kt](./src/main/kotlin/chapter04/ex04_overload.kt)* : **오버로딩** 도 허용된다.
5. ### [익명 함수와 함수 타입](./src/main/kotlin/chapter05/)
    - `익명 함수`는 **->** 를 이용하여 **매개변수** 와 **함수 본체** 를 구분
    - **함수 본체**의 마지막 라인에 값이 있거나 표현식인 경우 `리턴값`으로 처리한다.
    - `count` 가 내부적으로 **loop** 를 돌면서 카운트
      - `check` 라는 