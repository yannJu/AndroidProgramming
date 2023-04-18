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
	---