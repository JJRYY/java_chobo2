package java_chobo2.ch11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class HashSetEx {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		Random rnd = new Random(1234);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			int r = rnd.nextInt(5);
			list.add(r);
			set.add(r);
		}
		
		System.out.println(list); // List는 값 중복 가능
		System.out.println(set); // Set은 값 중복 불가능
	}

}
