package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FP03FunctionalInterfaces {
	 
	 boolean isEven(int x) {
	 	return x%2==0;
	 }
	 
	 int squared(int x) {
	 	return x * x;
	 }


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		//using lamda
		Predicate<Integer> isEvenPredicate = x -> x%2==0;

		//without lamda - USING ANONYMOUS CLASS
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			//we are overriding abstract method of functional interface
			// ABSTRACT METHOD INSIDE FUNCTIONAL INTERFACE IS CALLED FUNCTION DESCRIPTOR
			@Override
			public boolean test(Integer x) {
				return x%2==0;
			}
			
		};

		//using lamda
		Function<Integer, Integer> squareFunction = x -> x * x;

		//without lamda
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
			
		};

		Consumer<Integer> sysoutConsumer = System.out::println;

		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			public void accept(Integer x) {
				System.out.println(x);
			}
		};

		numbers.stream()
			.filter(isEvenPredicate)
			.map(squareFunction)
			.forEach(sysoutConsumer);
		// 144
		// 16
		// 36
		// 4
		// 16
		// 144
		
		numbers.stream()
			.filter(isEvenPredicate2)
			.map(squareFunction2)
			.forEach(sysoutConsumer2);
		// 144
		// 16
		// 36
		// 4
		// 16
		// 144


		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		//BinaryOperator<Integer> sumBinaryOperator = (x,y) => x + y;

		//exercise 12
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a + b;
			}
			
		};

		int sum1 = numbers.stream()
			.reduce(0, sumBinaryOperator);

		System.out.println(sum1); // 77
		
		int sum2 = numbers.stream()
			.reduce(0, sumBinaryOperator2);

		System.out.println(sum2); // 77
	}
}
