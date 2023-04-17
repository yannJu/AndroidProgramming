## Android Programming _ Android Studio 🏴

0. ### [UIDesign](./)
	- `Content View` 는 기기와 상호작용을 하는 화면을 의미
	- *[activity_main.xml](./res/layout/activity_main.xml)* 에서 화면 소스코드를 나타낸다.
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
			- **Import** 후에는 *[/drawable](./UIDesign/app/src/main/res/drawable/)* 에 저장된다.
	- 이와 같이 여러 `View`들을 쉽게 화면에 추가할 수 있다.
1. ###