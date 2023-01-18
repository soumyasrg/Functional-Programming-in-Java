package programming;

import java.util.stream.LongStream;

public class FP06Parallelizing {
	
	public static void main(String[] args) {

		long time = System.currentTimeMillis();

		// 0, 1000000000 
		System.out.println(LongStream.range(0,1000000000).sum());//499999999500000000

		System.out.println(System.currentTimeMillis() - time); // 869 ms
		
		time = System.currentTimeMillis();

		// using parallel 
		System.out.println(LongStream.range(0,1000000000).parallel().sum());
		
		System.out.println(System.currentTimeMillis() - time); // //601 ms
	}

}
