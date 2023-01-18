
## JShell Commands Executed
```java
List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
numbers.stream() // holds instances of wrapper class Integer
// if we use reduce() then it will do auto-boxing and un-boxing
numbers.stream().map(x -> x*x).reduce(0, Integer::sum) // get the sum of squares
numbers.stream().map(x -> x*x*x).reduce(0, Integer::sum) // get the sum of cubes

// stream.of() -> creates a stream of Integers . this stream is of same type as previous stream
Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).count() // count no of elements 
// the above both ways use reference pipelines
// since the above ways does boxing and un-boxing everytime
// this approach is not recommended



// instead we can use following method for primitive types
// this below way uses primtive pipelines ; here IntPipeline
// since these are intPipelines we can do direct operations:
int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};
Arrays.stream(numberArray)
Arrays.stream(numberArray).sum()
Arrays.stream(numberArray).average()
Arrays.stream(numberArray).min()
Arrays.stream(numberArray).max()

// we create a stream first 10 numbers
IntStream.range(1,10)
IntStream.range(1,10).sum() // 10 excluded
IntStream.rangeClosed(1,10).sum() // 10 included

// in other way 
IntStream.iterate(1, e -> e + 2).limit(10).sum()
// 1 = starting element; e-> e+2:take each element and increment by 2; limit(10):limit no of elements to 10

IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::println).sum()
// peek() alows to view the elemnts without making any changes to it

IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println).sum()
// start with 2 and loop for all even numbers

IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum()
// first 10 powers of 2: 2^2, 2^3, 2^4, 2^5 and so on

IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList())
// since values stored in Stream are primitive so  we need to box them to Ineteger(wrapper class) before storing them in list
// store them into a list

// just like IntStream we have DoubleStream ,LongStream ,etc



// to get max in data types:

Integer.MAX_VALUE
Long.MAX_VALUE

// lets multiply all numbers from 1 to 50 ; the result is 0 as it exceeds INT MAX_RANGE value
IntStream.rangeClosed(1,50).reduce(1, (x,y)->x*y)

// still returns a -ve value
LongStream.rangeClosed(1,50).reduce(1, (x,y)->x*y)

// still returns a -ve value
LongStream.rangeClosed(1,50).reduce(1L, (x,y)->x*y)

// it finds perfectly
LongStream.rangeClosed(1,10).reduce(1, (x,y)->x*y)

// for 20 also works fine
LongStream.rangeClosed(1,20).reduce(1, (x,y)->x*y)

// returns -ve value (out of range)
LongStream.rangeClosed(1,40).reduce(1, (x,y)->x*y)

// using BigInteger we can solve the issue
LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply)
// mapToObj() creates a BigInteger object from each element
```




