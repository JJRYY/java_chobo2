package java_chobo2.ch14.stream;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {

	public static void main(String[] args) {
		// 중간연산
//		extracted01(); // skip, limit, filter, distinct
		
//		extracted02(); // sorted
		
		extracted03();
		
	}

	public static void extracted03() {
		Stream<Student> stdStream = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("김자바", 3, 180)
				);
		
//		stdStream
//		.sorted(Comparator.comparing(Student::getBan)
//				.thenComparing(Comparator.naturalOrder()))
//		.forEach(System.out::println);
//				
//		stdStream
//		.sorted(Comparator.comparing(Student::getBan)
//				.thenComparing(Student::getTotalScore))
//		.forEach(System.out::println);
		
		stdStream
		.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Student::getName))
		.forEach(System.out::println);
	}

	public static void extracted02() {
		Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
		strStream.sorted().forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(Comparator.naturalOrder()) // 아스키 코드에서 대문자 우선순
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted( (s1, s2) -> s1.compareTo(s2))
		.forEach(s -> System.out.print(s + " "));
		System.out.println();

		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(String::compareTo)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(Comparator.reverseOrder()) // 역순 정렬
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER) // 대소문자 구분 없이 정렬
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER.reversed()) 
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

	public static void extracted01() {
		// 1. skip(), limit()
		System.out.println("1. 중간 연산 - skip(), limit()");
		IntStream.rangeClosed(1, 10)
		.skip(3)
		.limit(5)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// 2. filter, distinct()
		System.out.println("2. 중간 연산 - filter(), distinct()");
		IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 5)
		.distinct().forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		IntStream.rangeClosed(1, 20)
		.filter(i -> i % 2 == 0)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		IntStream.rangeClosed(1, 20)
		.filter(i -> i % 2 == 0)
		.filter(i -> i % 3 == 0)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
//		IntPredicate test = new IntPredicate() {
//			@Override
//			public boolean test(int value) {
//				return value % 2 == 0;
//			}
//		}; // 아래와 같이 바꿀수 있음
		IntPredicate p = t -> t % 2 == 0;
		IntStream.rangeClosed(1, 20)
		.filter(p)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

}
