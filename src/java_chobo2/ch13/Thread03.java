package java_chobo2.ch13;

public class Thread03 implements Runnable {
	static boolean autoSave = false;
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (autoSave = true) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		System.out.println("작업 파일이 자동 저장되었습니다.");
		
	}

}
