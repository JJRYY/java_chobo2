package java_chobo2.ch12;

class Parent {
	
	void parentMethod() {}
	
}

class Child extends Parent{
//	@Override
//	void parentmethod() {} // 애너테이션을 쓰면 빨간줄 생김
	
}

@SuppressWarnings("serial") // 컴파일러의 특정 경고메시지가 나타나지 않게 해준다.
public class ExceptionEx extends Exception {

}

