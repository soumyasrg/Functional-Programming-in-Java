# Exercise 12

Find Functional Interface behind the second argument of reduce method. Create an implementation for the Functional Interface.
```java
int sum = numbers.stream()
	.reduce(0, Integer::sum);
```

# Exercise 13

Do Behavior Parameterization for the mapping logic.
```java
List<Integer> squaredNumbers =  numbers.stream()
					.map(x -> x*x)
					.collect(Collectors.toList());
```
# Jshell Commands:
```java
Supplier<String> supplier = () -> {return "Ranga";};

Consumer<String> consumer = (str) -> { System.out.println(str);};

multiple statements in lamda expressions
Consumer<String> consumer = (str) -> { System.out.println(str); System.out.println(str);};
```
