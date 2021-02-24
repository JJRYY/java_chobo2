package java_chobo2.ch13;

public class ThreadEx06 {

	public static void main(String[] args) throws InterruptedException {
		Thread01 th1 = new Thread01();
		System.out.println("우선순위 th1 " + th1.getPriority());
		
		Thread02 run = new Thread02();
		Thread th2 = new Thread(run);
		th2.setPriority(9);
		System.out.println("우선순위 th2 " + th2.getPriority());
		
		th1.start();
		th2.start();
		
		
	}

}
