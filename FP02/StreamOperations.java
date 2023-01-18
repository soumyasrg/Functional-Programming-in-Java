package programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02StreamOperations {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		numbers.stream()
			.distinct() //returns a Stream<T> Intermediate
			.sorted() //returns a Stream<T>
			.forEach(System.out::println); //returns void --> terminal operation

		List<Integer> squaredNumbers = numbers.stream()
				.map(number -> number * number) //returns a Stream<R> Intermediate
				.collect(Collectors.toList()); //List<R> type --> terminal operation

		List<Integer> evenNumbersOnly = numbers.stream()
				.filter(x -> x % 2 == 0) //returns a Stream<T> Intermediate
				.collect(Collectors.toList());
		
		int sum = numbers.stream()
				.reduce(0, (x,y) -> x*x + y*y); //T type --> terminal operation
		
		int greatest = numbers.stream()
				.reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x:y); // --> terminal operation
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

		List<String> coursesSortedByLengthOfCourseTitle = courses.stream()
				.sorted(Comparator.comparing(str -> str.length()))
				.collect(Collectors.toList());
		
	}
}
