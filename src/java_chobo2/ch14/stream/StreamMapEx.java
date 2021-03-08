package java_chobo2.ch14.stream;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {

	public static void main(String[] args) {
//		extracted01();
//		extracted02();
		
		IntStream intStream = new Random().ints(1,46); // 1~45사이의 정수(46은 포함안됨)
		Stream<Integer> integerStream = intStream.boxed();     // IntStream → Stream<Integer>
		integerStream.limit(6).forEach(s -> System.out.println(s)); // limit이 없으면 무한 스트림
		
		Stream<String> lottoStream = new Random().ints(1, 46)
				.distinct().limit(6).sorted()
		        .mapToObj(i -> i + ","); // IntStream → Stream<String> 
		lottoStream.forEach(System.out::print); // 12,14,20,23,26,29,

		
	} // end of main

	public static void extracted02() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("김자바", 3, 180));
		
		Stream<Student> stdStream = list.stream();
		
		// 스트림을 기본 스트림으로 변환
		Stream<Integer> stdScoreStream = stdStream.map(Student::getTotalScore);
//		stdScoreStream.forEach(System.out::println);
		int total = stdScoreStream.reduce(0, (a, b) -> a + b);
		System.out.println(total);
		
		stdStream = list.stream();
		IntStream stdScoreIntStream = stdStream.mapToInt(Student::getTotalScore);
		total = stdScoreIntStream.max().getAsInt(); // 최대값
		System.out.println(total);
	}

	public static void extracted01() {
		List<File> list = new ArrayList<File>();
		list.add(new File("Ex1.java"));
		list.add(new File("Ex1.bak"));
		list.add(new File("Ex2.java"));
		list.add(new File("Ex1"));
		list.add(new File("Ex1.txt"));
		
		
		// map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<File> fileStream = list.stream();
		Stream<String> fileNameStream = fileStream.map(File::getName);
//		fileNameStream.forEach(System.out::println);
		
		System.out.println();
		
		list.stream().map(File::getName)
		.filter(s -> s.indexOf('.') != -1)
		.peek(System.out::println)
		.map(s -> s.substring(s.indexOf('.') + 1))
		.peek(s -> System.out.printf("extension : %s%n", s))
		.map(String::toUpperCase)
		.peek(s -> System.out.printf("upper : %s%n", s))
		.distinct()
		.forEach(System.out::print);
		
		System.out.println();
		
//		// 위의 스트림 예를 스트림을 쓰지 않는 걸로 변경한다면 아래와 같다.
//		Set<String> s = new HashSet<>();
//		for (File f : list) {
//			String ext = f.getName();
//			if (ext.indexOf('.') != -1) {
//				s.add(ext.substring(ext.indexOf('.') + 1).toUpperCase()); 
//			}
//		}
//		System.out.println(s);
//		
//		File file = new File("test.java");
//		String fileName = file.getName(); // "test.java"
//		int idx = fileName.indexOf("."); // 4
//		System.out.println(fileName + " : " + idx);
//		System.out.println(fileName.substring(idx + 1)); //substring은 그 위치에서부터 끝까지 출력
	}

}
