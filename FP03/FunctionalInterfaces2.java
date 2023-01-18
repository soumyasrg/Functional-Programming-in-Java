package programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		//we can put type for one parameter
		//howwever it is not necessary to mention type for parameter
		// this is called type inference, lamda expression gets the type automatically
		//from the generic type mentioned in the <>
		Predicate<Integer> isEvenPredicate = (Integer x) -> x % 2 == 0;

		Function<Integer, Integer> squareFunction = x -> x * x;
		
		Function<Integer, String> stringOutputFunction = x -> x + " ";

		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

		BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
		
		//Supplier -> No input but it Return Something
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000); // returns a random  value 0 -> 1000(exclusive)
		};
		// Supplier<Integer> integerSupplier = () -> 2;
		
		System.out.println(randomIntegerSupplier.get());
		
		//unary operator -> takes 1 parameter and returns result of same type as output
		UnaryOperator<Integer> unaryOperator = x -> 3 * x;
		System.out.println(unaryOperator.apply(10)); //30
		
		// in predicate there was 1 input and output was boolean
		//but in bipredicate 2 inputs and outputs boolean
		BiPredicate<Integer, String> biPredicate = (number,str) -> {
			return number<10 && str.length()>5;
		};

		System.out.println(biPredicate.test(10, "in28minutes"));
		
		//BiFunction -> 2 inputs and returns 1 output
		BiFunction<Integer, String, String> biFunction = (number,str) -> {
			return number + " " + str;
		};
		
		System.out.println(biFunction.apply(15, "in28minutes"));
		
		// BiConsumer --> takes 2 inputs
		BiConsumer<Integer, String> biConsumer = (s1,s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};
		
		biConsumer.accept(25, "in28Minutes");
		
		//object of wrapper class Integer
		BinaryOperator<Integer> sumBinaryOperator2 = (x, y) -> x + y;
		
		//ww donot have to deal with auto-boxing and unboxing-things
		//the IntBinaryOperator handles lamda with only int primtive type
		IntBinaryOperator intBinaryOperator = (x,y) -> x + y;
		//so it is recommended if you are dealing with primtives
		// then use primtive type functional interfaces
		
		//A list of Int related Functional interfaces:
		//IntBinaryOperator
		//IntConsumer
		//IntFunction
		//IntPredicate
		//IntSupplier
		//IntToDoubleFunction
		//IntToLongFunction
		//IntUnaryOperator
		
		//Long, Double, Int
		

		//numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(sysoutConsumer);

		//int sum = numbers.stream().reduce(0, sumBinaryOperator);
	}
}
