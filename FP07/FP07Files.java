package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP07Files {

	public static void main(String[] args) throws IOException {
		
		// lets now read the content 
		Files.lines(Paths.get("file.txt")).forEach(System.out::println);
		// Files.lines() returns stream of lines

		Files.lines(Paths.get("file.txt"))
		.map(str -> str.split(" ")) // split the lines into array of strings
		.flatMap(Arrays::stream) // to convert stream into strings(words)
		.distinct() // get the unique words
		.sorted() // sorted order
		.forEach(System.out::println); // print them
		
		Files.list(Paths.get(".")) // all files and directories present in root directory
			.filter(Files::isDirectory) // only directories
			.forEach(System.out::println);

	}

}
