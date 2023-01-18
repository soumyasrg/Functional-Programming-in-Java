package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		List<Integer> evenNumbersOnly = numbers.stream()
										.filter(x -> x%2==0)
										.collect(Collectors.toList());
		System.out.println(evenNumbersOnly);
		
		List<Integer> squaredNumbers = squareList(numbers);
		//1 , 5, 6
		//1 -> 1
		//5 -> 25
		//6 -> 36
		System.out.println(squaredNumbers);

		int sum = addListFunctional(numbers);
		// agg  next.no
		// 0    12
		// 12   9 
		// 21   13
		// 34   4
		// 38   6
		// 44   2
		// 46   4
		// 50   12
		// 62   15
		// 77
	
		System.out.println(sum);

	}
	
	private static List<Integer> squareList(List<Integer> numbers) {
		
		return numbers.stream()
				.map(number -> number * number)
				.collect(Collectors.toList());
	}

	private static int sum(int aggregate, int nextNumber) {
		System.out.println(aggregate + " " + nextNumber);
		return aggregate + nextNumber;
	}

	private static int addListFunctional(List<Integer> numbers) {
		//Stream of number -> One result value
		//Combine them into one result => One Value
		// initial value -> 0 (acts as intial aggregate) and 
		// FP02Functional::sum to perform operation(reduce)
		// it reduces to single result value using function sum()
		int sum1 = numbers.stream()
					  .parallel()
					  .reduce(0, FP02Functional::sum); //method ref.

		int sum2 = numbers.stream()
					  .parallel()
					  .reduce(0, (x,y) -> x + y); //using lambda exp.

		int sum3 = numbers.stream()
					  .parallel()
					   .reduce(0, Integer::sum);

		// all sum1, sum2, sum3 are same

		return sum3;
	}
}
