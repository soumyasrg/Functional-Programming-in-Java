if you have trouble runing JShell
use: https://tryjshell.org/

## JShell Commands Executed

```java

System.out.println("Ranga")

List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

numbers.stream().reduce(0, (x,y)->x+y) // 77
numbers.stream().reduce(0, (x,y)->x) // 0
numbers.stream().reduce(0, (x,y)->y)
numbers.stream().reduce(0, (x,y)-> x>y ? x:y) // 15 (largest of all items)

numbers.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x:y) // 15 (largest of all items)
numbers.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? y:x) // Integer.MIN_VALUE
numbers.stream().reduce(Integer.MAX_VALUE, (x,y)-> x>y ? y:x) // 2 (minimum of all items)
```

# Exercise 7
Square every number in a list and find the sum of squares
```java
numbers.stream().reduce(0, (x,y) -> x*x + y*y) --> wrong 
0^2 + 12^2
144^2 + 9^2 --> we want 12^2

// correct way
numbers.stream().map(x -> x*x).reduce(0, Integer::sum) 
```
# Exercise 8 
Cube every number in a list and find the sum of cubes
```java
// for cubes sum
numbers.stream().map(x -> x*x*x).reduce(0, Integer::sum) 
```
# Exercise 9 

Find Sum of Odd Numbers in a list
```java
numbers.stream().filter(x -> x%2==1).reduce(0, Integer::sum)
```
# Exercise 10

Find Sum of Even Numbers in a list
```java
numbers.stream().filter(x -> x%2==0).reduce(0, Integer::sum)

// prints distinct elements
numbers.stream().distinct().forEach(System.out::println) 
12
9
13
4
6
2
15

// prints in sorted order
numbers.stream().sorted().forEach(System.out::println) 

// distinct values in sorted order
numbers.stream().distinct().sorted().forEach(System.out::println) 

List<String> courses = List.of("Spring", "Spring Boot", "API" , 
								"Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

// prints strings in sorted order in alphabetical order
courses.stream().sorted().forEach(System.out::println) 

// using custom comparator --> increasing order (natural order)
//same output as above
courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println)

// reverse order
courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println)

// sorts by length(increasing length)
courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println)

// list courses lengths
courses.stream().map(x -> x.length()).collect(Collectors.toList())
```