```java
List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices",
								"AWS", "PCF","Azure", "Docker", "Kubernetes");

courses.replaceAll( str -> str.toUpperCase()) //Error
// as List.of() creates a immutable collection

List<String> modifyableCourses = new ArrayList(courses);
// creates a modifyable list

modifyableCourses.replaceAll(str -> str.toUpperCase())
modifyableCourses // prints all courses in uppercase

modifyableCourses.removeIf(course -> course.length()<6)
// remove all courses whose length is less than 6
```