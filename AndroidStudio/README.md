## Android Programming _ Android Studio 🏴

0. ### [UIDesign. . ](./)
	- `Content View` 는 기기와 상호작용을 하는 화면을 의미
	- *[activity_main.xml](./)* 에서 화면 소스코드를 나타낸다.
		- `ConstraintLayout` 은 실제 눈으로는 안보이지만 **하위객체** 들을 관리
		- 그 안에 여러 `View` 들이 들어있다.
	- 우측 상단에 **Design** 선택
		- **Code** 는 View의 소스코드를 볼 수 있다.
	- **Palette** 에서 원하는 기능들(버튼, 이미지 . . )을 가져와서 화면에 추가할 수 있다.
		- `wrap_content` 는 현재 attribute의 크기에 맞추겠다는 의미이다.
		- `0dp` 는 전체 크기에 맞추겠다는 의미이다.
		- `textAppearance` 를 이용하여 글자 크기 설정 가능 → `textSize` 는 **글자크기** 를 직접 숫자로 설정해야해서 번거롭다. 
		- `Image` 를 추가할 수 있다.
			- 로컬에 있는 이미지 또한 **Import** 가능하다.
			- **Import** 후에는 *[/drawable](./)* 에 저장된다.
	- 이와 같이 여러 `View`들을 쉽게 화면에 추가할 수 있다.
1. ### [UIDesign_Basic](./UIDesign_Basic)
	- 액티비티에서 `View` 컴포넌트를 제어할 수 있다.
		- `findViewById<TextView>()` 를 이용하여 `View` 컴포넌트를 가져온다.
		- 요즘은 `findViewById`로 뷰 참조 획득의 대안으로 **뷰 바인딩** 이 권장사항
	- `View` 컴포넌트를 이용하여 **이벤트 핸들링**
	- `LogCat` 사용
2. ### [Calculator](./Calculator)
	- **1** 을 이용하여 계산기 만들기

	![](https://github.com/yannJu/AndroidProgramming/blob/master/img/Screenshot_20230418-134559_Calculator.jpg)|![](https://github.com/yannJu/AndroidProgramming/blob/master/img/Screenshot_20230418-135017_Calculator.jpg)
	--- | --- |
3. ### [Activity](./Activity)
	- `Activity` 의 **Life Cycle** 확인
	- `Main Activity` 에서 다른 액티비티로 전환
	- 다른 액티비티에 **intent** 를 보내고 값을 반환받을 수 있다.
	- 여러개의 액티비티 운영
4. ### [Toast](./Toast)
	- 알림창을 띄우는 기능
	- `Activity` 를 커스텀하여 **Toast** 로 띄울 수 있다.
5. ### [비만도계산기](./BmiCalculator)
	- **키** 와 **몸무게** 를 입력받아 비만도를 계산
	- 비만도에 적절하게 이미지를 변경하여 출력
	- 마지막에 작성한 데이터 값 **파일** 에 저장 > shared preference
6. ### [Timer](./Timer)
	- 스톱워치 기능 만들기
	- 안드로이드에서의 스레드 기능 이용하기

	![](https://github.com/yannJu/AndroidProgramming/blob/master/img/a3_img1.jpg)|![](https://github.com/yannJu/AndroidProgramming/blob/master/img/a3_img2.jpg)
	--- | --- | 
7. ### [CustomWeb](./CustomWeb)
	- 나만의 웹 브라우저 만들기 . . .

8. ### [Menu](./Menu)
	- 안드로이드 업데이트 이후 상단바 사라지게 되었다 . . .
		- 메뉴를 띄우기 위해 다른 프로젝트 생성
	- ContextMenu 설정

	![](https://github.com/yannJu/AndroidProgramming/blob/master/img/a4_img.jpg)
9. ### [RecyclerView](./RecyclerView)
	- 상세보기가 가능한 `CardView` 생성
	- 동적으로 `Data` 추가
	- 가로/세로 모드 여부에 따라 다른 **레이아웃** 적용
10. ### [Gallery](./Gallery)
	- **전자액자**  만들기
	-  `데이터` 권한 주기 > **query** 만들기
	- `Fragment` 사용
		- 프래그먼트 생명 주기
	- 좌우 슬라이드 가능한 뷰 만들기
	- 사용하고있는 디바이스의 갤러리 이미지 출력 > **갤러리 어플** 구현

	![](https://github.com/yannJu/AndroidProgramming/blob/master/img/a5_img%20(2).jpg)