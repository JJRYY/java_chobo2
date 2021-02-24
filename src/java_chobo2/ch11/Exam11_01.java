package java_chobo2.ch11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Exam11_01 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		
		HashSet set = new HashSet(list);
		System.out.println(set);
		TreeSet tset = new TreeSet(set);
		System.out.println(tset);
		Stack stack = new Stack();
		stack.addAll(tset);
		
		while(!stack.empty())
			System.out.println(stack.pop());
		
	}

}
