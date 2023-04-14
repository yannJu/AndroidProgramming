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
   - *[익명함수(ex05_lambda.kt)](./src/main/kotlin/chapter05/ex05_lambda.kt)* 
     - `익명 함수`는 **->** 를 이용하여 **매개변수** 와 **함수 본체** 를 구분
     - **함수 본체**의 마지막 라인에 값이 있거나 표현식인 경우 `리턴값`으로 처리한다.
     - `count` 가 내부적으로 **loop** 를 돌면서 카운트
       - `check` 라는 함수가 매우 간결하며, 다른 곳에서 **재사용** 이 이루어지지 않는 경우이므로 **익명함수**로 구현하자 . .
     - `익명 함수` 에 매개변수가 없다면 구분자인 **->** 도 함께 생략
     - `{}()` 와 같은 형태로 `익명함수` 를 **호출** 할 수 있다.
   - *[함수타입(ex05_type.kt)](./src/main/kotlin/chapter05/ex05_type.kt)*
     - `(매개변수 목록) -> 리턴타입 = 익명함수` 구조로 구현
       - **매개변수**가 하나일 경우 익명함수의 **매개변수** 를 생략 후 `대명사(it)`으로 대체 가능 
     - `함수 타입` 또한 **타입 추론** 이 가능
       - 단 `함수 타입`이 생략된 경우 **매개변수**는 생략 불가
   - *[함수를 인자로 받는 함수 정의(ex05_exercise01.kt)](./src/main/kotlin/chapter05/ex05_exercise01.kt)*
     - `익명함수` 를 둘러싼 괄호를 지울 수 있다. 
     - 앞의 인자만 괄호를 씌우고 **단축 문법** 사용
   - *[기존함수를 인자로 받는 함수(ex05_exercise02.kt)](./src/main/kotlin/chapter05/ex05_exercise02.kt)
     - 기존함수 참조는 `::` 를 붙여주어야 한다.
6. ### [null 안전과 예외](./src/main/kotlin/chapter06)
    - Kotlin 에서는 `null` 의 사용여부를 **설정** 할 수 있다.
      - **default** 는 `null` **불가능**으로 지정되어있다
    - *[ex06_null.kt](./src/main/kotlin/chapter06/ex06_null.kt)*
      - 변수 선언시 타입뒤에 **?** 를 붙이면 `null` **가능** 으로 지정
      - `?.` 연산자 : **?**앞의 인자가 `null` 이 아니면 **.** 이후 실행, `null` 이면 실행하지 않고 `null` 을 `return`
      - `let` 함수를 이용하여 앞에서 진행된 함수(**수신객체**) 를 **인자**로 받아온다.
      - `!!` 연산자 : `null` 이 될 수 없음을 단언 ▶ 개발자의 책임
      - `?:` 연산자 : `null` 이면 **오른쪽** 값이 리턴
      - 타입이 `null` 을 허용할때 항상 `?.` 연산자를 써야한다 . .
        ```kt
        fun main(args: Array<String>) {
            var test: String? = "hello"
            print(test.capitalize())
        }
        ``` 
      - 위와 같이 구현하면 `Error` ,, `test?.capitalize()` 와 같이 작성해야한다.