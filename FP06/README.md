```java
List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices",
						"AWS", "PCF","Azure", "Docker", "Kubernetes");

// join the course names using ' ' (space) a separator
courses.stream().collect(Collectors.joining(" "))
// using , as separator
courses.stream().collect(Collectors.joining(","))

"Spring".split("")
// creates a char array

courses.stream().map(course -> course.split("")).collect(Collectors.toList())
// this doesnot work bcz courses.stream().map(course -> course.split("")) returns a stream of char arrays
// but we want a stream of chars

// using flatmap we can convert a stream of strings to stream of chars
// as each element of stream is replaced with content of mapped stream (Arrays::stream)
// for ex: ["a","r","r"] -> "a","r","r"
courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())

courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
// get all distinct chars 



List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices",
	"AWS", "PCF","Azure", "Docker", "Kubernetes");

List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices","
	AWS", "PCF","Azure", "Docker", "Kubernetes");

// returns tuples containing strings [[Spring,API], [API,Spring Boot], ...]
courses.stream().flatMap(course -> courses2.stream()
				.map(course2 -> List.of(course,course2)))
				.collect(Collectors.toList())

// returns tuples containing same strings; [[Spring,Spring], [API,API], ...]
courses.stream().flatMap(course -> courses2.stream()
				.map(course2 -> List.of(course,course2)))
				.filter(list -> list.get(0).equals(list.get(1))).collect(Collectors.toList())

// returns tuples containing strings not in set as previous (all other strings than being equal)
courses.stream().flatMap(course -> courses2.stream()
					.map(course2 -> List.of(course,course2)))
					.filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList())

// returns tuples containing strings having same length
courses.stream().flatMap(course -> 
					courses2.stream()
					.filter(course2 -> course2.length()==course.length())
					.map(course2 -> List.of(course,course2)))
					.filter(list -> !list.get(0).equals(list.get(1)))
					.collect(Collectors.toList())

why we use Fuctional programming?
for improving performance of code
// courses whose length more than 11 and convert to uppercase strings and then get the first such course
// findFirst() retruns first instance satisfying  a condition; it doesnot look furthur once it finds a instance
courses.stream()
	.filter(courses -> courses.length()>11)
	.map(String::toUpperCase)
	.findFirst()
	
	
// note: all intemediate opeations like stream(), peek(), filter() etc are lazy operations
// they are only executed when  execute the terminal operation; ex: findFirst()
// if you remove findFirst() you will find that nothing is printed on console

$4.findFirst() //Change $4 to your variable name

// to understand whats happening in background we use peek()
courses.stream().peek(System.out::println)
				.filter(courses -> courses.length()>11)
				.map(String::toUpperCase)
				.peek(System.out::println).findFirst()



courses.stream().peek(System.out::println)
				.filter(courses -> courses.length()>11)
				.map(String::toUpperCase)
				.peek(System.out::println)
				
							
// parallel progarmming in streams
why can't we parallelize the structural codes?
because structural codes have states which changes a lot of times
thatswhy we cannot run in 2 different cores

LongStream.range(0,1000000000).parallel().sum()
```

