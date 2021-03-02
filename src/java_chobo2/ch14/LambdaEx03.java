package java_chobo2.ch14;

@FunctionalInterface // 메소드 하나만 있는 인터페이스인 경우에 사용
interface MyFunction {
	void myMethod();
}
public class LambdaEx03 {

	public static void main(String[] args) {
		MyFunction f = () -> System.out.println("MyMethod");
		aMethod(f);
		
		aMethod(() -> System.out.println("myTwoMethod"));
	}
	
	public static void aMethod(MyFunction f) {
		f.myMethod();
	}

}
