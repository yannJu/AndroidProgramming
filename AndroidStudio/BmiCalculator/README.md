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